package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName(){
        Assert.assertEquals(departmentRepository.count(), 0);
        final Department department = new Department();
        department.setDepartmentName("New department");
        departmentRepository.save(department);
        Assert.assertEquals(departmentRepository.count(), 1);
        departmentRepository.delete(department);
    }
}
