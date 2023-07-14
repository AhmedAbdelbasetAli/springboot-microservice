package net.AhmedAli.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.AhmedAli.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
