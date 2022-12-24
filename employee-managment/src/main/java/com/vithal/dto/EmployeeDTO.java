package com.vithal.dto;

import com.vithal.enums.Department;
import com.vithal.enums.Gender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeMobileNumber;
    private String employeeEmailId;
    private Integer employeeAge;
    private Gender gender;
    private Department department;

    private String employeeCreatedDate;
    private String employeeUpdatedDate;
}
