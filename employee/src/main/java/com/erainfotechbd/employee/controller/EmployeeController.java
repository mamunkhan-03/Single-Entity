package com.erainfotechbd.employee.controller;
import com.erainfotechbd.employee.dto.EmployeeDto;
import com.erainfotechbd.employee.dto.ResponseEmpDto;
import com.erainfotechbd.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    EmployeeService employeeService;

    //create employee api
    @PostMapping
    public ResponseEntity<ResponseEmpDto> createEmployee (@RequestBody EmployeeDto employeeDto){
        ResponseEmpDto employeeResponse=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    //create getALl api

    @GetMapping
    public List<EmployeeDto> getAllEmployee (){
        return employeeService.getAllEmployee();
    }

    // create getById api
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable (name="id")Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // update by id api
    @PutMapping("/{id}")
    public ResponseEntity <ResponseEmpDto>  updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable (name="id")Long id ){
        System.out.println("employeeDto = " + employeeDto);
        ResponseEmpDto employeeResponse=  employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    //delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseEmpDto> deleteEmployee (@PathVariable (name="id")Long id ){
        ResponseEmpDto employeeResponse  =employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    //create get api by employee_id
    @GetMapping("/byId/{empId}")
    public EmployeeDto findByEmpId(@PathVariable Long empId) {
        return employeeService.getByEmpId(empId);
    }

    //create get api by employee mobile number
    @GetMapping("byMobile/{empMobile}")
    public EmployeeDto findByEmpMobile (@PathVariable String empMobile){
        return employeeService.getByEmpMobile(empMobile);
    }


    //create get api by employee name
    @GetMapping("byName/{empName}")
    public EmployeeDto findByEmpName (@PathVariable String empName){
        return employeeService.getByEmpName(empName);
    }


    @PatchMapping("/{id}")
    public ResponseEntity <ResponseEmpDto>  updateEmployee2(@RequestBody EmployeeDto employeeDto,@PathVariable (name="id")Long id ){
        ResponseEmpDto employeeResponse=  employeeService.updateEmpByPatch(employeeDto, id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

}
