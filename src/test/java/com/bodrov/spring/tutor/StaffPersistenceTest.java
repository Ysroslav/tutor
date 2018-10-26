package com.bodrov.spring.tutor;

import com.bodrov.spring.tutor.database.entity.Staff;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class StaffPersistenceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test(){
        entityManager.getEntityManager().createQuery("DELETE  FROM Staff").executeUpdate();
        Assert.assertEquals(getCountStaff(),0L);
        entityManager.persist(new Staff());
        Assert.assertEquals(getCountStaff(),1L);
        entityManager.getEntityManager().createQuery("DELETE  FROM Staff").executeUpdate();
        Assert.assertEquals(getCountStaff(),0L);
    }

    private long getCountStaff(){
        return entityManager.getEntityManager().createQuery("SELECT COUNT(e) FROM Staff", Long.class)
                .getSingleResult();
    }
}
