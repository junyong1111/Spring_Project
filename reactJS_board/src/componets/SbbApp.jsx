import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom"
import WelcomeComponent from "./WelcomeComponent"
import QuestionsComponent from "./QuestionsComponents"
import QuestionSaveComponent from "./QuestionSaveComponent"
import QuestionDetailComponent from "./QuestionDetailComponent"
import HeaderComponent from "./HeaderComponent"
import Signupcomponent from "./SignupComponent"
import LoginComponent from "./LoginComponent"
import "./SbbApp.css"
import AuthProvider, { useAuth } from "../security/AuthContext"

function AuthenticateRoute({children}){
    const authContext = useAuth();
    console.log(authContext)

    if (authContext.isAuthenticated){
        return children;
    }
    return <Navigate to="/"/>
}

export default function SbbApp(){
    return(
        <div className="SbbApp">
            <AuthProvider>
            <BrowserRouter>
            <HeaderComponent/>
            <Routes>
            {/* <Route path ='/' element={<WelecomeComponent/>}></Route> */}
                <Route path="/" element ={<WelcomeComponent/>}></Route>
                <Route path="/signup" element ={<Signupcomponent/>}></Route>
                <Route path="/login" element ={<LoginComponent/>}></Route>
                {/* 아래 페이지부터는 로그인 필요  */}
                <Route path="/questions" element ={
                <AuthenticateRoute>/
                <QuestionsComponent/>
                </AuthenticateRoute>
                 }></Route>
                <Route path="/question/:id" element ={<QuestionDetailComponent/>}></Route>
                <Route path="/questions/save" element ={<QuestionSaveComponent/>}></Route>
                
            </Routes>
            </BrowserRouter>
            </AuthProvider>
        </div>
    )
}