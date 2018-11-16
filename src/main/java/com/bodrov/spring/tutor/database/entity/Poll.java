package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = Poll.TABLE_NAME)
@Entity(name = Poll.ENTITY_NAME)
public class Poll extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "poll";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @Column(name = "poll_name", unique = false, nullable = false)
    private String testName;

    @Column(name = "date_poll", nullable = true)
    private Date dateCreateTest;

    @Column(name = "min_value_ball", nullable = true)
    private int minValueBall;

    @Column(name = "time_poll", nullable = true)
    private int timeTest;

    @ManyToOne
    private DictPoll type;

    public Poll(){}

    public Poll(String testName){this.testName = testName;}

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getDateCreateTest() {
        return dateCreateTest;
    }

    public void setDateCreateTest(Date dateCreateTest) {
        this.dateCreateTest = dateCreateTest;
    }

    public int getMinValueBall() {
        return minValueBall;
    }

    public void setMinValueBall(int minValueBall) {
        this.minValueBall = minValueBall;
    }

    public int getTimeTest() {
        return timeTest;
    }

    public void setTimeTest(int timeTest) {
        this.timeTest = timeTest;
    }

    public DictPoll getType() {
        return type;
    }

    public void setType(DictPoll type) {
        this.type = type;
    }
}
