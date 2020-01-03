package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = UserRole.TABLE_NAME)
@Entity(name = UserRole.ENTITY_NAME)
public class UserRole extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "user_role";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    public String tabName = TABLE_NAME;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
