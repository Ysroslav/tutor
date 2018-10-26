package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.DepartmentRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class StaffRepositoryTest {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName(){
        Assert.assertEquals(staffRepository.count(), 0);
        Assert.assertNull(staffRepository.findByFirstName("Ivan"));
        final Staff staff = new Staff();
        staff.setFirstName("Ivan");
        staff.setLastName("Ivanov");
        final Department department = new Department();
        department.setDepartmentName("IT-department");
        departmentRepository.save(department);
        staff.setDepartment(department);
        staffRepository.save(staff);
        Assert.assertEquals(staffRepository.count(), 1);
        Assert.assertNotNull(staffRepository.findByFirstName("Ivanov"));
        staffRepository.delete(staff);
        departmentRepository.delete(department);
    }

    @Test
    public void testDeleteAll(){
        staffRepository.deleteAll();
        Assert.assertEquals(staffRepository.count(), 0);
    }

    @Test
    public void testCRUD(){
        staffRepository.deleteAll();
        Assert.assertTrue(staffRepository.findAll().isEmpty());
        staffRepository.save(new Staff());
        Assert.assertFalse(staffRepository.findAll().isEmpty());
        staffRepository.deleteAll();
        Assert.assertTrue(staffRepository.findAll().isEmpty());
    }
}
