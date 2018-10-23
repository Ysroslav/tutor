package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public List<Department> findAll(Sort sort) {
        return departmentRepository.findAll(sort);
    }

    public List<Department> findAllById(Iterable<String> iterable) {
        return departmentRepository.findAllById(iterable);
    }

    public <S extends Department> List<S> saveAll(Iterable<S> iterable) {
        return departmentRepository.saveAll(iterable);
    }

    public void flush() {
        departmentRepository.flush();
    }

    public <S extends Department> S saveAndFlush(S s) {
        return departmentRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Department> iterable) {
        departmentRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        departmentRepository.deleteAllInBatch();
    }

    public Department getOne(String s) {
        return departmentRepository.getOne(s);
    }

    public <S extends Department> List<S> findAll(Example<S> example) {
        return departmentRepository.findAll(example);
    }

    public <S extends Department> List<S> findAll(Example<S> example, Sort sort) {
        return departmentRepository.findAll(example, sort);
    }

    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    public <S extends Department> S save(S s) {
        return departmentRepository.save(s);
    }

    public Optional<Department> findById(String s) {
        return departmentRepository.findById(s);
    }

    public boolean existsById(String s) {
        return departmentRepository.existsById(s);
    }

    public long count() {
        return departmentRepository.count();
    }

    public void deleteById(String s) {
        departmentRepository.deleteById(s);
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    public void deleteAll(Iterable<? extends Department> iterable) {
        departmentRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        departmentRepository.deleteAll();
    }

    public <S extends Department> Optional<S> findOne(Example<S> example) {
        return departmentRepository.findOne(example);
    }

    public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
        return departmentRepository.findAll(example, pageable);
    }

    public <S extends Department> long count(Example<S> example) {
        return departmentRepository.count(example);
    }

    public <S extends Department> boolean exists(Example<S> example) {
        return departmentRepository.exists(example);
    }

    public List<Department> findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
