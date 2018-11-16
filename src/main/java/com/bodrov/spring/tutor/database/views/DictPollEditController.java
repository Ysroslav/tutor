package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictPoll;
import com.bodrov.spring.tutor.database.repository.DictPollRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DictPollEditController {

    @Autowired
    private DictPollRepository dictPollRepository;

    @Nullable
    private String id;

    @NotNull
    private DictPoll dictPoll = new DictPoll();

    public void init() {
        @Nullable final DictPoll dictPoll = dictPollRepository.getOne(id);
        if (dictPoll != null) this.dictPoll = dictPoll;
    }

    @NotNull
    public String save() {
        dictPollRepository.save(dictPoll);
        return "dictpoll-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public DictPoll getDictPoll() {
        return dictPoll;
    }

    public void setDictPoll(@NotNull final DictPoll dictPoll) {
        this.dictPoll = dictPoll;
    }
}
