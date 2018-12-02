package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.repository.AnswerRepository;
import com.bodrov.spring.tutor.database.repository.QuestionAnswerRepository;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UserGoPollController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    @Nullable
    private String id;

    private List<Question> questions = new ArrayList<>();

    private List<Answer> answers = new ArrayList<>();


    @NotNull
    private Result result = new Result();


    @Nullable
    private Integer index;

    @Nullable
    private String idAnswer;

    public void init(){
        @Nullable final Result result = resultRepository.getOne(id);
        if (result != null) this.result = result;
        index = 0;
        this.questions = questionRepository.findAllByPoll(result.getPoll());
        final Question question = this.questions.get(0);
        this.answers = answerRepository.findAllByQuestion(question);
    }

    public String getOneQuestion(Integer index){
        if (index==questions.size()) index = 0;
        return questions.get(index).getQuestionText();
    }

    public void getAnswerStaff(){
        System.out.println(idAnswer);
        /*final Answer answer = answerRepository.getOne(idAnswer);
        QuestionAnswer questionAnswer = new QuestionAnswer();
        Optional<QuestionAnswer> ans = questionAnswerRepository.findAllByResultAndAnswer(result, answer);
        if(ans.isPresent()){
           questionAnswer = ans.get();
        } else {
            questionAnswer.setResult(result);
        }
        questionAnswer.setAnswer(answer);
        questionAnswerRepository.save(questionAnswer);
        getIncrement();*/
    }

    public void getIncrement(){
        if (index==questions.size()-1) index = 0; else index++;
        this.answers = answerRepository.findAllByQuestion(questions.get(index));
    }

    public void getDiscrement(){
        if (index==0) index = questions.size()-1; else index--;
        this.answers = answerRepository.findAllByQuestion(questions.get(index));
    }

    @Nullable
    public Integer getIndex() {
        return index;
    }

    public void setIndex(@Nullable Integer index) {
        this.index = index;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public String getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(String idAnswer) {
        this.idAnswer = idAnswer;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
