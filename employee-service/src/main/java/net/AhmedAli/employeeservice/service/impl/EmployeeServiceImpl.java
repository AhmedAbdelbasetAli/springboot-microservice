package net.AhmedAli.employeeservice.service.impl;


import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;
import net.AhmedAli.employeeservice.dto.APIResponseDto;
import net.AhmedAli.employeeservice.dto.DepartmentDto;
import net.AhmedAli.employeeservice.dto.EmployeeDto;
import net.AhmedAli.employeeservice.entity.Employee;
import net.AhmedAli.employeeservice.repository.EmployeeRepository;
import net.AhmedAli.employeeservice.service.APIClient;
import net.AhmedAli.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;
    //private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail(),
            employeeDto.getDepartmentCode()
       );

       Employee saveDEmployee= employeeRepository.save(employee);

       EmployeeDto savedEmployeeDto = new EmployeeDto(
           saveDEmployee.getId(),
           saveDEmployee.getFirstName(),
           saveDEmployee.getLastName(),
           saveDEmployee.getEmail(),
           saveDEmployee.getDepartmentCode()
       );
       return savedEmployeeDto;
    }

    @Override
    public APIResponseDto gEmployeeDtoById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).get();
       
       //ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),DepartmentDto.class);
       
       //DepartmentDto departmentDto = responseEntity.getBody();

        /*DepartmentDto  departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

       DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

       EmployeeDto employeeDto = new EmployeeDto(
           employee.getId(),
           employee.getFirstName(),
           employee.getLastName(),
           employee.getEmail(),
           employee.getDepartmentCode()
       );

       APIResponseDto apiResponseDto = new APIResponseDto();
       apiResponseDto.setEmployee(employeeDto);
       apiResponseDto.setDepartment(departmentDto);

       return apiResponseDto;
    }
    
}
