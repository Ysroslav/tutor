package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.QuestionAnswer;
import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerService {

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    public Optional<QuestionAnswer> findAllByResultAndAnswer(Result result, Answer answer) {
        return questionAnswerRepository.findAllByResultAndAnswer(result, answer);
    }

    public List<QuestionAnswer> findAllByResultAndAnswerValue(Result result, Boolean answerValue) {
        return questionAnswerRepository.findAllByResultAndAnswerValue(result, answerValue);
    }

    public List<QuestionAnswer> findAll() {
        return questionAnswerRepository.findAll();
    }

    public List<QuestionAnswer> findAll(Sort sort) {
        return questionAnswerRepository.findAll(sort);
    }

    public List<QuestionAnswer> findAllById(Iterable<String> iterable) {
        return questionAnswerRepository.findAllById(iterable);
    }

    public <S extends QuestionAnswer> List<S> saveAll(Iterable<S> iterable) {
        return questionAnswerRepository.saveAll(iterable);
    }

    public void flush() {
        questionAnswerRepository.flush();
    }

    public <S extends QuestionAnswer> S saveAndFlush(S s) {
        return questionAnswerRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<QuestionAnswer> iterable) {
        questionAnswerRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        questionAnswerRepository.deleteAllInBatch();
    }

    public QuestionAnswer getOne(String s) {
        return questionAnswerRepository.getOne(s);
    }

    public <S extends QuestionAnswer> List<S> findAll(Example<S> example) {
        return questionAnswerRepository.findAll(example);
    }

    public <S extends QuestionAnswer> List<S> findAll(Example<S> example, Sort sort) {
        return questionAnswerRepository.findAll(example, sort);
    }

    public Page<QuestionAnswer> findAll(Pageable pageable) {
        return questionAnswerRepository.findAll(pageable);
    }

    public <S extends QuestionAnswer> S save(S s) {
        return questionAnswerRepository.save(s);
    }

    public Optional<QuestionAnswer> findById(String s) {
        return questionAnswerRepository.findById(s);
    }

    public boolean existsById(String s) {
        return questionAnswerRepository.existsById(s);
    }

    public long count() {
        return questionAnswerRepository.count();
    }

    public void deleteById(String s) {
        questionAnswerRepository.deleteById(s);
    }

    public void delete(QuestionAnswer questionAnswer) {
        questionAnswerRepository.delete(questionAnswer);
    }

    public void deleteAll(Iterable<? extends QuestionAnswer> iterable) {
        questionAnswerRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        questionAnswerRepository.deleteAll();
    }

    public <S extends QuestionAnswer> Optional<S> findOne(Example<S> example) {
        return questionAnswerRepository.findOne(example);
    }

    public <S extends QuestionAnswer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return questionAnswerRepository.findAll(example, pageable);
    }

    public <S extends QuestionAnswer> long count(Example<S> example) {
        return questionAnswerRepository.count(example);
    }

    public <S extends QuestionAnswer> boolean exists(Example<S> example) {
        return questionAnswerRepository.exists(example);
    }
}
