package com.bodrov.spring.tutor.database.controller;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private Poll poll;

    @RequestMapping(value = "/test-card",method = RequestMethod.GET)
    public String openCard(@RequestParam("id") String pollId, Map<String, Object> model){
        this.poll = pollRepository.findById(pollId).get();
        model.put("poll", poll);
        return "test-card";
    }

    @RequestMapping(value = {"/test-begin"}, method = RequestMethod.POST)
    public String testBegin(){
        return "test-active?id=" + poll.getId();
    }
}
