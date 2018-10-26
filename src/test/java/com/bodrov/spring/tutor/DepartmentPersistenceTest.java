package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentPersistenceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test(){
        entityManager.getEntityManager().createQuery("DELETE  FROM Department").executeUpdate();
        Assert.assertEquals(getCountDepartment(),0L);
        entityManager.persist(new Department());
        Assert.assertEquals(getCountDepartment(),1L);
        entityManager.getEntityManager().createQuery("DELETE  FROM Department").executeUpdate();
        Assert.assertEquals(getCountDepartment(),0L);
    }

    private long getCountDepartment(){
        return entityManager.getEntityManager().createQuery("SELECT COUNT(e) FROM Department", Long.class)
                .getSingleResult();
    }
}
