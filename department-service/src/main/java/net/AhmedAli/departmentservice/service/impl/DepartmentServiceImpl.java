package net.AhmedAli.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.AhmedAli.departmentservice.dto.DepartmentDto;
import net.AhmedAli.departmentservice.entity.Department;
import net.AhmedAli.departmentservice.mapper.DepartmentMapper;
import net.AhmedAli.departmentservice.repository.DepartmentRepository;
import net.AhmedAli.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl  implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

    
}
