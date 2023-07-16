package net.AhmedAli.employeeservice.service;

import net.AhmedAli.employeeservice.dto.APIResponseDto;
import net.AhmedAli.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto gEmployeeDtoById(Long employeeId);

}
