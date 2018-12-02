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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class ResultEditController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StaffRepository staffRepository;

    private Integer selectStaff;

    @Autowired
    private PollRepository pollRepository;

    private Integer selectPoll;

    private Map<Integer, String> staffs;

    private Map<Integer, String> polls;

    private List<Staff> staffList;

    private List<Poll> pollList;

    @Nullable
    private String id;

    @NotNull
    private Result result = new Result();

    public void init() {
        @Nullable final Result result = resultRepository.getOne(id);
        if (result != null) this.result = result;
        staffList = staffRepository.findAll();
        pollList = pollRepository.findAll();
        staffs = new LinkedHashMap<>();
        polls = new LinkedHashMap<>();
        for (int i = 0; i < staffList.size(); i++)
            staffs.put(i, staffList.get(i).getFirstName() + " " + staffList.get(i).getLastName());
        for (int i = 0; i < pollList.size(); i++) polls.put(i, pollList.get(i).getTestName());
    }

    @NotNull
    public String save() {
        result.setPoll(pollList.get(selectPoll));
        result.setStaff(staffList.get(selectStaff));
        resultRepository.save(result);
        return "/secure/result-list";
    }

    public Integer getSelectStaff() {
        return selectStaff;
    }

    public void setSelectStaff(Integer selectStaff) {
        this.selectStaff = selectStaff;
    }

    public Integer getSelectPoll() {
        return selectPoll;
    }

    public void setSelectPoll(Integer selectPoll) {
        this.selectPoll = selectPoll;
    }

    public Map<Integer, String> getStaffs() {
        return staffs;
    }

    public void setStaffs(Map<Integer, String> staffs) {
        this.staffs = staffs;
    }

    public Map<Integer, String> getPolls() {
        return polls;
    }

    public void setPolls(Map<Integer, String> polls) {
        this.polls = polls;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Poll> getPollList() {
        return pollList;
    }

    public void setPollList(List<Poll> pollList) {
        this.pollList = pollList;
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
}
