package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class DepartmentEditController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Nullable
    private String id;

    @NotNull
    private Department department = new Department();

    public void init() {
        @Nullable final Department department = departmentRepository.getOne(id);
        if (department != null) this.department = department;
    }

    @NotNull
    public String save() {
        departmentRepository.save(department);
        return "secure/department-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(@NotNull final Department department) {
        this.department = department;
    }
}
