package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class UserListController {

    @Autowired
    private UserRepository userRepository;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @PostConstruct
    public void init(){
        users = userRepository.findAll();
    }

    public String deleteById(String id){
        userRepository.deleteById(id);
        return "/secure/user-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final User user = new User("Login", "y@y", "123");
        userRepository.save(user);
        return "/secure/user-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/secure/user-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
