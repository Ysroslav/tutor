package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class UserRoleListController {

    @Autowired
    private UserRoleRepository userRoleRepository;


    private List<UserRole> userRoles;

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


    @PostConstruct
    public void init(){
        userRoles = userRoleRepository.findAll();
    }

    public String deleteById(String id){
        userRoleRepository.deleteById(id);
        return "/secure/userrole-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final UserRole userRole = new UserRole();
        userRoleRepository.save(userRole);
        return "/secure/userrole-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/userrole-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
