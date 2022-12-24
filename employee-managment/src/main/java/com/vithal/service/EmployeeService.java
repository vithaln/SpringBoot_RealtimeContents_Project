package com.vithal.service;

import java.util.List;

import com.vithal.dto.AddressRequest;
import com.vithal.dto.EmployeeRequest;
import com.vithal.dto.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse getEmployeeById(Integer employeeId);

    EmployeeResponse updateEmployeeById(Integer empId, EmployeeRequest request);

    Integer deleteEmployeeById(Integer empId);
}
