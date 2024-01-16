import { useEffect, useState } from "react"
import { getAllQuestionsApi } from "../api/QuestionsApi"
import { createQuestionNavi, goMainPage } from "../navi/QuestionNavi"
import { Link, useNavigate } from "react-router-dom"
import { getAnswersApi } from "../api/AnswersApi";

export default function QuestionsComponent(){
    const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit', second: '2-digit' };
    const [questions, setQuestions] = useState([])
    const navigator = useNavigate()

    

    useEffect(
        () => getAllQuestions(),
        []
    )

    function getAllQuestions(){
        getAllQuestionsApi(0)
        .then(
            (response) => {
                setQuestions(response.data)
            }
        )
        .catch((error) => console.log(error))
    }

    return(
        <div className="container">
            <h2>질문 게시판</h2>
            
            <table className="table">
                <thead className="table-dark">
                    <tr>
                        <th>제목</th>
                        <th>내용</th>
                        <th>작성일시</th>
                    </tr>
                </thead>
                <tbody>
                    {
                       questions.map(
                            question => (
                                <tr key={question.id}>
                                    
                                    <td>
                                        <Link to={`/question/${question.id}`}>{question.subject}</Link>
                                        <span className="text-danger small ms-2">답변 개수 </span>
                                        
                                    </td>
                                    <td>{question.content}</td>
                                    <td><center>{new Intl.DateTimeFormat('ko-KR', options).format(new Date(question.createdate))}</center></td>                                    
                                </tr>
                            )
                        )
                    }
                </tbody>
            </table>

            {/* <div className="container">페이징 처리 해야 함
            <ul className="pagination justify-content-center">
                <li className="page-item"></li>
            </ul>
            </div> */}
            
            <div className="container" style={{textAlign:"center"}}>
                <button className="btn btn-success p"
                onClick={
                    () => goMainPage(navigator)
                }>Go Home</button>
                
                    <button className="btn btn-dark" style={{marginLeft:10}}
                    onClick={
                        () => createQuestionNavi(navigator)
                    }>질문 하기</button>
            </div>
        </div>
    )
}