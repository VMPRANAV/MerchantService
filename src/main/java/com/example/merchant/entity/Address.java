package com.example.merchant.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;

public class Address {
@NotBlank
@JsonProperty("street")
    private String street;
@NotBlank
@JsonProperty("city")
    private String city;
@NotBlank
@JsonProperty("state")
    private String state;
@NotBlank
@JsonProperty("pincode")
    private String pincode;
@NotBlank
@JsonProperty("country")
     private String country;
}
