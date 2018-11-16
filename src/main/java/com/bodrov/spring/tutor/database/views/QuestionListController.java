package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class QuestionListController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PollRepository pollRepository;

    private List<Question> questions;

    private String idPoll;

    public void init(){
        @Nullable final Poll poll = pollRepository.getOne(idPoll);
        questions = questionRepository.findAllByPoll(poll);
    }

    public List<Question> getQuestions() {
        return questions;
    }


    public String deleteById(String id){
        questionRepository.deleteById(id);
        return "/question-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Poll poll = pollRepository.getOne(idPoll);
        final Question question = new Question("a new question", poll);
        questionRepository.save(question);
        return "/question-list.xhtml";
    }

    public String refresh(){
        return "/question-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }

    public String getIdPoll() {
        return idPoll;
    }

    public void setIdPoll(String idPoll) {
        this.idPoll = idPoll;
    }
}
