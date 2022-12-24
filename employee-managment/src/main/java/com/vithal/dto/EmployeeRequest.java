package com.vithal.dto;

import com.vithal.enums.Department;
import com.vithal.enums.Gender;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeMobileNumber;
    private String employeeEmailId;
    private Integer employeeAge;
    private Gender gender;
    private Department department;
}
