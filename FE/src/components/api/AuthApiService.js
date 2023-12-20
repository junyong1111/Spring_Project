import { apiClinet } from "./ApiClient";

export const executeBasicAuthenticationsService
= (token) => apiClinet.get(`/basicauth`,
{
    headers: {
        Authorization: token
    }
})

export const executeJwtAuthenticationsService
    = (username, password) => apiClinet.post(`/authenticate`,
        {username, password})
