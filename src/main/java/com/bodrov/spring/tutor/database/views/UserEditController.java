package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class UserEditController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Nullable
    private String id;

    private Integer selectStaff;

    private Map<Integer, String> staffs;

    private List<Staff> staffList;

    @NotNull
    private User user = new User();

    public void init() {
        @Nullable final User user = userRepository.getOne(id);
        if (user != null) this.user = user;
        staffList = staffRepository.findAll();
        staffs = new LinkedHashMap<>();
        for(int i = 0; i<staffList.size(); i++) staffs.put(i, staffList.get(i).getFirstName() + " " + staffList.get(i).getLastName());
    }

    @NotNull
    public String save() {
        user.setStaff(staffList.get(selectStaff));
        userRepository.save(user);
        return "/secure/user-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public User getUser() {
        return user;
    }

    public void setUser(@NotNull final User user) {
        this.user = user;
    }

    public Integer getSelectStaff() {
        return selectStaff;
    }

    public void setSelectStaff(Integer selectStaff) {
        this.selectStaff = selectStaff;
    }

    public Map<Integer, String> getStaffs() {
        return staffs;
    }

    public void setStaffs(Map<Integer, String> staffs) {
        this.staffs = staffs;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
