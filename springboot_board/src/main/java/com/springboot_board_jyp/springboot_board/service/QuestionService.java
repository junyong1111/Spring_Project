package com.springboot_board_jyp.springboot_board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot_board_jyp.springboot_board.domain.answers.Answer;
import com.springboot_board_jyp.springboot_board.domain.questions.Question;
import com.springboot_board_jyp.springboot_board.domain.questions.QuestionRepository;
import com.springboot_board_jyp.springboot_board.web.dto.question.QuestionRequestDto;
import com.springboot_board_jyp.springboot_board.web.dto.question.QuestionResponseDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository qRepository;

    @Transactional
    public QuestionResponseDto findDtoById(int id) {
        Question entity = qRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("일치하는 질문이 없습니다. id = {}"+id)
        );
        return new QuestionResponseDto(entity);
    }

    @Transactional
    public Question findById(int id) {
        Question question = qRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("일치하는 질문이 없습니다. id = {}"+id)
        );
        return question;
    }

    @Transactional
    public List<QuestionResponseDto> findByAll() {
        return qRepository.findAll().stream()
        .map(QuestionResponseDto::new)
        .collect(Collectors.toList());
    }

    @Transactional
    public Integer save(QuestionRequestDto requestDto) {
        return qRepository.save(requestDto.toEntity()).getId();
    }    

    public Page<Question> getList(int page){
        Pageable pageable = PageRequest.of(page, 10);
        return this.qRepository.findAll(pageable);
    }
}
