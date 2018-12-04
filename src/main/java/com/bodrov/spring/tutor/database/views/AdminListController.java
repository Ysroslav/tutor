package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.helper.MyRepository;
import com.bodrov.spring.tutor.database.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class AdminListController {

    @Autowired
    private AdminService adminService;

    private List<MyRepository> repositories;

    @PostConstruct
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
