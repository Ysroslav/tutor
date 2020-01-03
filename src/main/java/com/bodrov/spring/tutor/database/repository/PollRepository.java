package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PollRepository extends JpaRepository<Poll, String> {
}