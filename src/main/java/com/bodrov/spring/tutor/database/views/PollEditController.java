package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.DictPoll;
import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.repository.DictPollRepository;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class PollEditController {

    @Autowired
    private PollRepository pollRepository;

    private Integer selectType;

    @Autowired
    private DictPollRepository dictPollRepository;

    @Nullable
    private String id;

    @NotNull
    private Poll poll = new Poll();

    private List<DictPoll> dictPolls;

    private Map<Integer, String> nameTypes;

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public void init() {
        @Nullable final Poll poll = pollRepository.getOne(id);
        if (poll != null) this.poll = poll;
        dictPolls = dictPollRepository.findAll();
        nameTypes = new LinkedHashMap<>();
        for(int i = 0; i<dictPolls.size(); i++) nameTypes.put(i, dictPolls.get(i).getNameType());
    }

    @NotNull
    public String save() {
        poll.setType(dictPolls.get(selectType));
        pollRepository.save(poll);
        return "poll-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Poll getPoll() {
        return poll;
    }

    public void setPoll(@NotNull final Poll poll) {
        this.poll = poll;
    }

    public List<DictPoll> getDictPolls() {
        return dictPolls;
    }

    public void setDictPolls(List<DictPoll> dictPolls) {
        this.dictPolls = dictPolls;
    }

    public Map<Integer, String> getNameTypes() {
        return nameTypes;
    }
}
