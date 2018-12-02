package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.repository.RoleRepository;
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
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public List<Role> findAll(Sort sort) {
        return roleRepository.findAll(sort);
    }

    public List<Role> findAllById(Iterable<String> iterable) {
        return roleRepository.findAllById(iterable);
    }

    public <S extends Role> List<S> saveAll(Iterable<S> iterable) {
        return roleRepository.saveAll(iterable);
    }

    @Transactional
    public void deleteInBatch(Iterable<Role> iterable) {
        roleRepository.deleteInBatch(iterable);
    }

    @Transactional
    public void deleteAllInBatch() {
        roleRepository.deleteAllInBatch();
    }

    public Role getOne(String s) {
        return roleRepository.getOne(s);
    }

    public <S extends Role> List<S> findAll(Example<S> example) {
        return roleRepository.findAll(example);
    }

    public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        return roleRepository.findAll(example, sort);
    }

    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Transactional
    public <S extends Role> S save(S s) {
        return roleRepository.save(s);
    }

    public Optional<Role> findById(String s) {
        return roleRepository.findById(s);
    }

    public boolean existsById(String s) {
        return roleRepository.existsById(s);
    }

    public long count() {
        return roleRepository.count();
    }

    @Transactional
    public void deleteById(String s) {
        roleRepository.deleteById(s);
    }

    @Transactional
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Transactional
    public void deleteAll(Iterable<? extends Role> iterable) {
        roleRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return roleRepository.findOne(example);
    }

    public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        return roleRepository.findAll(example, pageable);
    }

    public <S extends Role> long count(Example<S> example) {
        return roleRepository.count(example);
    }

    public <S extends Role> boolean exists(Example<S> example) {
        return roleRepository.exists(example);
    }
}
