package com.springboot_board_jyp.springboot_borad.domain.questions;

import java.util.ArrayList;
import java.util.List;

import com.springboot_board_jyp.springboot_borad.domain.BaseTimeEntity;
import com.springboot_board_jyp.springboot_borad.domain.answers.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Question extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String contnet;
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList = new ArrayList<>();

    @Builder
    public Question(String subject, String content){
        this.subject = subject;
        this.contnet= content;
    }
}
