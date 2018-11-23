package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScope
public class ResultListController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private StaffRepository staffRepository;

    private List<Result> results;

    private String idStaff;

    private String idPoll;

    @PostConstruct
    public void init(){
        @Nullable final Staff staff = staffRepository.getOne(idStaff);
        this.results = resultRepository.findAllByStaff(staff);
    }

    public List<Result> getResults() {
        return results;
    }

    public String deleteById(String id){
        resultRepository.deleteById(id);
        return "/secure/result-list.xhtml?faces-redirect=true";
    }

    public String save(){
        if(idStaff!=null && idPoll!= null) {
            final Staff staff = staffRepository.getOne(idStaff);
            final Poll poll = pollRepository.getOne(idPoll);
            final Result result = new Result(staff, poll);
            resultRepository.save(result);
        }
        return "/secure/result-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/result-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }

    public void setResults(List<Result> results) {
        this.results = results;
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
}
