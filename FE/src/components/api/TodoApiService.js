import { apiClinet } from './ApiClient';


export  const retrieveAllTodosForuserApi = 
    (username) => apiClinet.get(`/users/${username}/todos`)

export  const deleteTodoApi = 
(username, id) => apiClinet.delete(`/users/${username}/todos/${id}`)

export  const retrieveTodoApi = 
    (username, id) => apiClinet.get(`/users/${username}/todos/${id}`)

export  const updateTodoApi = 
(username, id, todo) => apiClinet.put(`/users/${username}/todos/${id}`, todo)

export  const createTodoApi = 
(username, todo) => apiClinet.post(`/users/${username}/todos`, todo)