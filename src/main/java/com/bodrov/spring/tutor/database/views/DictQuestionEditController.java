package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictQuestion;
import com.bodrov.spring.tutor.database.repository.DictQuestionRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.inject.Named;

@Named
@SessionScope
public class DictQuestionEditController {

    @Autowired
    private DictQuestionRepository dictQuestionRepository;

    @Nullable
    private String id;

    @NotNull
    private DictQuestion dictQuestion = new DictQuestion();

    public void init() {
        @Nullable final DictQuestion dictQuestion = dictQuestionRepository.getOne(id);
        if (dictQuestion != null) this.dictQuestion = dictQuestion;
    }

    @NotNull
    public String save() {
        dictQuestionRepository.save(dictQuestion);
        return "/secure/dictquestion-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public DictQuestion getDictQuestion() {
        return dictQuestion;
    }

    public void setDictQuestion(@NotNull final DictQuestion dictQuestion) {
        this.dictQuestion = dictQuestion;
    }
}
