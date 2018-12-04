package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.DictQuestion;
import com.bodrov.spring.tutor.database.repository.DictQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictQuestionService {

    @Autowired
    private DictQuestionRepository dictQuestionRepository;

    public List<DictQuestion> findAll() {
        return dictQuestionRepository.findAll();
    }

    public List<DictQuestion> findAll(Sort sort) {
        return dictQuestionRepository.findAll(sort);
    }

    public List<DictQuestion> findAllById(Iterable<String> iterable) {
        return dictQuestionRepository.findAllById(iterable);
    }

    public <S extends DictQuestion> List<S> saveAll(Iterable<S> iterable) {
        return dictQuestionRepository.saveAll(iterable);
    }

    public void flush() {
        dictQuestionRepository.flush();
    }

    public <S extends DictQuestion> S saveAndFlush(S s) {
        return dictQuestionRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<DictQuestion> iterable) {
        dictQuestionRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        dictQuestionRepository.deleteAllInBatch();
    }

    public DictQuestion getOne(String s) {
        return dictQuestionRepository.getOne(s);
    }

    public <S extends DictQuestion> List<S> findAll(Example<S> example) {
        return dictQuestionRepository.findAll(example);
    }

    public <S extends DictQuestion> List<S> findAll(Example<S> example, Sort sort) {
        return dictQuestionRepository.findAll(example, sort);
    }

    public Page<DictQuestion> findAll(Pageable pageable) {
        return dictQuestionRepository.findAll(pageable);
    }

    public <S extends DictQuestion> S save(S s) {
        return dictQuestionRepository.save(s);
    }

    public Optional<DictQuestion> findById(String s) {
        return dictQuestionRepository.findById(s);
    }

    public boolean existsById(String s) {
        return dictQuestionRepository.existsById(s);
    }

    public long count() {
        return dictQuestionRepository.count();
    }

    public void deleteById(String s) {
        dictQuestionRepository.deleteById(s);
    }

    public void delete(DictQuestion dictQuestion) {
        dictQuestionRepository.delete(dictQuestion);
    }

    public void deleteAll(Iterable<? extends DictQuestion> iterable) {
        dictQuestionRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        dictQuestionRepository.deleteAll();
    }

    public <S extends DictQuestion> Optional<S> findOne(Example<S> example) {
        return dictQuestionRepository.findOne(example);
    }

    public <S extends DictQuestion> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dictQuestionRepository.findAll(example, pageable);
    }

    public <S extends DictQuestion> long count(Example<S> example) {
        return dictQuestionRepository.count(example);
    }

    public <S extends DictQuestion> boolean exists(Example<S> example) {
        return dictQuestionRepository.exists(example);
    }
}
