package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = Role.TABLE_NAME)
@Entity(name = Role.ENTITY_NAME)
public class Role extends AbstractEntity{

    @NotNull
    public static final String ENTITY_NAME = "role";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
