import { ErrorMessage, Field, Formik, Form } from "formik";
import { useNavigate } from "react-router-dom";
import { getQuestionsNavi } from "../navi/QuestionNavi";
import { postQuestionApi } from "../api/QuestionsApi";
import { useState } from "react";

export default function QuestionSaveComponent(){
    const navigator = useNavigate()
    const subject = useState("")
    const content = useState("")

    function onSubmit(values){
        const question = {
            subject : values.subject,
            content : values.content
        }
        console.log("CREATE API 연동!!")
        
        postQuestionApi(question)
        .then(
            (response) => {
                console.log(response)
                alert("글이 성공적으로 등록되었습니다.") // 팝업 메시지 추가
                getQuestionsNavi(navigator)
            }
        )
        .catch((error) => console.log(error))
        
    }

    function validate(values){
        let errors = {}

        if (values.subject=== null || values.subject ===''){
            errors.title = 'Enter a valid subject'
        }
        
        if (values.content.length <= 5){
            errors.content = 'Enter Content at least 5 character'
        }
     

        return errors
    }



    return(
        <div className="container">
        <h1>게시글 등록</h1>
        <div>
            <Formik initialValues={ {subject, content} }
            enableReinitialize = {true}
            onSubmit={onSubmit}
            validate={validate}
            validateOnChange={false} // save 버튼을 누를 때만 검증
            validateOnBlur={false} // save 버튼을 누를 때만 검증
            >
            {
                (props) => (
                    <Form>
                        <ErrorMessage
                            name='subject'
                            component='div'
                            className='alert alert-warning'
                        />
                        <ErrorMessage
                            name='content'
                            component='div'
                            className='alert alert-warning'
                        />
                         
                        <fieldset className="form-group">
                            <label>제목</label>
                            <Field type="text" className="form-control" name="subject" style={{width:'500px', margin: '0 auto'}}/>
                        </fieldset>

                        <fieldset className="form-group">
                            <label>내용</label>
                            <Field type="text" className="form-control" name="content" as="textarea"  style={{ width: '500px', height: '200px', margin: '0 auto'}}/>
                        </fieldset>

                        <div>
                            <button className='btn btn-success m-5' type="submit">저장</button>
                        </div>
                    </Form>
                )
            }
            </Formik>

        </div>
    </div>
    )
}