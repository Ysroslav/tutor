package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Table(name = Result.TABLE_NAME)
@Entity(name = Result.ENTITY_NAME)
public class Result extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "result";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @ManyToOne
    private Staff staff;

    @ManyToOne
    private Poll poll;

    @Column(name = "ball_result", nullable = false)
    private int ballResult;

    @Column(name = "time_result", nullable = false)
    private int timeResult;

    @Column(name = "date_test", nullable = false)
    private Date dateTest;

    @Column(name = "result_text", nullable = false)
    private String result;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public int getBallResult() {
        return ballResult;
    }

    public void setBallResult(int ballResult) {
        this.ballResult = ballResult;
    }

    public int getTimeResult() {
        return timeResult;
    }

    public void setTimeResult(int timeResult) {
        this.timeResult = timeResult;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
