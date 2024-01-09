export function goMainPage(navigate){
    console.log("Home 페이지로 슈슝~");
    navigate('/');
}

export function getQuestionsNavi(navigate){
    console.log("Questions List 페이지로 슈슝~");
    navigate('/questions');
}

export function getQuestionNavi(navigate, id){
    console.log("Question 페이지로 슈슝~");
    navigate(`/question/${id}`);
}

export function createQuestionNavi(navigate){
    console.log("Question 생성 페이지로 슈슝~");
    navigate('/questions/save');
}
