import { createContext, useContext, useState } from "react";
import { executeJwtAuthenticationsService } from "../components/api/AuthApiService";
import { apiClinet } from "../components/api/ApiClient";

//1: Create a Context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

//2: Share the created context with other components
export default function AuthProvider({ children }) {

    //3: Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

   async function login(username, password){
    
    try{
        const response = await executeJwtAuthenticationsService(username, password)
        if(response.status === 200){
            const jwtToken = 'Bearer ' + response.data.token
            setAuthenticated(true)
            setUsername(username)
            setToken(jwtToken);

            apiClinet.interceptors.request.use(
                (config) => {
                    console.log('intercepting and adding a token')
                    config.headers.Authorization=jwtToken
                    return config
                }
            )
            return true
        }
        else{
            logout()
            return false
        }
    }
    catch(error){
        logout()
        return false
    }
    
   }

    function logout() {
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, login, logout, username, token}  }>
            {children}
        </AuthContext.Provider>
    )
} 