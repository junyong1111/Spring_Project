import { apiClinet } from './ApiClient';

export  const getAllQuestionsApi = 
(page) => apiClinet.get(`/api/v1/questions`,{
    params:{
        page : page
    }
} )

export  const getQuestionApi = 
(id) => apiClinet.get(`/api/v1/question/${id}`,id)

export  const postQuestionApi = 
(question) => apiClinet.post(`/api/v1/questions`, question)