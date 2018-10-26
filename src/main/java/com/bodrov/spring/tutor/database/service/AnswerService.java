package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Answer;
import com.bodrov.spring.tutor.database.entity.Question;
import com.bodrov.spring.tutor.database.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> findAllByQuestion(Question question) {
        return answerRepository.findAllByQuestion(question);
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public List<Answer> findAll(Sort sort) {
        return answerRepository.findAll(sort);
    }

    public List<Answer> findAllById(Iterable<String> iterable) {
        return answerRepository.findAllById(iterable);
    }

    public <S extends Answer> List<S> saveAll(Iterable<S> iterable) {
        return answerRepository.saveAll(iterable);
    }

    public void flush() {
        answerRepository.flush();
    }

    public <S extends Answer> S saveAndFlush(S s) {
        return answerRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Answer> iterable) {
        answerRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        answerRepository.deleteAllInBatch();
    }

    public Answer getOne(String s) {
        return answerRepository.getOne(s);
    }

    public <S extends Answer> List<S> findAll(Example<S> example) {
        return answerRepository.findAll(example);
    }

    public <S extends Answer> List<S> findAll(Example<S> example, Sort sort) {
        return answerRepository.findAll(example, sort);
    }

    public Page<Answer> findAll(Pageable pageable) {
        return answerRepository.findAll(pageable);
    }

    public <S extends Answer> S save(S s) {
        return answerRepository.save(s);
    }

    public Optional<Answer> findById(String s) {
        return answerRepository.findById(s);
    }

    public boolean existsById(String s) {
        return answerRepository.existsById(s);
    }

    public long count() {
        return answerRepository.count();
    }

    public void deleteById(String s) {
        answerRepository.deleteById(s);
    }

    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    public void deleteAll(Iterable<? extends Answer> iterable) {
        answerRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        answerRepository.deleteAll();
    }

    public <S extends Answer> Optional<S> findOne(Example<S> example) {
        return answerRepository.findOne(example);
    }

    public <S extends Answer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return answerRepository.findAll(example, pageable);
    }

    public <S extends Answer> long count(Example<S> example) {
        return answerRepository.count(example);
    }

    public <S extends Answer> boolean exists(Example<S> example) {
        return answerRepository.exists(example);
    }
}
