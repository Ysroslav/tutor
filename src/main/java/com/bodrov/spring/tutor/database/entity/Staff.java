package com.bodrov.spring.tutor.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = Staff.TABLE_NAME)
@Entity(name = Staff.ENTITY_NAME)
public class Staff extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "staff";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "date_add_staff", nullable = true)
    private Date dateAddStaff;

    @ManyToOne
    private Department department;

    public Staff(){}

    public Staff(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateAddStaff() {
        return dateAddStaff;
    }

    public void setDateAddStaff(Date dateAddStaff) {
        this.dateAddStaff = dateAddStaff;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
