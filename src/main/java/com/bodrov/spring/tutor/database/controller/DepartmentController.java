package com.bodrov.spring.tutor.database.controller;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public List<Department> getList() {
        return list;
    }

    private List<Department> list;

    @GetMapping("/admin/department-list")
    public String getListDepartments(final Model model){
        final Iterable<Department> departments = departmentService.findAll();
        this.list = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "/secure/department-list";
    }

    @GetMapping("/admin/department-create")
    public String createNewDepartment(){
        final Department department = new Department();
        department.setDepartmentName("New department");
        departmentService.save(department);
        return "redirect:/secure/department-list";
    }

    @GetMapping("/admin/department-edit/{id}")
    public String editDepartment(final Model model, @PathVariable("id") final String id){
        final Optional<Department> department = departmentService.findById(id);
        department.ifPresent(p->model.addAttribute("department", p));
        return "/secure/department-edit";
    }

    @GetMapping("/admin/department-save")
    public String saveNewDepartment(@ModelAttribute("department") final Department department, final BindingResult result){
        if(!result.hasErrors()) departmentService.save(department);
        return "redirect:/secure/department-list";
    }

    @GetMapping("/admin/department-view/{id}")
    public String getViewDepartment(final Model model, @PathVariable("id") final String id) {
        final Optional<Department> department = departmentService.findById(id);
        department.ifPresent(p -> model.addAttribute("department", p));
        return "/secure/department-view";
    }

    @GetMapping("/admin/department-delete/{id}")
    public String deleteDepartment(@PathVariable("id") final String id){
        departmentService.deleteById(id);
        return "redirect:/secure/department-list";
    }
}
