package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScope
public class StaffEditController {

    @Autowired
    private StaffRepository staffRepository;

    private Integer selectType;

    @Autowired
    private DepartmentRepository departmentRepository;

    private Map<Integer, String> departments;

    private List<Department> departmentList;

    @Nullable
    private String id;

    @NotNull
    private Staff staff = new Staff();

    public void init() {
        @Nullable final Staff staff = staffRepository.getOne(id);
        if (staff != null) this.staff = staff;
        departmentList = departmentRepository.findAll();
        departments = new LinkedHashMap<>();
        for(int i = 0; i<departmentList.size(); i++) departments.put(i, departmentList.get(i).getDepartmentName());
    }

    @NotNull
    public String save() {
        staff.setDepartment(departmentList.get(selectType));
        staffRepository.save(staff);
        return "/secure/staff-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(@NotNull final Staff staff) {
        this.staff = staff;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Map<Integer, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<Integer, String> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
