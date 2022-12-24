package com.vithal.service;

import java.util.List;

import com.vithal.dto.AddressRequest;
import com.vithal.dto.AddressResponse;

public interface AddressService {
    AddressResponse addAddress(Integer employeeId, AddressRequest request);

    List<AddressResponse> getAllAddressByEmployee(Integer empId);

    List<AddressResponse> getAllAddress();

    AddressResponse updateAddressById(Integer addressId, AddressRequest addressRequest);

    Integer deleteAddressById(Integer addressId);

}
