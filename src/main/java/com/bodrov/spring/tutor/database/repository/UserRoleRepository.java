package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

    List<UserRole> findAllByUser(User user);

}
