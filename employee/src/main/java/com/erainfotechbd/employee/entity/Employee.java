package com.erainfotechbd.employee.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (
        name="employeeInfo" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"empId"}),
        @UniqueConstraint(columnNames = {"empMobile"})

}
)
public class Employee {
    @Id
    @GeneratedValue (
            strategy = GenerationType.AUTO
    )
    private Long id;

    @Column(name="empId" , nullable = false)
    private Long empId;

    @Column(name="empName")
    private String empName;

    @Column(name="empMobile", nullable = false)
    private String empMobile;

    @Column(name="empSalary")
    private Long empSalary;

}
