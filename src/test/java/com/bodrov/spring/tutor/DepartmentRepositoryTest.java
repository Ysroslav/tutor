package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName(){
        Assert.assertEquals(departmentRepository.count(), 0);
        Assert.assertNull(departmentRepository.findByDepartmentName("New department"));
        final Department department = new Department();
        department.setDepartmentName("New department");
        departmentRepository.save(department);
        Assert.assertEquals(departmentRepository.count(), 1);
        Assert.assertNotNull(departmentRepository.findByDepartmentName("New department"));
        departmentRepository.delete(department);
    }

    @Test
    public void testDeleteAll(){
        departmentRepository.deleteAll();
        Assert.assertEquals(departmentRepository.count(), 0);
    }

    @Test
    public void testCRUD(){
        departmentRepository.deleteAll();
        Assert.assertTrue(departmentRepository.findAll().isEmpty());
        departmentRepository.save(new Department());
        Assert.assertFalse(departmentRepository.findAll().isEmpty());
        departmentRepository.deleteAll();
        Assert.assertTrue(departmentRepository.findAll().isEmpty());
    }
}
