package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorApplicationTests {

	@Autowired
	private DepartmentService departmentService;

	@Test
	public void contextLoads() {
		final Department department = new Department();
		department.setDepartmentName("IT - отдел");
		departmentService.save(department);
		List<Department> list = new ArrayList<Department>();
		list = departmentService.findAll();
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i).getId() + " "+ list.get(i).getDepartmentName());
		}
	}

}
