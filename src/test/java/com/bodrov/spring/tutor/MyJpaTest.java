package com.bodrov.spring.tutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyJpaTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testJpa() throws Exception {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Repository.class);
        for (Map.Entry entry : beans.entrySet()) {
            Object cl = applicationContext.getBean(entry.getKey().toString());
            JpaRepository repository = (JpaRepository) cl;
            System.out.println(entry.getKey());
            System.out.println(repository.count());
        }
        /*Map<String, Object> beansTab = applicationContext.getBeansWithAnnotation(Table.class);
        System.out.println(beansTab.size());
        for (Map.Entry entry : beansTab.entrySet()) {
            Object cl = applicationContext.getBean(entry.getKey().toString());
            AbstractEntity ent = (AbstractEntity) cl;
            System.out.println(ent.tabName);
        }*/




    }
}
