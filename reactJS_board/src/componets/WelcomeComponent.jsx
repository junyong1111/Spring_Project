import { useNavigate } from "react-router-dom";
import { getQuestionsNavi, createQuestionNavi } from "../navi/QuestionNavi";
import { goSignupPage } from "../navi/UserNavi";
import { useAuth } from "../security/AuthContext";

export default function WelcomeComponent(){
    const navigator = useNavigate()
    const authContext = useAuth()
    return(
        <div className="home-title">
            <h1>WelcomeToMyPage</h1>
            { authContext.isAuthencated &&
            <button className="Btn" style={{marginBottom:10}} onClick={
                () => goSignupPage(navigator)
            }>회원가입</button>
            }
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