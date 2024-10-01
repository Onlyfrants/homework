package org.ibs.service_example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.ibs.service_example.domain.entity.Course;
import org.ibs.service_example.domain.entity.Department;
import org.ibs.service_example.domain.entity.Employee;
import org.ibs.service_example.domain.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

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
        Employee emp = new Employee(null,"a","b",
                LocalDate.now(),department,500000, List.of(course));

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
