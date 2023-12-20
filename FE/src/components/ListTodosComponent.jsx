import { useEffect, useState } from "react"
import {useNavigate} from 'react-router-dom'
import { useAuth } from "../security/AuthContext"
import {deleteTodoApi, retrieveAllTodosForuserApi} from './api/TodoApiService'

function ListTodosComponent() {

    const today = new Date()
    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay())
    const [todos,setTodos] = useState([])
    const [message,setMessage] = useState(null)
    const authContext = useAuth()
    const username = authContext.username
    
    const navigate = useNavigate()
    
    useEffect(
        () => refreshTodos(), []
    )
    
    function refreshTodos(){
        retrieveAllTodosForuserApi(username)
        .then((response)=> {
            // console.log(response)
            setTodos(response.data)
        }
        )
    
        .catch((error)=> console.log(error))
    }
    
                                    
    function deleteTodo(id){
        deleteTodoApi(username, id)
        .then(
            () => {
                setMessage(`Delete of todo with ${id}`)
                refreshTodos()
            }
        )
        .catch(
            (error) => console.log(error)
            ) 
    }

    function updateTodo(id){
       console.log(id + "update todo")
       navigate(`/todo/${id}`)
    }

    function createTodo(){
        
        navigate('/todo/-1')
     }


    
    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            
            {message && <div className="alert alert-warning">{message}</div>}

            
            <div>
                <table className="table">
                    <thead>
                            <tr>
                                <th>Description</th>
                                <th>Is Done?</th>
                                <th>Target Date</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>{todo.targetDate.toString()}</td>
                                    <td> < button className="btn btn-warning"
                                     onClick={() => deleteTodo(todo.id)}>
                                        DELETE</button></td>
                                    <td> < button className="btn btn-success"
                                    onClick={() => updateTodo(todo.id)}>
                                    Update</button></td>
                                </tr>
                            )
                        )
                    }
                    </tbody>

                </table>
            </div>
            <div><button className="btn btn-success"
            onClick={() => createTodo()}
            >Add Todo</button></div>
            
        </div>
    )
}

export default ListTodosComponent