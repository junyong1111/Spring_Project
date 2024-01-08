package com.springboot_board_jyp.springboot_borad.web.dto.answer;

import com.springboot_board_jyp.springboot_borad.domain.answers.Answer;
import com.springboot_board_jyp.springboot_borad.domain.questions.Question;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AnswerRequestDto {
    
    private String content;
    private Question question;

    @Builder
    public AnswerRequestDto(String content, Question question){
        this.content = content;
        this.question = question;
    }
    
    public Answer toEntity(){
        return Answer.builder()
        .content(content)
        .question(question)
        .build();
    }
}
