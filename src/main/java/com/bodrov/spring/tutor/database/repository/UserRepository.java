package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByLogin(String login);
}
