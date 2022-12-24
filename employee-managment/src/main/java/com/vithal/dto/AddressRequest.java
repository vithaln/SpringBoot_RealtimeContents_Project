package com.vithal.dto;

import com.vithal.enums.AddressType;

import lombok.Data;

@Data
public class AddressRequest {
    private String city;
    private String state;
    private String pinCode;
    private AddressType addressType;
}
