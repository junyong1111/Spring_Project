package com.springboot_board_jyp.springboot_board.web.dto.question;

import com.springboot_board_jyp.springboot_board.domain.questions.Question;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Getter

public class QuestionRequestDto {
    private String subject;
    private String content;

    @Builder
    public QuestionRequestDto(String subject, String content){
        this.subject = subject;
        this.content = content;
    }
    
    public Question toEntity(){
        return Question.builder()
        .content(content)
        .subject(subject)
        .build();
    }
}