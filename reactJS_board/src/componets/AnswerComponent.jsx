import { useEffect, useState } from "react"
import { getAnswersApi } from "../api/AnswersApi"

export default function AnswerComponet({initialValues}){
    const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit', second: '2-digit' };
    const [answers, setAnswers] = useState([])
    
    async function getallAnswer() {
        try {
            const response = await getAnswersApi(initialValues);
            setAnswers(response.data); // 상태 업데이트
            console.log(answers)
            
        } catch (error) {
            console.log(error);
        }
    }
    useEffect(() => {
        getallAnswer();
    }, [initialValues]); 
    
    return(
        <div className="container" style ={{display:"flex",justifyContent:"center"}}>
            <h3>{initialValues}번 질문의 답변은 {answers.length}개 입니다.</h3>
            <ul>
                {answers.map((answer, index) => (
                    <li key={index} style={{width:'200px', margin: '0 auto'}}>
                        <p style={{margin: 0}}>내용: {answer.content}</p>
                        <p>작성일: {new Intl.DateTimeFormat('ko-KR', options).format(new Date(answer.createDate))}</p>
                    </li>
                ))}
            </ul>
        </div>
    )
    
}