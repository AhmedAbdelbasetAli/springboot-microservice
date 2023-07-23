package net.AhmedAli.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.AhmedAli.departmentservice.dto.DepartmentDto;
import net.AhmedAli.departmentservice.service.DepartmentService;

@Tag(
        name = "CRUD REST APIs for Department Resource",
        description = "CRUD REST APIs - Create Department,  Get Deparment"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor

public class DepartmentController {


    private DepartmentService  departmentService;

    // Build save department Rest API 
    @Operation(
            summary = "Create Department REST API",
            description = "Create Department REST API is used to save department in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<DepartmentDto>(savedDepartmentDto, HttpStatus.CREATED);

    }
     @Operation(
            summary = "Create Department REST API",
            description = "Create Derpartment REST API is used to get department in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentcode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentcode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);

    }

    
}
