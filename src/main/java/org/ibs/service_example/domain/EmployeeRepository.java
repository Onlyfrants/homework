package org.ibs.service_example.domain;


import org.ibs.service_example.domain.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    Employee findByBossId(Long bossId);

@Query
    ("SELECT e FROM Employee e JOIN Employee b ON e.boss = b WHERE e.salary > b.salary")
    Employee findEmployeesWithHigherSalaryThanBoss();
}
