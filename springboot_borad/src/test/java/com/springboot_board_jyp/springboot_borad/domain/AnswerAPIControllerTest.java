package com.springboot_board_jyp.springboot_borad.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot_board_jyp.springboot_borad.domain.answers.Answer;
import com.springboot_board_jyp.springboot_borad.domain.answers.AnswerRepository;
import com.springboot_board_jyp.springboot_borad.domain.questions.Question;
import com.springboot_board_jyp.springboot_borad.domain.questions.QuestionRepository;
import com.springboot_board_jyp.springboot_borad.service.AnswerService;
import com.springboot_board_jyp.springboot_borad.service.QuestionService;
import com.springboot_board_jyp.springboot_borad.web.dto.answer.AnswerResponseDto;
import com.springboot_board_jyp.springboot_borad.web.dto.question.QuestionRequestDto;

import jakarta.transaction.Transactional;

@SpringBootTest
public class AnswerAPIControllerTest {
    @Autowired
    private AnswerService aService;

    @Autowired
    private AnswerRepository aRepository;

    @Autowired
    private QuestionRepository qRepository;

    @Autowired
    private QuestionService qService;

    @Test
    @Transactional
    public void answeTest(){
        QuestionRequestDto requestDto1 = new QuestionRequestDto("Test Subject 1", "Test Content 1");
        qService.save(requestDto1);

        Question q1 = Question.builder()
        .content("Test Content with Question")
        .subject("Test Subject with Question")
        .build();
        qRepository.save(q1);
        aService.save(q1, "Test Answer Content1");
        Answer answer = new Answer();
      
        
        aRepository.save(answer);
        


        // aService.save(requestDto1.toEntity(), "Test Answer Content2");

        List<Answer>answerlist = q1.getAnswerList();
        System.out.println("=========start=========");
        for (Answer a : answerlist) {
            System.out.println(a);
        }
        System.out.println("=========end=========");

    }
    
    @Transactional
    @Test
    public void testAnswerList(){
        Question question = qService.findById(1);
        List<AnswerResponseDto>answerlist = aService.findAnswerList(question);
        System.out.println(answerlist.get(1).getContent());

    }

    
    
}
