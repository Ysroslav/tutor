package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public List<Staff> findAll(Sort sort) {
        return staffRepository.findAll(sort);
    }

    public List<Staff> findAllById(Iterable<String> iterable) {
        return staffRepository.findAllById(iterable);
    }

    public <S extends Staff> List<S> saveAll(Iterable<S> iterable) {
        return staffRepository.saveAll(iterable);
    }

    public void flush() {
        staffRepository.flush();
    }

    public <S extends Staff> S saveAndFlush(S s) {
        return staffRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Staff> iterable) {
        staffRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        staffRepository.deleteAllInBatch();
    }

    public Staff getOne(String s) {
        return staffRepository.getOne(s);
    }

    public <S extends Staff> List<S> findAll(Example<S> example) {
        return staffRepository.findAll(example);
    }

    public <S extends Staff> List<S> findAll(Example<S> example, Sort sort) {
        return staffRepository.findAll(example, sort);
    }

    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    public <S extends Staff> S save(S s) {
        return staffRepository.save(s);
    }

    public Optional<Staff> findById(String s) {
        return staffRepository.findById(s);
    }

    public boolean existsById(String s) {
        return staffRepository.existsById(s);
    }

    public long count() {
        return staffRepository.count();
    }

    public void deleteById(String s) {
        staffRepository.deleteById(s);
    }

    public void delete(Staff staff) {
        staffRepository.delete(staff);
    }

    public void deleteAll(Iterable<? extends Staff> iterable) {
        staffRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        staffRepository.deleteAll();
    }

    public <S extends Staff> Optional<S> findOne(Example<S> example) {
        return staffRepository.findOne(example);
    }

    public <S extends Staff> Page<S> findAll(Example<S> example, Pageable pageable) {
        return staffRepository.findAll(example, pageable);
    }

    public <S extends Staff> long count(Example<S> example) {
        return staffRepository.count(example);
    }

    public <S extends Staff> boolean exists(Example<S> example) {
        return staffRepository.exists(example);
    }
}
