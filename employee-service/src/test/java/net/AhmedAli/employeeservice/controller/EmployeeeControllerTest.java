package net.AhmedAli.employeeservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.AhmedAli.employeeservice.dto.APIResponseDto;
import net.AhmedAli.employeeservice.dto.EmployeeDto;
import net.AhmedAli.employeeservice.service.EmployeeService;

public class EmployeeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEmployee() {
        // Arrange
        EmployeeDto employeeDto = new EmployeeDto(null, "John", "Doe", "john@example.com", "HR", "ORG-1");
        EmployeeDto savedEmployee = new EmployeeDto(1L, "John", "Doe", "john@example.com", "HR", "ORG-1");

        when(employeeService.saveEmployee(employeeDto)).thenReturn(savedEmployee);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.saveEmployee(employeeDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedEmployee, response.getBody());
    }

    @Test
    public void testGetEmployee() {
        // Arrange
        Long employeeId = 1L;
        EmployeeDto employeeDto = new EmployeeDto(employeeId, "John", "Doe", "john@example.com", "HR", "ORG-1");
        APIResponseDto apiResponseDto = new APIResponseDto(employeeDto, null, null);

        when(employeeService.getEmployeeById(employeeId)).thenReturn(apiResponseDto);

        // Act
        ResponseEntity<APIResponseDto> response = employeeController.getEmployee(employeeId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(apiResponseDto, response.getBody());
    }
}
