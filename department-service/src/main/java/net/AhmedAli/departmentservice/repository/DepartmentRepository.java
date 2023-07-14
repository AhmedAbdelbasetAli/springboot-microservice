package net.AhmedAli.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.AhmedAli.departmentservice.entity.Department;



public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department  findByDepartmentCode(String departmentCode);
}
