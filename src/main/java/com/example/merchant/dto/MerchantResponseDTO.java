package com.example.merchant.dto;

import com.example.merchant.entity.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantResponseDTO {
    private String merchantId;
    private String merchantName;
    private String email;
    private String  phone;
    private String companyName;
    private Address companyAddress;
    private String GSTNumber;
    private List<Address>warehouseAddress;

}
