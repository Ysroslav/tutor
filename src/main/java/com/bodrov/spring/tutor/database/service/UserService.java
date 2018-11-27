package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.repository.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    public List<User> findAllById(Iterable<String> iterable) {
        return userRepository.findAllById(iterable);
    }

    @Transactional
    public <S extends User> List<S> saveAll(Iterable<S> iterable) {
        return userRepository.saveAll(iterable);
    }

    @Transactional
    public void deleteInBatch(Iterable<User> iterable) {
        userRepository.deleteInBatch(iterable);
    }

    @Transactional
    public void deleteAllInBatch() {
        userRepository.deleteAllInBatch();
    }

    public User getOne(String s) {
        return userRepository.getOne(s);
    }

    public <S extends User> List<S> findAll(Example<S> example) {
        return userRepository.findAll(example);
    }

    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return userRepository.findAll(example, sort);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public <S extends User> S save(S s) {
        return userRepository.save(s);
    }

    public Optional<User> findById(String s) {
        return userRepository.findById(s);
    }

    public boolean existsById(String s) {
        return userRepository.existsById(s);
    }

    public long count() {
        return userRepository.count();
    }

    @Transactional
    public void deleteById(String s) {
        userRepository.deleteById(s);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Transactional
    public void deleteAll(Iterable<? extends User> iterable) {
        userRepository.deleteAll(iterable);
    }

    @Transactional
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public <S extends User> Optional<S> findOne(Example<S> example) {
        return userRepository.findOne(example);
    }

    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return userRepository.findAll(example, pageable);
    }

    public <S extends User> long count(Example<S> example) {
        return userRepository.count(example);
    }

    public <S extends User> boolean exists(Example<S> example) {
        return userRepository.exists(example);
    }
}
