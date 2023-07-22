package net.AhmedAli.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organization;
}
