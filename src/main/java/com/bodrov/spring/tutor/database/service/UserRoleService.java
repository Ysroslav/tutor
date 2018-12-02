package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.repository.UserRoleRepository;
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
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> findAllByUser(User user) {
        return userRoleRepository.findAllByUser(user);
    }

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public List<UserRole> findAll(Sort sort) {
        return userRoleRepository.findAll(sort);
    }

    public List<UserRole> findAllById(Iterable<String> iterable) {
        return userRoleRepository.findAllById(iterable);
    }

    public <S extends UserRole> List<S> saveAll(Iterable<S> iterable) {
        return userRoleRepository.saveAll(iterable);
    }

    @Transactional
    public void deleteInBatch(Iterable<UserRole> iterable) {
        userRoleRepository.deleteInBatch(iterable);
    }

    @Transactional
    public void deleteAllInBatch() {
        userRoleRepository.deleteAllInBatch();
    }

    public UserRole getOne(String s) {
        return userRoleRepository.getOne(s);
    }

    public <S extends UserRole> List<S> findAll(Example<S> example) {
        return userRoleRepository.findAll(example);
    }

    public <S extends UserRole> List<S> findAll(Example<S> example, Sort sort) {
        return userRoleRepository.findAll(example, sort);
    }

    public Page<UserRole> findAll(Pageable pageable) {
        return userRoleRepository.findAll(pageable);
    }

    @Transactional
    public <S extends UserRole> S save(S s) {
        return userRoleRepository.save(s);
    }

    public Optional<UserRole> findById(String s) {
        return userRoleRepository.findById(s);
    }

    public boolean existsById(String s) {
        return userRoleRepository.existsById(s);
    }

    public long count() {
        return userRoleRepository.count();
    }

    @Transactional
    public void deleteById(String s) {
        userRoleRepository.deleteById(s);
    }

    @Transactional
    public void delete(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    @Transactional
    public void deleteAll(Iterable<? extends UserRole> iterable) {
        userRoleRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        userRoleRepository.deleteAll();
    }

    public <S extends UserRole> Optional<S> findOne(Example<S> example) {
        return userRoleRepository.findOne(example);
    }

    public <S extends UserRole> Page<S> findAll(Example<S> example, Pageable pageable) {
        return userRoleRepository.findAll(example, pageable);
    }

    public <S extends UserRole> long count(Example<S> example) {
        return userRoleRepository.count(example);
    }

    public <S extends UserRole> boolean exists(Example<S> example) {
        return userRoleRepository.exists(example);
    }
}
