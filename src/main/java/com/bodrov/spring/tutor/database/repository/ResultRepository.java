package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, String> {

    List<Result> findAllByStaff(Staff staff);

    long countByStaff(Staff staff);

    List<Result> findAllByResultIsNull();

    List<Result> findAllByResultIsNotNullAndStaff(Staff staff);

    List<Result> findAllByResultIsNullAndStaff(Staff staff);
}
