package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictPoll;
import com.bodrov.spring.tutor.database.repository.DictPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScope
public class DictPollListController {

    @Autowired
    private DictPollRepository dictPollRepository;

    private List<DictPoll> dictPolls;

    @PostConstruct
    public void init(){
        dictPolls = dictPollRepository.findAll();
    }

    public List<DictPoll> getDictPolls() {
        return dictPolls;
    }


    public String deleteById(String id){
        dictPollRepository.deleteById(id);
        return "/secure/dictpoll-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final DictPoll dictPoll = new DictPoll("a new type test");
        dictPollRepository.save(dictPoll);
        return "/secure/dictpoll-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/dictpoll-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
