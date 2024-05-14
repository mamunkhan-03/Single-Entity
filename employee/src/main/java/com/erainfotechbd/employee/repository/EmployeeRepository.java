package com.erainfotechbd.employee.repository;

import com.erainfotechbd.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmpId(Long empId);

    Employee findByEmpMobile (String empMobile);

    Employee findByEmpName (String empName);

}






