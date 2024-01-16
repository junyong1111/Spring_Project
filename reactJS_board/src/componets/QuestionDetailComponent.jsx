import { useEffect, useState } from "react"
import { getQuestionApi } from "../api/QuestionsApi"
import { postAnswerApi } from "../api/AnswersApi"
import { useNavigate, useParams } from "react-router-dom"
import { getQuestionsNavi} from "../navi/QuestionNavi"
import { ErrorMessage, Field, Form, Formik } from "formik"
import AnswerComponet from "./AnswerComponent"

export default function QuestionDetailComponent(){
    const param = useParams()
    const [subject, setSubject] = useState()
    const [content, setContent] = useState()
    const navigator = useNavigate()

    useEffect(
        () =>getQuestion(),
        [param.id]
    )

    function getQuestion(){
        getQuestionApi(param.id)
        .then(
            (response) => {
                setSubject(response.data.subject)
                setContent(response.data.content)
            }
        )
        .catch((error) => console.log(error))
    }

    function onSubmit(values){
        const Answer = {
            content : values.answer,
        }
        // console.log(param.id)
        postAnswerApi(param.id, Answer.content)
        .then(
            (response) => console.log(response),
            alert("답변이 성공적으로 등록되었습니다."), // 팝업 메시지 추가
            window.location.reload("/")
        )
        .catch(
            (error) => console.log(error)
        )
    }
    function validate(values){
        let errors = {}

        if (values.answer=== null || values.answer ==='' || values.answer <=5){
            errors.title = 'Enter a valid answer'
        }

        return errors
        
    }
    return(
        <div className="container">
            <h1>{subject}</h1>
            <div>{content}</div>
            
            <Formik initialValues={{}}
            enableReinitialize={true}
            onSubmit={onSubmit}
            validate={validate}
            validateOnChange={false}
            validateOnBlur={false}
            >
                {
                    (props) =>(
                        <Form>
                            <ErrorMessage
                                name='answer'
                                component='div'
                                className="alert alert-warning"
                            >
                            </ErrorMessage>
                            
                            <fieldset>
                                <Field type="text" className="form-control" name="answer" as="textarea"  style={{ width: '500px', height: '200px', margin: '0 auto'}}/>
                            </fieldset>
                            <div style ={{display:"flex",justifyContent:"center"}}>
                                <button  className="btn btn-success m-2" type="submit" >답변 저장</button>
                            </div>
                        </Form>
                    )
                }

            </Formik>

            <AnswerComponet initialValues={param.id}/>
            
            <div style ={{display:"flex",justifyContent:"center"}}>
                <button className="btn btn-dark" onClick={
                    () => getQuestionsNavi(navigator)
                }>질문 목록으로</button>
            </div>
        </div>
    )
}