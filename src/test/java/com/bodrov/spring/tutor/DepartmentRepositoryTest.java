package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.repository.RoleRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import com.bodrov.spring.tutor.database.repository.UserRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void testFindByName(){
        List<User> list = userRepository.findAll();
        Map<User, List<Role>> map = new LinkedHashMap<>();

        for(int i =0; i<list.size();i++){
            final User user = list.get(i);
            List<UserRole> userRoles = userRoleRepository.findAllByUser(user);
            List<Role> roles = new ArrayList<>();
            for(int j =0;j<userRoles.size();j++) roles.add(userRoles.get(j).getRole());
            map.put(user, roles);
        }
        for(Map.Entry entry:map.entrySet()){
            final User user = (User)entry.getKey();
            List<Role> roles = (List)entry.getValue();
            for(int i = 0; i<roles.size();i++)
                System.out.println(user.getLogin() + " - " + roles.get(i).getRoleName());
        }
    }
}
