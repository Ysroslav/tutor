package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictQuestion;
import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.repository.DictQuestionRepository;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class QuestionEditController {

    @Autowired
    private QuestionRepository questionRepository;

    private Integer selectType;

    @Autowired
    private DictQuestionRepository dictQuestionRepository;

    @Autowired
    private PollRepository pollRepository;

    private Integer selectPoll;

    @Nullable
    private String id;

    @NotNull
    private Question question = new Question();

    private List<DictQuestion> dictQuestions;

    private List<Poll> polls;

    private Map<Integer, String> nameTypes;

    private Map<Integer, String> pollMap;

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public void init() {
        @Nullable final Question question = questionRepository.getOne(id);
        if (question != null) this.question = question;
        dictQuestions = dictQuestionRepository.findAll();
        nameTypes = new LinkedHashMap<>();
        for(int i = 0; i<dictQuestions.size(); i++) nameTypes.put(i, dictQuestions.get(i).getNameType());
        polls = pollRepository.findAll();
        pollMap = new LinkedHashMap<>();
        for(int i=0; i<polls.size();i++) pollMap.put(i, polls.get(i).getTestName());
    }

    @NotNull
    public String save() {
        if(selectPoll == null) {
            question.setType(dictQuestions.get(selectType));
            question.setPoll(polls.get(selectPoll));
        }
        questionRepository.save(question);
        return "secure/question-list";
    }

    public Integer getSelectPoll() {
        return selectPoll;
    }

    public void setSelectPoll(Integer selectPoll) {
        this.selectPoll = selectPoll;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<DictQuestion> getDictQuestions() {
        return dictQuestions;
    }

    public void setDictQuestions(List<DictQuestion> dictQuestions) {
        this.dictQuestions = dictQuestions;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public Map<Integer, String> getNameTypes() {
        return nameTypes;
    }

    public void setNameTypes(Map<Integer, String> nameTypes) {
        this.nameTypes = nameTypes;
    }

    public Map<Integer, String> getPollMap() {
        return pollMap;
    }

    public void setPollMap(Map<Integer, String> pollMap) {
        this.pollMap = pollMap;
    }
}
