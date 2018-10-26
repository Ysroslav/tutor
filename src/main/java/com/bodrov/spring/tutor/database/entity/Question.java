package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = Question.TABLE_NAME)
@Entity(name = Question.ENTITY_NAME)
public class Question extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "question";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private DictQuestion type;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public DictQuestion getType() {
        return type;
    }

    public void setType(DictQuestion type) {
        this.type = type;
    }
}