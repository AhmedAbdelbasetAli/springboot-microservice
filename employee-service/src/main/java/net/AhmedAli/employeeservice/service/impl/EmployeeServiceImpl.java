package net.AhmedAli.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.AhmedAli.employeeservice.dto.EmployeeDto;
import net.AhmedAli.employeeservice.entity.Employee;
import net.AhmedAli.employeeservice.repository.EmployeeRepository;
import net.AhmedAli.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
       );

       Employee saveDEmployee= employeeRepository.save(employee);

       EmployeeDto savedEmployeeDto = new EmployeeDto(
           saveDEmployee.getId(),
           saveDEmployee.getFirstName(),
           saveDEmployee.getLastName(),
           saveDEmployee.getEmail()
       );
       return savedEmployeeDto;
    }

    @Override
    public EmployeeDto gEmployeeDtoById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).get();

       EmployeeDto employeeDto = new EmployeeDto(
           employee.getId(),
           employee.getFirstName(),
           employee.getLastName(),
           employee.getEmail()
       );
       return employeeDto;
    }
    
}
