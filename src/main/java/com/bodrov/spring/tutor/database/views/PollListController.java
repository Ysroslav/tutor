package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScope
public class PollListController {

    @Autowired
    private PollRepository pollRepository;

    private List<Poll> polls;

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    @PostConstruct
    public void init(){
        polls = pollRepository.findAll();
    }

    public String deleteById(String id){
        pollRepository.deleteById(id);
        return "/secure/poll-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Poll poll = new Poll("a new poll");
        pollRepository.save(poll);
        return "/secure/poll-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/poll-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
