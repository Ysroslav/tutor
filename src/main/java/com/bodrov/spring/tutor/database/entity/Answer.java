package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = Answer.TABLE_NAME)
@Entity(name = Answer.ENTITY_NAME)
public class Answer extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "answer";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @Column(name = "answer_text", nullable = false)
    private String answerText;

    @ManyToOne
    private Question question;

    @Column(name = "is_right", nullable = true)
    private boolean isRight;

    @Column(name = "ball_value", nullable = true)
    private int ballValue;

    public Answer(){}

    public Answer(String answerText, Question question){
        this.answerText = answerText;
        this.question = question;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public int getBallValue() {
        return ballValue;
    }

    public void setBallValue(int ballValue) {
        this.ballValue = ballValue;
    }
}
