package com.example.merchant.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import  java.util.List;
@Document(collection="merchant_profile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    @Id
    private String merchantId;
    private String merchantName;
    private String email;
    private String phone;
    private String companyName;
    private Address companyAddress;
    @Indexed(unique = true)
    private String GSTNumber;
    private List<Address>warehouseAddress;
}
