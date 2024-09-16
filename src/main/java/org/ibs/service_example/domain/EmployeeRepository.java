package org.ibs.service_example.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByFirstName(String firstName);

    Optional<Employee> findByBossId(Long bossId);

@Query
    ("SELECT e FROM Employee e JOIN Employee b ON e.boss = b WHERE e.salary > 100000 AND b.salary <= 100000")
    Optional<Employee> findEmployeesWithHigherSalaryThanBoss();
}
