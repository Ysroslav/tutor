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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class TeacherAddTestController {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Nullable
    private String id;

    @NotNull
    private Staff staff = new Staff();

    @Nullable
    private Result result;

    private List<Result> newTests;

    public void init(){
        @Nullable final Staff staff = staffRepository.getOne(id);
        if (staff != null) this.staff = staff;
        newTests = new ArrayList<>();
    }

    public void addNewTest(){
        this.result = new Result();
    }

    public String takeControlDate(@Nullable String idPoll){
        final Poll poll = pollRepository.getOne(idPoll);
        result.setPoll(poll);
        result.setStaff(staff);
        result.setDateTest(new Date());
        newTests.add(result);
        resultRepository.save(result);
        return "/teacher/teacher-new-test.xhtml?faces-redirect=true";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Result> getNewTests() {
        return newTests;
    }

    public void setNewTests(List<Result> newTests) {
        this.newTests = newTests;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
