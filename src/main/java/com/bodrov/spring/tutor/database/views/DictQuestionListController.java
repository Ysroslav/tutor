package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictQuestion;
import com.bodrov.spring.tutor.database.repository.DictQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
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
        return "/dictquestion-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final DictQuestion dictQuestion = new DictQuestion("a new type question");
        dictQuestionRepository.save(dictQuestion);
        return "/dictquestion-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/dictquestion-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
