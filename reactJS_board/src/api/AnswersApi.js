import { apiClinet } from './ApiClient';

// @PostMapping("api/v1/answer/save/{id}")
export  const postAnswerApi = 
(id, content) => apiClinet.post(`/api/v1/answer/save/${id}`,content, {
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })

// @GetMapping("/api/v1/question/{id}/answers")
export  const getAnswersApi = 
(id) => apiClinet.get(`/api/v1/question/${id}/answers`, id)