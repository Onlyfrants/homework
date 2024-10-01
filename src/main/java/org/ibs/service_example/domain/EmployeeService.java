package org.ibs.service_example.domain;

import org.ibs.service_example.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getSubordinates(Long bossId) {
        return employeeRepository.findByBossId(bossId);
    }

    public Employee getBoss(Long employeeId) {
        return employeeRepository.findById(employeeId).map(Employee::getBoss).orElse(null);
    }

    public Employee findEmployeesWithHigherSalaryThanBoss() {
        return employeeRepository.findEmployeesWithHigherSalaryThanBoss().getBoss();
    }
}
