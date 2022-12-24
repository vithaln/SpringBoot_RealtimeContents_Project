package com.vithal.builder;

import org.springframework.stereotype.Component;

import com.vithal.dto.*;
import com.vithal.entity.Address;
import com.vithal.entity.Employee;
import com.vithal.enums.AddressType;
import com.vithal.enums.Department;
import com.vithal.enums.Gender;
import com.vithal.repo.EmployeeRepo;
import com.vithal.utils.AppUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeBuilder {

    public Employee getEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getEmployeeFirstName())
                .lastName(employeeRequest.getEmployeeLastName())
                .emailId(employeeRequest.getEmployeeEmailId())
                .mobileNumber(employeeRequest.getEmployeeMobileNumber())
                .age(employeeRequest.getEmployeeAge())
                .gender(employeeRequest.getGender().name())
                .department(employeeRequest.getDepartment().name())
                .build();
    }

    public EmployeeResponse getEmployeeResponse(Employee employee) {
        AddressBuilder addressBuilder = new AddressBuilder();
        boolean isDataSaved = Optional.ofNullable(employee).isPresent();
        ResponseStatus responseStatus = isDataSaved ? AppUtils.getSuccessStatus() : AppUtils.getErrorStatus();
        List<AddressDTO> addressDTOList = null;
        if (employee.getAddresses() != null) {
            addressDTOList = employee.getAddresses()
                    .stream()
                    .map(address -> addressBuilder.getAddressDTO(address))
                    .collect(Collectors.toList());
        }
        return EmployeeResponse.builder()
                .employeeDTO(getEmployeeDTO(employee))
                .addressDTOS(addressDTOList)
                .responseStatus(responseStatus)
                .build();
    }

    public EmployeeDTO getEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .employeeId(employee.getEmpId())
                .employeeFirstName(employee.getFirstName())
                .employeeLastName(employee.getLastName())
                .employeeAge(employee.getAge())
                .employeeEmailId(employee.getEmailId())
                .employeeMobileNumber(employee.getMobileNumber())
                .department(Department.valueOf(employee.getDepartment()))
                .gender(Gender.valueOf(employee.getGender()))
                .employeeCreatedDate(AppUtils.getStringFormattedDate(employee.getCreatedDate()))
                .employeeUpdatedDate(AppUtils.getStringFormattedDate(employee.getCreatedDate()))
                .build();
    }
}
