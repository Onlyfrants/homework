package org.ibs.service_example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.ibs.service_example.domain.Course;
import org.ibs.service_example.domain.Department;
import org.ibs.service_example.domain.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class DbTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup(){
        Department department = new Department(null, "IT");
        Course course = new Course(null, "REST service");

        em.persist(department);
        em.persist(course);
    }

    @Test
    void test(){

    }

    @Test
    void test2(){
        employeeRepository.findByFirstName("a").get();
    }
}
