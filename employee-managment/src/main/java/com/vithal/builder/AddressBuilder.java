package com.vithal.builder;

import org.springframework.stereotype.Component;

import com.vithal.dto.*;
import com.vithal.entity.Address;
import com.vithal.enums.AddressType;
import com.vithal.utils.AppUtils;

import java.util.Optional;

@Component
public class AddressBuilder {


    public Address getAddress(AddressRequest addressRequest) {
        return Address.builder()
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .pinCode(addressRequest.getPinCode())
                .addressType(addressRequest.getAddressType().name())
                .build();
    }

    public AddressResponse getAddressResponse(Address address) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        boolean isAddressSaved = Optional.ofNullable(address).isPresent();
        ResponseStatus getStatus = isAddressSaved ? AppUtils.getSuccessStatus() : AppUtils.getErrorStatus();
        EmployeeDTO getEmployeeDTO = null;
        if (address.getEmployee() != null)
            getEmployeeDTO = employeeBuilder.getEmployeeDTO(address.getEmployee());
        return AddressResponse.builder()
                .addressDTO(getAddressDTO(address))
                .employeeDTO(getEmployeeDTO)
                .responseStatus(getStatus)
                .build();
    }


    public AddressDTO getAddressDTO(Address address) {
        return AddressDTO.builder()
                .addressId(address.getAddressId())
                .city(address.getCity())
                .state(address.getState())
                .pinCode(address.getPinCode())
                .addressType(AddressType.valueOf(address.getAddressType()))
                .addressCreatedDate(AppUtils.getStringFormattedDate(address.getCreatedDate()))
                .addressUpdatedDate(AppUtils.getStringFormattedDate(address.getUpdatedDate()))
                .build();
    }
}


