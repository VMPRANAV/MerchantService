package com.example.merchant.dto;

import com.example.merchant.entity.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import  jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantRequestDTO {
    @NotBlank
    private String merchantName;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 9, max = 10, message = " number must  9 or 10 digits")
    private String  phone;
    @NotBlank
    private String companyName;
 @Valid
    private Address companyAddress;
    @NotBlank
    private String GSTNumber;
@Valid
    private List<Address> warehouseAddress;
}
