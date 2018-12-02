package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UserMainController {

    @Nullable
    private String id;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ResultRepository resultRepository;

    private List<Result> resultsNotDone = new ArrayList<Result>();

    private List<Result> resultsDone = new ArrayList<Result>();

    @NotNull
    private Staff staff = new Staff();

    public void init() {
        @Nullable final Staff staff = staffRepository.getOne(id);
        if (staff != null) this.staff = staff;
        resultsNotDone = resultRepository.findAllByResultIsNullAndStaff(staff);
        resultsDone = resultRepository.findAllByResultIsNotNullAndStaff(staff);
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final  String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(final Staff staff) {
        this.staff = staff;
    }

    public List<Result> getResultsNotDone() {
        return resultsNotDone;
    }

    public void setResultsNotDone(List<Result> resultsNotDone) {
        this.resultsNotDone = resultsNotDone;
    }

    public List<Result> getResultsDone() {
        return resultsDone;
    }

    public void setResultsDone(List<Result> resultsDone) {
        this.resultsDone = resultsDone;
    }
}
