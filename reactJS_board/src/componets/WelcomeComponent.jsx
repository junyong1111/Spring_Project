import { useNavigate } from "react-router-dom";
import { getQuestionsNavi, createQuestionNavi } from "../navi/QuestionNavi";

export default function WelcomeComponent(){
    const navigator = useNavigate()
    return(
        <div className="container">
            <h1>WelcomeToMyPage</h1>
            <button className="btn btn-primary" style={{marginBottom:10}} onClick={
                () => console.log("회원가입 페이지 ")
            }>회원가입</button>
            <div className="container">
                <button className="btn btn-success" onClick={
                    () =>createQuestionNavi(navigator)
                } style={{marginRight:10}}>질문 등록</button>
                <button className="btn btn-dark" onClick={
                    () => getQuestionsNavi(navigator)
                } >질문 목록</button>
                
            </div>
        </div>
    )
}