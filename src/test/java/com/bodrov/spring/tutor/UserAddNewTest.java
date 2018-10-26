package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.*;
import com.bodrov.spring.tutor.database.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Calendar;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAddNewTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;


    @Test
    public void testAddNewStaff(){
        final Department department = new Department();
        department.setDepartmentName("IT");
        departmentService.save(department);

        final Staff staff = new Staff();
        staff.setFirstName("Ivanov1");
        staff.setLastName("Ivan");
        staff.setDepartment(department);
        staff.setDateAddStaff(new Date(Calendar.getInstance().getTime().getTime()));
        staffService.save(staff);

        final User user = new User();
        user.setLogin("admin");
        user.setPassword("123");
        user.setDisabled(true);
        user.setEmail("yar@r.t");
        user.setStaff(staff);
        userService.save(user);

        final Role role = new Role();
        role.setRoleName("ROLE_USER");
        final Role role1 = new Role();
        role1.setRoleName("ROLE_ADMIN");

        roleService.save(role);
        roleService.save(role1);

        final UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleService.save(userRole);

        final UserRole userRole1 = new UserRole();
        userRole1.setRole(role1);
        userRole1.setUser(user);
        userRoleService.save(userRole1);


        //Assert.assertEquals(user, userService.findByLogin("admin"));
    }
}
