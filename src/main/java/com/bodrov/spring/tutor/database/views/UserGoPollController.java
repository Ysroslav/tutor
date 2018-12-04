package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.entity.QuestionAnswer;
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
import java.util.Date;
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

    private List<QuestionAnswer> staffAns = new ArrayList<>();
    
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
        this.staffAns = updateAns(this.result, answers);
    }

    private List<QuestionAnswer> updateAns(Result result, List<Answer> list){
        List<QuestionAnswer> listAns = new ArrayList<>();
        for(int i = 0; i<list.size();i++){
          QuestionAnswer ans = new QuestionAnswer();
          if(questionAnswerRepository.findAllByResultAndAnswer(result,list.get(i)).isPresent()){
              ans = questionAnswerRepository.findAllByResultAndAnswer(result, list.get(i)).get();
          } else {
              ans.setResult(result);
              ans.setAnswer(list.get(i));
          }
          listAns.add(ans);
        }
        return listAns;
    }

    public void putAnswer(QuestionAnswer answer){
        answer.setAnswerValue(true);
        for(int i=0; i<staffAns.size();i++){
            if(!staffAns.get(i).equals(answer)) staffAns.get(i).setAnswerValue(false);
        }
    }

    public String getOneQuestion(Integer index){
        if (index==questions.size()) index = 0;
        return questions.get(index).getQuestionText();
    }

    public void getAnswerStaff(){
        for(int i = 0; i<staffAns.size(); i++)
            questionAnswerRepository.save(staffAns.get(i));
        getIncrement();
    }

    public void getIncrement(){
        if (index==questions.size()-1) index = 0; else index++;
        this.answers = answerRepository.findAllByQuestion(questions.get(index));
        this.staffAns = updateAns(this.result, answers);
    }

    public void getDiscrement(){
        if (index==0) index = questions.size()-1; else index--;
        this.answers = answerRepository.findAllByQuestion(questions.get(index));
        this.staffAns = updateAns(this.result, answers);
    }


    public String finishTest(){
        List<QuestionAnswer> list = questionAnswerRepository.findAllByResultAndAnswerValue(result,true);
        int ball=0;
        for(int i=0;i<list.size();i++)
            ball +=list.get(i).getAnswer().getBallValue();
        System.out.println(ball);
        if(ball<result.getPoll().getMinValueBall()) result.setResult("Not done");
        else result.setResult("Done");
        result.setBallResult(ball);
        result.setDateEnd(new Date());
        resultRepository.save(result);
        return "/staff/staff-result?faces-redirect=true id=" + result.getId();
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

    public List<QuestionAnswer> getStaffAns() {
        return staffAns;
    }

    public void setStaffAns(List<QuestionAnswer> staffAns) {
        this.staffAns = staffAns;
    }
}
