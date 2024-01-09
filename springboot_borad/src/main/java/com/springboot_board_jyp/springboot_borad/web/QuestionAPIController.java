package com.springboot_board_jyp.springboot_borad.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_board_jyp.springboot_borad.domain.questions.Question;
import com.springboot_board_jyp.springboot_borad.service.QuestionService;
import com.springboot_board_jyp.springboot_borad.web.dto.question.QuestionRequestDto;
import com.springboot_board_jyp.springboot_borad.web.dto.question.QuestionResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class QuestionAPIController {
    private final QuestionService qService;
    
    @GetMapping("/api/v1/questions")
    public List<QuestionResponseDto> get_questions(@RequestParam(value="page", defaultValue = "0") int page){
        Page<Question> paging = qService.getList(page);
        return paging.stream().map(QuestionResponseDto::new).collect(Collectors.toList());
    }
    @GetMapping("/api/v1/question/{id}")
    public QuestionResponseDto get_question(@PathVariable(name ="id") int id){
        return qService.findDtoById(id);
    }

    @PostMapping("/api/v1/questions")
    public Integer post_question(@RequestBody QuestionRequestDto requestDto) {
        return qService.save(requestDto);
    }
    
}
