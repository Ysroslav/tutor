package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.repository.RoleRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.inject.Named;

@Named
@SessionScope
public class RoleEditController {

    @Autowired
    private RoleRepository roleRepository;

    @Nullable
    private String id;

    @NotNull
    private Role role = new Role();

    public void init() {
        @Nullable final Role role = roleRepository.getOne(id);
        if (role != null) this.role = role;
    }

    @NotNull
    public String save() {
        roleRepository.save(role);
        return "/secure/role-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Role getRole() {
        return role;
    }

    public void setRole(@NotNull final Role role) {
        this.role = role;
    }
}
