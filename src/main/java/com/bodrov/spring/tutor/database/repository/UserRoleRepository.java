package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
