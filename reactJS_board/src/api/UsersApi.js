import { apiClinet } from './ApiClient';

export  const postSignupApi = 
(user) => apiClinet.post(`/user/signup`, user)

export  const postLoginApi = 
(user) => apiClinet.post(`/user/login`, user)