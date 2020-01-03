package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = QuestionAnswer.TABLE_NAME)
@Entity(name = QuestionAnswer.ENTITY_NAME)
public class QuestionAnswer extends AbstractEntity {

   @NotNull
    public static final String ENTITY_NAME = "questionAns";

    @NotNull
    public static final String TABLE_NAME = "tbl_question_ans";

    public String tabName = TABLE_NAME;

    @ManyToOne
    private Staff staff;

    @ManyToOne
    private Answer answer;

    @Column(name = "answer_value", nullable = false)
    private boolean answerValue;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public boolean isAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(boolean answerValue) {
        this.answerValue = answerValue;
    }
}
