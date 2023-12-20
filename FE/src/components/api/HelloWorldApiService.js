import { apiClinet } from './ApiClient';
// export default function returnHelloWorldBean(){
//     return(
//         axios.get('http://localhost:8080/hello-world-bean')
//     )
// }
export  const returnHelloWorldBean =
    () => apiClinet.get('/hello-world-bean')

export  const returnHelloWorldName = 
    (username, token) => apiClinet.get(`/hello-world/path-variable/${username}`,{
        headers:{
            Authorization: token
        }
})