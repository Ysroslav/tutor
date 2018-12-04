package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TeacherEditAddTestController {

    @Autowired
    private ResultRepository resultRepository;

    @Nullable
    private String id;

    @NotNull
    private Result result = new Result();

    public void init() {
        @Nullable final Result result = resultRepository.getOne(id);
        if (result != null) this.result = result;
    }

    @NotNull
    public String save() {
        resultRepository.save(result);
        return "/teacher/teacher-new-test";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Result getResult() {
        return result;
    }

    public void setResult(@NotNull final Result result) {
        this.result = result;
    }

}
