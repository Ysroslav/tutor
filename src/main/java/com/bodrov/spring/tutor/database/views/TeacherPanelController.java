package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class TeacherPanelController {

    private final static String SUCCESS = "Done";

    @Autowired
    private ResultRepository resultRepository;

    private List<Result> results;

    @PostConstruct
    public void init(){
        List<Result> testNotEnd = resultRepository.findAll();
        this.results = resultRepository.findAllByResultIsNull();
    }

    public long countNumberTest(Staff staff){
        return resultRepository.countByStaff(staff);
    }

    public String countAverageRateSuccess(Staff staff){
        final List<Result> resultList = resultRepository.findAllByResultIsNotNullAndStaff(staff);
        if(resultList.size()==0) return "No tests passed";
        long numberSuccess = 0;
        for(int i = 0; i<resultList.size(); i++){
            if(resultList.get(i).getResult().equals(SUCCESS)) numberSuccess++;
        }
        return String.format("%.2f", numberSuccess/resultList.size()*100)+"%";
    }



    public String deleteById(String id){
        resultRepository.deleteById(id);
        return "/teacher/teacher-main.xhtml?faces-redirect=true";
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
