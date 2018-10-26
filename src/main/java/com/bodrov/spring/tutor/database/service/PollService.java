package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> findAll() {
        return pollRepository.findAll();
    }

    public List<Poll> findAll(Sort sort) {
        return pollRepository.findAll(sort);
    }

    public List<Poll> findAllById(Iterable<String> iterable) {
        return pollRepository.findAllById(iterable);
    }

    public <S extends Poll> List<S> saveAll(Iterable<S> iterable) {
        return pollRepository.saveAll(iterable);
    }

    public void flush() {
        pollRepository.flush();
    }

    public <S extends Poll> S saveAndFlush(S s) {
        return pollRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Poll> iterable) {
        pollRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        pollRepository.deleteAllInBatch();
    }

    public Poll getOne(String s) {
        return pollRepository.getOne(s);
    }

    public <S extends Poll> List<S> findAll(Example<S> example) {
        return pollRepository.findAll(example);
    }

    public <S extends Poll> List<S> findAll(Example<S> example, Sort sort) {
        return pollRepository.findAll(example, sort);
    }

    public Page<Poll> findAll(Pageable pageable) {
        return pollRepository.findAll(pageable);
    }

    public <S extends Poll> S save(S s) {
        return pollRepository.save(s);
    }

    public Optional<Poll> findById(String s) {
        return pollRepository.findById(s);
    }

    public boolean existsById(String s) {
        return pollRepository.existsById(s);
    }

    public long count() {
        return pollRepository.count();
    }

    public void deleteById(String s) {
        pollRepository.deleteById(s);
    }

    public void delete(Poll poll) {
        pollRepository.delete(poll);
    }

    public void deleteAll(Iterable<? extends Poll> iterable) {
        pollRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        pollRepository.deleteAll();
    }

    public <S extends Poll> Optional<S> findOne(Example<S> example) {
        return pollRepository.findOne(example);
    }

    public <S extends Poll> Page<S> findAll(Example<S> example, Pageable pageable) {
        return pollRepository.findAll(example, pageable);
    }

    public <S extends Poll> long count(Example<S> example) {
        return pollRepository.count(example);
    }

    public <S extends Poll> boolean exists(Example<S> example) {
        return pollRepository.exists(example);
    }
}
