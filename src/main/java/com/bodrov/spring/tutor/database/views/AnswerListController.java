package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.repository.AnswerRepository;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class AnswerListController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private List<Answer> answers;

    private Question question;

    private String idQuestion;

    public void init(){
        this.question = questionRepository.getOne(idQuestion);
        answers = answerRepository.findAllByQuestion(question);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String deleteById(String id){
        answerRepository.deleteById(id);
        return "/answer-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Question question = questionRepository.getOne(idQuestion);
        final Answer answer = new Answer("Add text answer", question);
        answerRepository.save(answer);
        return "/answer-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/answer-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
