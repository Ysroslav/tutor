package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.helper.MyRepository;
import com.bodrov.spring.tutor.database.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.inject.Named;
import java.util.List;

@Named
@SessionScope
public class AdminListController {

    @Autowired
    private AdminService adminService;

    private List<MyRepository> repositories;

    public void init(){
        try {
            repositories = adminService.getListRepositories();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<MyRepository> getRepositories() {
        return repositories;
    }
}
