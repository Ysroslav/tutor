package com.bodrov.spring.tutor.database.beans;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import com.bodrov.spring.tutor.database.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
public class HandlerAuthorize {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    private Map<com.bodrov.spring.tutor.database.entity.User, List<Role>> map;

    public Map<User, List<Role>> getListUserRoles(){
        List<com.bodrov.spring.tutor.database.entity.User> list = userRepository.findAll();
        this.map = new LinkedHashMap<>();

        for(int i =0; i<list.size();i++){
            final com.bodrov.spring.tutor.database.entity.User user = list.get(i);
            List<UserRole> userRoles = userRoleRepository.findAllByUser(user);
            List<Role> roles = new ArrayList<>();
            for(int j =0;j<userRoles.size();j++) {
                roles.add(userRoles.get(j).getRole());
            }
            map.put(user, roles);
        }
        return map;
    }

    public Map<User, List<Role>> getMap() {
        return map;
    }

    public void setMap(Map<User, List<Role>> map) {
        this.map = map;
    }
}
