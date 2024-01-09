import { apiClinet } from './ApiClient';

export  const postSignupApi = 
(user) => apiClinet.post(`/user/signup`, user)