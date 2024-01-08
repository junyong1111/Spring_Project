package com.springboot_board_jyp.springboot_borad.domain.answers;
import com.springboot_board_jyp.springboot_borad.domain.BaseTimeEntity;
import com.springboot_board_jyp.springboot_borad.domain.questions.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Answer extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @ManyToOne
    private Question question;

    @Builder
    public Answer(String content, Question question){
        this.content = content;
        this.question = question;
    }
}
