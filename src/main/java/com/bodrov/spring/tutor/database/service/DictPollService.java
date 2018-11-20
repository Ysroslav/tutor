package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.DictPoll;
import com.bodrov.spring.tutor.database.repository.DictPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictPollService {

    @Autowired
    private DictPollRepository dictPollRepository;

    public List<DictPoll> findAll() {
        return dictPollRepository.findAll();
    }

    public List<DictPoll> findAll(Sort sort) {
        return dictPollRepository.findAll(sort);
    }

    public List<DictPoll> findAllById(Iterable<String> iterable) {
        return dictPollRepository.findAllById(iterable);
    }

    public <S extends DictPoll> List<S> saveAll(Iterable<S> iterable) {
        return dictPollRepository.saveAll(iterable);
    }

    public void flush() {
        dictPollRepository.flush();
    }

    public <S extends DictPoll> S saveAndFlush(S s) {
        return dictPollRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<DictPoll> iterable) {
        dictPollRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        dictPollRepository.deleteAllInBatch();
    }

    public DictPoll getOne(String s) {
        return dictPollRepository.getOne(s);
    }

    public <S extends DictPoll> List<S> findAll(Example<S> example) {
        return dictPollRepository.findAll(example);
    }

    public <S extends DictPoll> List<S> findAll(Example<S> example, Sort sort) {
        return dictPollRepository.findAll(example, sort);
    }

    public Page<DictPoll> findAll(Pageable pageable) {
        return dictPollRepository.findAll(pageable);
    }

    public <S extends DictPoll> S save(S s) {
        return dictPollRepository.save(s);
    }

    public Optional<DictPoll> findById(String s) {
        return dictPollRepository.findById(s);
    }

    public boolean existsById(String s) {
        return dictPollRepository.existsById(s);
    }

    public long count() {
        return dictPollRepository.count();
    }

    public void deleteById(String s) {
        dictPollRepository.deleteById(s);
    }

    public void delete(DictPoll dictPoll) {
        dictPollRepository.delete(dictPoll);
    }

    public void deleteAll(Iterable<? extends DictPoll> iterable) {
        dictPollRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        dictPollRepository.deleteAll();
    }

    public <S extends DictPoll> Optional<S> findOne(Example<S> example) {
        return dictPollRepository.findOne(example);
    }

    public <S extends DictPoll> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dictPollRepository.findAll(example, pageable);
    }

    public <S extends DictPoll> long count(Example<S> example) {
        return dictPollRepository.count(example);
    }

    public <S extends DictPoll> boolean exists(Example<S> example) {
        return dictPollRepository.exists(example);
    }
}
