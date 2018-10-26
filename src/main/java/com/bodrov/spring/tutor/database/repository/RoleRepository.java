package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
