package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
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
        return "/poll-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Poll poll = new Poll("a new poll");
        pollRepository.save(poll);
        return "/poll-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/poll-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
