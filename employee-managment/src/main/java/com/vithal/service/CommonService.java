package com.vithal.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.vithal.dto.AddressRequest;
import com.vithal.dto.EmployeeRequest;
import com.vithal.entity.Address;
import com.vithal.entity.Employee;

@Service
@Slf4j
public class CommonService {

    public Employee updateEmployee(Employee employee, EmployeeRequest employeeRequest) {
        log.info("Inside CommonService Class updateEmployee() method.");
        if (employeeRequest.getEmployeeFirstName() != null) {
            employee.setFirstName(employeeRequest.getEmployeeFirstName());
        }
        if (employeeRequest.getEmployeeLastName()!= null) {
            employee.setLastName(employeeRequest.getEmployeeLastName());
        }
        if (employeeRequest.getEmployeeAge() != null) {
            employee.setAge(employeeRequest.getEmployeeAge());
        }
        if (employeeRequest.getEmployeeEmailId() != null) {
            employee.setEmailId(employeeRequest.getEmployeeEmailId());
        }
        if (employeeRequest.getEmployeeMobileNumber() != null) {
            employee.setMobileNumber(employeeRequest.getEmployeeMobileNumber());
        }
        if (employeeRequest.getGender() != null) {
            employee.setGender(employeeRequest.getGender().name());
        }
        if (employeeRequest.getDepartment() != null) {
            employee.setDepartment(employeeRequest.getDepartment().name());
        }
        return employee;
    }

    public Address updateAddress(Address address, AddressRequest addressRequest) {
        if (addressRequest.getCity() != null) {
            address.setCity(addressRequest.getCity());
        }
        if (addressRequest.getState() != null) {
            address.setState(addressRequest.getState());
        }
        if (addressRequest.getPinCode() != null) {
            address.setPinCode(addressRequest.getPinCode());
        }
        if (addressRequest.getAddressType() != null) {
            address.setAddressType(addressRequest.getAddressType().name());
        }
        return address;
    }
}
