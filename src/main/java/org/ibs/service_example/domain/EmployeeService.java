package org.ibs.service_example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getSubordinates(Long bossId) {
        return employeeRepository.findByBossId(bossId);
    }

    public Optional<Employee> getBoss(Long employeeId) {
        return employeeRepository.findById(employeeId).map(Employee::getBoss).orElse(null);
    }

    public Optional<Employee> findEmployeesWithHigherSalaryThanBoss() {
        return employeeRepository.findEmployeesWithHigherSalaryThanBoss();
    }
}
