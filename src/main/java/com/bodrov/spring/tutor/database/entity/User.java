package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = User.TABLE_NAME)
@Entity(name = User.ENTITY_NAME)
public class User extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "user";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name="password")
    private String password;

    @Column
    private Boolean disabled;

    @ManyToOne
    private Staff staff;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
