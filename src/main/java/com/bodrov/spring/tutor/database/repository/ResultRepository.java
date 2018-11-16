package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ResultRepository extends JpaRepository<Result, String> {

    List<Result> findAllByStaff(Staff staff);
}
