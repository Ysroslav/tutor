package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findAllByPoll(Poll poll) {
        return questionRepository.findAllByPoll(poll);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> findAll(Sort sort) {
        return questionRepository.findAll(sort);
    }

    public List<Question> findAllById(Iterable<String> iterable) {
        return questionRepository.findAllById(iterable);
    }

    public <S extends Question> List<S> saveAll(Iterable<S> iterable) {
        return questionRepository.saveAll(iterable);
    }

    public void flush() {
        questionRepository.flush();
    }

    public <S extends Question> S saveAndFlush(S s) {
        return questionRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Question> iterable) {
        questionRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        questionRepository.deleteAllInBatch();
    }

    public Question getOne(String s) {
        return questionRepository.getOne(s);
    }

    public <S extends Question> List<S> findAll(Example<S> example) {
        return questionRepository.findAll(example);
    }

    public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
        return questionRepository.findAll(example, sort);
    }

    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    public <S extends Question> S save(S s) {
        return questionRepository.save(s);
    }

    public Optional<Question> findById(String s) {
        return questionRepository.findById(s);
    }

    public boolean existsById(String s) {
        return questionRepository.existsById(s);
    }

    public long count() {
        return questionRepository.count();
    }

    public void deleteById(String s) {
        questionRepository.deleteById(s);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }

    public void deleteAll(Iterable<? extends Question> iterable) {
        questionRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        questionRepository.deleteAll();
    }

    public <S extends Question> Optional<S> findOne(Example<S> example) {
        return questionRepository.findOne(example);
    }

    public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
        return questionRepository.findAll(example, pageable);
    }

    public <S extends Question> long count(Example<S> example) {
        return questionRepository.count(example);
    }

    public <S extends Question> boolean exists(Example<S> example) {
        return questionRepository.exists(example);
    }
}
