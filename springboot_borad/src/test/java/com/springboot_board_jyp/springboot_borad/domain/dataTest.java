package com.springboot_board_jyp.springboot_borad.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot_board_jyp.springboot_borad.service.QuestionService;
import com.springboot_board_jyp.springboot_borad.web.dto.question.QuestionRequestDto;

@SpringBootTest
public class dataTest {
    @Autowired
    private QuestionService qService;

    @Test
    void 테스트_데이터_만들기(){
        for(int i=1; i<= 300; i++){
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content ="Empty";
            this.qService.save(new QuestionRequestDto(subject, content));
        }
    }
    
}
