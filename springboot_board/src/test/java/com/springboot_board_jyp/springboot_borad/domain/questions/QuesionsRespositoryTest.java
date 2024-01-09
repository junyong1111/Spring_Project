package com.springboot_board_jyp.springboot_borad.domain.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_board_jyp.springboot_board.domain.answers.Answer;
import com.springboot_board_jyp.springboot_board.domain.answers.AnswerRepository;
import com.springboot_board_jyp.springboot_board.domain.questions.Question;
import com.springboot_board_jyp.springboot_board.domain.questions.QuestionRepository;

@SpringBootTest
public class QuesionsRespositoryTest {
    @Autowired
    private  QuestionRepository qRepository;
    
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa(){
        Question q1 = Question
        .builder()
        .subject("sbb가 무엇인가요?")
        .content("sbb에 대해서 알고 싶습니다.")
        .build();
        this.qRepository.save(q1);
        System.out.println("Quesiotn 1 저장 완료");

        Question q2 = Question
        .builder()
        .subject("스프링 부트 모델 질문입니다.")
        .content("id는 자동으로 생성되나요?")
        .build();
        this.qRepository.save(q2);
        System.out.println("Quesiotn 2 저장 완료");
    }
    @Test
    void findAlltest(){
        List<Question> all = this.qRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Transactional
    @Test
    void 답변에연결된_질문찾기(){
        Question q1 = Question
        .builder()
        .subject("sbb가 무엇인가요?")
        .content("sbb에 대해서 알고 싶습니다.")
        .build();
        this.qRepository.save(q1);
        System.out.println("Quesiotn 1 저장 완료");

        Answer a1 = Answer
        .builder()
        .content("네 자동으로 생성됩니다.")
        .question(q1)
        .build();
        answerRepository.save(a1);
        System.out.println("Answer 1 저장 완료");
    
        Optional<Question> oq = this.qRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        List<Answer> answerlList = q.getAnswerList();
        System.out.println(answerlList.size());

         
    }

}
