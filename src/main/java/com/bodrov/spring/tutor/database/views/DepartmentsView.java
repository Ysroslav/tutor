package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@ViewScoped
@Named
public class DepartmentsView implements Serializable {

    @Autowired
    private DepartmentRepository departmentRepository;

    private List<Department> departments;

    @PostConstruct
    public void init(){
        departments = departmentRepository.findAll();
    }

    public List<Department> getDepartments() {
        return departments;
    }


    public String deleteById(String id){
        departmentRepository.deleteById(id);
        return "/department-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Department department = new Department("a new department");
        departmentRepository.save(department);
        return "/department-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/department-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}
