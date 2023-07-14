package net.AhmedAli.departmentservice.service;

import net.AhmedAli.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    
    DepartmentDto getDepartmentByCode(String code);
}
