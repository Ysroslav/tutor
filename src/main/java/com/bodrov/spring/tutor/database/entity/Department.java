package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = Department.TABLE_NAME)
@Entity(name = Department.ENTITY_NAME)
public class Department extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "department";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @NotNull
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @NotNull
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@NotNull String departmentName) {
        this.departmentName = departmentName;
    }
}
