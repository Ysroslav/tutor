package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ExternalizationTest {

    @Autowired(required = false)
    private JacksonTester<Department> json;

    @Test
    public void toJsonTest() throws IOException{
        final Department department = new Department();
        department.setDepartmentName("New department");
        assertThat(json.write(department))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("New department");
    }
}
