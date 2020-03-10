package com.example.jkl.request;

import lombok.Data;

@Data
public class AddAddressRequest {
    private String name;

    private String provice;

    private String district;

    private String city;

    private String street;

    private Integer postcode;
}
