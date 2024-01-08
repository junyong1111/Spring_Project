package com.springboot_board_jyp.springboot_borad.web.dto.answer;

import java.time.LocalDateTime;

import com.springboot_board_jyp.springboot_borad.domain.answers.Answer;
import com.springboot_board_jyp.springboot_borad.domain.questions.Question;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Getter
public class AnswerResponseDto {
    private String content;
    private LocalDateTime createDate;
    private int id;

    @Builder
    public AnswerResponseDto(Answer entity){
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
        this.id = entity.getId();
    }

}
