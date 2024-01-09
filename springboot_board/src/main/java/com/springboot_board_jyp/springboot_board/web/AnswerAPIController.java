package com.springboot_board_jyp.springboot_board.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_board_jyp.springboot_board.domain.answers.Answer;
import com.springboot_board_jyp.springboot_board.domain.questions.Question;
import com.springboot_board_jyp.springboot_board.domain.questions.QuestionRepository;
import com.springboot_board_jyp.springboot_board.service.AnswerService;
import com.springboot_board_jyp.springboot_board.service.QuestionService;
import com.springboot_board_jyp.springboot_board.web.dto.answer.AnswerResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AnswerAPIController {
    private final QuestionService qService;
    private final AnswerService aService;


    @GetMapping("/api/v1/question/{id}/answers")
    public List<AnswerResponseDto> getAnswerList(@PathVariable(name ="id") int id){
        Question question = qService.findById(id);
        return aService.findAnswerList(question);
    }
    
 
    
    @PostMapping("/api/v1/answer/save/{id}")
    public void createAnswer(@PathVariable(name ="id") int id, @RequestBody String content){
        Question question = qService.findById(id);
        System.out.println("Testing Start......");
        System.out.println(content.replace("\"", ""));
        System.out.println("Testing End......");
        aService.save(question, content.replace("\"", ""));
    }
    
}
