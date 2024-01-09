package com.springboot_board_jyp.springboot_board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot_board_jyp.springboot_board.domain.answers.Answer;
import com.springboot_board_jyp.springboot_board.domain.answers.AnswerRepository;
import com.springboot_board_jyp.springboot_board.domain.questions.Question;
import com.springboot_board_jyp.springboot_board.web.dto.answer.AnswerRequestDto;
import com.springboot_board_jyp.springboot_board.web.dto.answer.AnswerResponseDto;
import com.springboot_board_jyp.springboot_board.web.dto.question.QuestionRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository aRepository;


    @Transactional
    public void save(Question question, String Content) {
        AnswerRequestDto requestDto = AnswerRequestDto.builder()
        .content(Content)
        .question(question)
        .build();
        aRepository.save(requestDto.toEntity());
    }    

    @Transactional
    public List<AnswerResponseDto> findAnswerList(Question question) {
        return question.getAnswerList().stream()
        .map(AnswerResponseDto::new).collect(Collectors.toList());
    }      
}
