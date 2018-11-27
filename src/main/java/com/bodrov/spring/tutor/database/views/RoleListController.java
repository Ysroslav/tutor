package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class RoleListController {

    @Autowired
    private RoleRepository roleRepository;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @PostConstruct
    public void init(){
        roles = roleRepository.findAll();
    }

    public String deleteById(String id){
        roleRepository.deleteById(id);
        return "/secure/role-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Role role = new Role("a new role");
        roleRepository.save(role);
        return "/secure/role-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/role-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
