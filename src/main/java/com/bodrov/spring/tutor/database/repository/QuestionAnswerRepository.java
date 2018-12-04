package com.bodrov.spring.tutor.database.repository;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.QuestionAnswer;
import com.bodrov.spring.tutor.database.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, String> {

    Optional<QuestionAnswer> findAllByResultAndAnswer(Result result, Answer answer);

    List<QuestionAnswer> findAllByResultAndAnswerValue(Result result, Boolean answerValue);
}
