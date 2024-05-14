package com.erainfotechbd.employee.service;


import com.erainfotechbd.employee.dto.EmployeeDto;
import com.erainfotechbd.employee.dto.ResponseEmpDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    ResponseEmpDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployee ();

    EmployeeDto getEmployeeById (Long id);

    ResponseEmpDto updateEmployee (EmployeeDto employeeDto, Long id);

    ResponseEmpDto deleteEmployeeById (Long id);

    EmployeeDto getByEmpId(Long empId);

    EmployeeDto getByEmpMobile (String empMobile);

    EmployeeDto getByEmpName (String empName);

    ResponseEmpDto updateEmpByPatch (EmployeeDto employeeDto, Long id);

//    void deleteByImpId (Long empId );


}
