package com.bodrov.spring.tutor.database.controller;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.repository.AnswerRepository;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private AnswerRepository answerRepository;

    private List<Question> questions;

    private int numberQuestion;

    @RequestMapping(value = "/test-active",method = RequestMethod.GET)
    public String openQuestion(@RequestParam("id") String pollId, Map<String, Object> model){
        final Poll poll = pollRepository.findById(pollId).get();
        this.questions = questionRepository.findAllByPoll(poll);
        this.numberQuestion = 0; // первый вопрос на открытие
        final Question question = questions.get(numberQuestion);
        model.put("question", question);
        final List<Answer> answers = answerRepository.findAllByQuestion(question);
        model.put("answers", answers);
        return "test-active";
    }

    @RequestMapping(value = "/test-active",method = RequestMethod.POST)
    public String nextQuestion(Map<String, Object> model){
        if(numberQuestion==questions.size()-1) numberQuestion = 0; else numberQuestion++;
        final Question question = questions.get(numberQuestion);
        model.remove("question");
        model.put("question", question);
        final List<Answer> answers = answerRepository.findAllByQuestion(question);
        model.remove("answers");
        model.put("answers", answers);
        return "redirect:test-active";
    }

}
