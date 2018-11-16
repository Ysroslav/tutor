package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class StaffListController {

    @Autowired
    private StaffRepository staffRepository;

    private List<Staff> staffs;

    @PostConstruct
    public void init(){
        staffs = staffRepository.findAll();
    }

    public List<Staff> getStaffs() {
        return staffs;
    }


    public String deleteById(String id){
        staffRepository.deleteById(id);
        return "/staff-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Staff staff = new Staff("first name", "last name");
        staffRepository.save(staff);
        return "/staff-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/staff-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
