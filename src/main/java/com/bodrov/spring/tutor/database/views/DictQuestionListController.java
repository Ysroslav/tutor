package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictQuestion;
import com.bodrov.spring.tutor.database.repository.DictQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScope
public class DictQuestionListController {

    @Autowired
    private DictQuestionRepository dictQuestionRepository;

    private List<DictQuestion> dictQuestions;

    @PostConstruct
    public void init(){
        dictQuestions = dictQuestionRepository.findAll();
    }

    public List<DictQuestion> getDictQuestions() {
        return dictQuestions;
    }


    public String deleteById(String id){
        dictQuestionRepository.deleteById(id);
        return "/secure/dictquestion-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final DictQuestion dictQuestion = new DictQuestion("a new type question");
        dictQuestionRepository.save(dictQuestion);
        return "/secure/dictquestion-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/dictquestion-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
