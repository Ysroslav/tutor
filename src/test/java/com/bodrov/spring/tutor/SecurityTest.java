package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.service.RoleService;
import com.bodrov.spring.tutor.database.service.UserRoleService;
import com.bodrov.spring.tutor.database.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityTest {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Test
    public void testAddNewStaff() {
        final User user = userService.findByLogin("admin").get();

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
        userRoleService.save(userRole);
    }
}
