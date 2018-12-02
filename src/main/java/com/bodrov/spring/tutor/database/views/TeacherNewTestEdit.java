package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class TeacherNewTestEdit {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Nullable
    private String id;

    @Nullable
    private String idStaff;

    @Nullable
    private String idPoll;

    @NotNull
    private Result result = new Result();

    private List<Result> newTests;

    public void init() {
        String[] arr = id.split(";");
        idPoll = arr[0];
        idStaff = arr[1];
        final Poll poll = pollRepository.getOne(idPoll);
        final Staff staff = staffRepository.getOne(idStaff);
        result.setPoll(poll);
        result.setStaff(staff);
        result.setDateTest(new Date());
    }

    @NotNull
    public String save() {
        resultRepository.save(result);
        return "/teacher/teacher-main";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getIdPoll() {
        return idPoll;
    }

    public void setIdPoll(String idPoll) {
        this.idPoll = idPoll;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Result> getNewTests() {
        return newTests;
    }

    public void setNewTests(List<Result> newTests) {
        this.newTests = newTests;
    }
}



