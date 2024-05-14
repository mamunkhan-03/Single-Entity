package com.erainfotechbd.employee.service.impl;

import com.erainfotechbd.employee.dto.EmployeeDto;
import com.erainfotechbd.employee.dto.ResponseEmpDto;
import com.erainfotechbd.employee.entity.Employee;
import com.erainfotechbd.employee.exception.ResourceNotFoundException;
import com.erainfotechbd.employee.repository.EmployeeRepository;
import com.erainfotechbd.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper=mapper;
    }


    @Override
    public ResponseEmpDto createEmployee(EmployeeDto employeeDto) {

        ResponseEmpDto responseEmpDto=new ResponseEmpDto();

        Employee employee=mapToEntity(employeeDto);

        try {
            Employee newEmployee= employeeRepository.save(employee);
            responseEmpDto.setResponseCode(1);
            responseEmpDto.setResponseMessage("User data insert successfully!");
        }

        catch (Exception exce){
            exce.printStackTrace();
        }
        return responseEmpDto;

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees= employeeRepository.findAll();  //collect all the employees
        return employees.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee", "id",id));
        return mapToDTO(employee);
    }

    @Override
    public ResponseEmpDto updateEmployee(EmployeeDto employeeDto, Long id) {
        //get post by id from the database
       Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee", "id",id));
       ResponseEmpDto responseEmpDto=new ResponseEmpDto();

        employee.setEmpId(employeeDto.getEmpId());
        employee.setEmpName(employeeDto.getEmpName());
        employee.setEmpMobile(employeeDto.getEmpMobile());
        employee.setEmpSalary(employeeDto.getEmpSalary());

        try {
            Employee updateEmployee = employeeRepository.save(employee);
            responseEmpDto.setResponseCode(2);
            responseEmpDto.setResponseMessage("Updated successfully");
        }

        catch (Exception exce){
            exce.printStackTrace();
        }
        return responseEmpDto;
    }

    @Override
    public ResponseEmpDto deleteEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee", "id",id));

        ResponseEmpDto responseEmpDto=new ResponseEmpDto();
        try {
            employeeRepository.delete(employee);
            responseEmpDto.setResponseCode(3);
            responseEmpDto.setResponseMessage("Deleted successfully");
        }
        catch (Exception exce){
            exce.printStackTrace();

        }
       return responseEmpDto;
    }

    @Override
    public EmployeeDto getByEmpId(Long empId) {

        Employee employee=employeeRepository.findByEmpId(empId);
        EmployeeDto employeeDto=mapToDTO(employee);
        return employeeDto;
    }

    @Override
    public EmployeeDto getByEmpMobile(String empMobile) {

        Employee employee=employeeRepository.findByEmpMobile(empMobile);
        return mapToDTO(employee);
    }

    @Override
    public EmployeeDto getByEmpName(String empName) {
        Employee employee=employeeRepository.findByEmpName(empName);
        return mapToDTO(employee);
    }

    @Override
    public ResponseEmpDto updateEmpByPatch(EmployeeDto employeeDto, Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee", "id",id));

        ResponseEmpDto responseEmpDto=new ResponseEmpDto();
        employee.setEmpId(employeeDto.getEmpId());
        employee.setEmpName(employeeDto.getEmpName());
        employee.setEmpMobile(employeeDto.getEmpMobile());
        employee.setEmpSalary(employeeDto.getEmpSalary());

        try {
            Employee updateEmployee = employeeRepository.save(employee);
            responseEmpDto.setResponseCode(4);
            responseEmpDto.setResponseMessage("Updated successfully with patch");
        }
        catch (Exception exce){
            exce.printStackTrace();

        }
        return responseEmpDto;
    }


    // entity into dto
    private EmployeeDto mapToDTO(Employee employee){
        EmployeeDto employeeDto=mapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    //convert dto into entity
    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee=mapper.map(employeeDto, Employee.class);
        return employee;

    }
}
