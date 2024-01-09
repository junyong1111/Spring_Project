import { BrowserRouter, Routes, Route } from "react-router-dom"
import WelcomeComponent from "./WelcomeComponent"
import QuestionsComponent from "./QuestionsComponents"
import QuestionSaveComponent from "./QuestionSaveComponent"
import QuestionDetailComponent from "./QuestionDetailComponent"
import HeaderComponent from "./HeaderComponent"
import Signupcomponent from "./SignupComponent"
import "./SbbApp.css"

export default function SbbApp(){
    return(
        <div className="SbbApp">
            <BrowserRouter>
            <HeaderComponent/>
            <Routes>
            {/* <Route path ='/' element={<WelecomeComponent/>}></Route> */}
                <Route path="/" element ={<WelcomeComponent/>}></Route>
                <Route path="/signup" element ={<Signupcomponent/>}></Route>
                <Route path="/questions" element ={<QuestionsComponent/>}></Route>
                <Route path="/question/:id" element ={<QuestionDetailComponent/>}></Route>
                <Route path="/questions/save" element ={<QuestionSaveComponent/>}></Route>
                
            </Routes>
            </BrowserRouter>
            
        </div>
    )
}