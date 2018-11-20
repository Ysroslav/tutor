package com.bodrov.spring.tutor.database.service;

import com.bodrov.spring.tutor.database.helper.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private ApplicationContext applicationContext;

    private List<MyRepository> repositories;

    public List<MyRepository> getListRepositories() throws Exception {
        repositories = new ArrayList<>();
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Repository.class);
        for (Map.Entry entry : beans.entrySet()) {
            Object cl = applicationContext.getBean(entry.getKey().toString());
            JpaRepository repository = (JpaRepository) cl;
            repositories.add(new MyRepository(entry.getKey().toString(), repository.count()));
        }
        return repositories;
    }

    public List<MyRepository> getRepositories() {
        return repositories;
    }
}
