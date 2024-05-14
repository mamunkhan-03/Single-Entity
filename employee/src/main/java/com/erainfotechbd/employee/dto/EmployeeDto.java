package com.erainfotechbd.employee.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private Long empId;
    private String empName;
    private String empMobile;
    private Long empSalary;

}
