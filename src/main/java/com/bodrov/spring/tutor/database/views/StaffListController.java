package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScope
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
        return "/secure/staff-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Staff staff = new Staff("first name", "last name");
        staffRepository.save(staff);
        return "/secure/staff-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/staff-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
