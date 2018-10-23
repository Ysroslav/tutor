package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, String> {

    public List<Department> findByDepartmentName(String departmentName);
}
