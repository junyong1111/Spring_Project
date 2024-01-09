package com.springboot_board_jyp.springboot_borad.web.dto.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot_board_jyp.springboot_borad.domain.questions.Question;
import com.springboot_board_jyp.springboot_borad.service.AnswerService;
import com.springboot_board_jyp.springboot_borad.web.dto.answer.AnswerResponseDto;

import lombok.Getter;

@Getter
public class QuestionResponseDto {
    @Autowired
    private AnswerService aService;
    
    private String content;
    private String subject;
    private Integer id;
    private List<AnswerResponseDto>answerlist = new ArrayList<AnswerResponseDto>();
    private LocalDateTime createdate;

    public QuestionResponseDto(Question entity){
        this.content = entity.getContnet();
        this.subject = entity.getSubject();
        this.id = entity.getId();
        this.createdate = entity.getCreateDate();
        this.answerlist = entity.getAnswerList().stream().map(AnswerResponseDto::new).collect(Collectors.toList());
    }    
}
