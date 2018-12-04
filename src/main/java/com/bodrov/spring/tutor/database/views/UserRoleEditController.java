package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.repository.RoleRepository;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import com.bodrov.spring.tutor.database.repository.UserRoleRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class UserRoleEditController {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private List<Role> roles;

    private List<User> users;

    @Nullable
    private Integer selectRole;

    @Nullable
    private Integer selectUser;

    private Map<Integer, String> nameRoles;

    private Map<Integer, String> logins;

    @Nullable
    private String id;

    @NotNull
    private UserRole userRole;

    public void init() {
        @Nullable final UserRole userRole = userRoleRepository.getOne(id);
        if (userRole != null) this.userRole = userRole;
        roles = roleRepository.findAll();
        users = userRepository.findAll();
        nameRoles = new LinkedHashMap<>();
        logins = new LinkedHashMap<>();
        for(int i = 0; i<roles.size(); i++) nameRoles.put(i, roles.get(i).getRoleName());
        for(int i = 0; i<users.size(); i++) logins.put(i, users.get(i).getLogin());
    }

    @NotNull
    public String save() {
        if(selectUser != null && selectRole != null) {
            userRole.setRole(roles.get(selectRole));
            userRole.setUser(users.get(selectUser));
            userRoleRepository.save(userRole);
        }
        return "/secure/userrole-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(@NotNull UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getSelectRole() {
        return selectRole;
    }

    public void setSelectRole(Integer selectRole) {
        this.selectRole = selectRole;
    }

    public Map<Integer, String> getNameRoles() {
        return nameRoles;
    }

    public void setNameRoles(Map<Integer, String> nameRoles) {
        this.nameRoles = nameRoles;
    }

    public Map<Integer, String> getLogins() {
        return logins;
    }

    public void setLogins(Map<Integer, String> logins) {
        this.logins = logins;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(Integer selectUser) {
        this.selectUser = selectUser;
    }
}
