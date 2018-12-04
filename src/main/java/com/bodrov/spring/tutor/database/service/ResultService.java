package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> findAllByStaff(Staff staff) {
        return resultRepository.findAllByStaff(staff);
    }

    public long countByStaff(Staff staff) {
        return resultRepository.countByStaff(staff);
    }

    public List<Result> findAllByResultIsNull() {
        return resultRepository.findAllByResultIsNull();
    }

    public List<Result> findAllByResultIsNotNullAndStaff(Staff staff) {
        return resultRepository.findAllByResultIsNotNullAndStaff(staff);
    }

    public List<Result> findAllByResultIsNullAndStaff(Staff staff) {
        return resultRepository.findAllByResultIsNullAndStaff(staff);
    }

    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    public List<Result> findAll(Sort sort) {
        return resultRepository.findAll(sort);
    }

    public List<Result> findAllById(Iterable<String> iterable) {
        return resultRepository.findAllById(iterable);
    }

    @Transactional
    public <S extends Result> List<S> saveAll(Iterable<S> iterable) {
        return resultRepository.saveAll(iterable);
    }

    @Transactional
    public void deleteInBatch(Iterable<Result> iterable) {
        resultRepository.deleteInBatch(iterable);
    }

    @Transactional
    public void deleteAllInBatch() {
        resultRepository.deleteAllInBatch();
    }

    public Result getOne(String s) {
        return resultRepository.getOne(s);
    }

    public <S extends Result> List<S> findAll(Example<S> example) {
        return resultRepository.findAll(example);
    }

    public <S extends Result> List<S> findAll(Example<S> example, Sort sort) {
        return resultRepository.findAll(example, sort);
    }

    public Page<Result> findAll(Pageable pageable) {
        return resultRepository.findAll(pageable);
    }

    public <S extends Result> S save(S s) {
        return resultRepository.save(s);
    }

    public Optional<Result> findById(String s) {
        return resultRepository.findById(s);
    }

    public boolean existsById(String s) {
        return resultRepository.existsById(s);
    }

    public long count() {
        return resultRepository.count();
    }

    @Transactional
    public void deleteById(String s) {
        resultRepository.deleteById(s);
    }

    @Transactional
    public void delete(Result result) {
        resultRepository.delete(result);
    }

    @Transactional
    public void deleteAll(Iterable<? extends Result> iterable) {
        resultRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        resultRepository.deleteAll();
    }

    public <S extends Result> Optional<S> findOne(Example<S> example) {
        return resultRepository.findOne(example);
    }

    public <S extends Result> Page<S> findAll(Example<S> example, Pageable pageable) {
        return resultRepository.findAll(example, pageable);
    }

    public <S extends Result> long count(Example<S> example) {
        return resultRepository.count(example);
    }

    public <S extends Result> boolean exists(Example<S> example) {
        return resultRepository.exists(example);
    }
}
