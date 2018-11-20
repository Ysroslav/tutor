package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.repository.AnswerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AnswerEditController {

    @Autowired
    private AnswerRepository answerRepository;

    @Nullable
    private String id;

    @NotNull
    private Answer answer = new Answer();

    public void init() {
        @Nullable final Answer answer = answerRepository.getOne(id);
        if (answer != null) this.answer = answer;
    }

    @NotNull
    public String save() {
        answerRepository.save(answer);
        return "secure/answer-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(@NotNull final Answer answer) {
        this.answer = answer;
    }

}
