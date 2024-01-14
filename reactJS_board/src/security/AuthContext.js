import { createContext, useContext, useState } from "react"
import { postLoginApi } from "../api/UsersApi"

//1: 문맥 생성
export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

//2: 다른 컴포넌트와 공유할 문맥 셋팅
export default function AuthProvider({ children }) {

    //3: Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

   async function login(User){
    
    try{
        const response = await postLoginApi(User)
            if (response.data ==="로그인 성공"){
                alert("로그인 되었습니다.") // 팝업 메시지 추가
                setAuthenticated(true)
                setUsername(User.username)
                return true
                // goMainPage(navigator)
            }
            else{
                alert("아이디 또는 비밀번호를 확인해주세요")
                logout()
                return false
            }
    }
    catch(error){
        logout()
        return false
    }
    
   };

    function logout() {
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
    };
    const value = {
        isAuthenticated,
        login,
        logout,
        username,
        token
    };

    return (
        // value
        <AuthContext.Provider value={ value }>
            {children}
        </AuthContext.Provider>
    )
} 