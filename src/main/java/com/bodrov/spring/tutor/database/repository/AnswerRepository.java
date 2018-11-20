package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AnswerRepository extends JpaRepository<Answer, String> {

    List<Answer> findAllByQuestion(Question question);
}
