import {useParams, Link} from 'react-router-dom'
import { useState } from 'react'
import { useAuth } from '../security/AuthContext'
import {returnHelloWorldName} from './api/HelloWorldApiService'


function WelcomeComponent() {

    const {username } = useParams()

    const authContext = useAuth()

    const [message, setMessage] = useState(null)

    function callHelloWorldRestApi(){
        console.log('callHelloWorldRestApi called')
        returnHelloWorldName(username, authContext.token)
        .then((response) => successfulResponse(response))
        .catch((error) => errorResponse(error))
        .finally(() => console.log("celanup"))
              
        

    }

    function successfulResponse(response){
        console.log(response)
        setMessage(response.data.message)
    }

    function errorResponse(error){
        console.log(error)
    }



    return (
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Go here</Link>
            </div>
            <div>
                <button className="btn btn-success" onClick={callHelloWorldRestApi}>
                    Call Hello World
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}

export default WelcomeComponent