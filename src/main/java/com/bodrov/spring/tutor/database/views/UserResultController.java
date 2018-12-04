package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.QuestionAnswer;
import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.repository.QuestionAnswerRepository;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UserResultController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    @Nullable
    private String id;

    @NotNull
    private Result result = new Result();

    private List<QuestionAnswer> staffAns;

    public void init(){
        @Nullable final Result result = resultRepository.getOne(id);
        if (result != null) this.result = result;
        staffAns = new ArrayList<>();
        List<QuestionAnswer> list = questionAnswerRepository.findAllByResultAndAnswerValue(result, true);
        for(int i=0; i<list.size(); i++){
            if(!list.get(i).getAnswer().isRight()) staffAns.add(list.get(i));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<QuestionAnswer> getStaffAns() {
        return staffAns;
    }

    public void setStaffAns(List<QuestionAnswer> staffAns) {
        this.staffAns = staffAns;
    }
}
