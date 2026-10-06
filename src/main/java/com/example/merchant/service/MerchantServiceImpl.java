package com.example.merchant.service;

import com.example.merchant.dto.MerchantRequestDTO;
import com.example.merchant.dto.MerchantResponseDTO;
import com.example.merchant.entity.Merchant;
import com.example.merchant.exception.ResourceNotFoundException;
import com.example.merchant.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;
    @Override
    public MerchantResponseDTO createMerchant(MerchantRequestDTO merchantRequestDTO) {
        String merchantId=generateMerchantId();
        Merchant merchant= new Merchant().builder()
                .merchantId(merchantId)
                .merchantName(merchantRequestDTO.getMerchantName())
                .email(merchantRequestDTO.getEmail())
                .phone(merchantRequestDTO.getPhone())
                .companyName(merchantRequestDTO.getCompanyName())
                .companyAddress(merchantRequestDTO.getCompanyAddress())
                .GSTNumber(merchantRequestDTO.getGSTNumber())
                .warehouseAddress(merchantRequestDTO.getWarehouseAddress())
                .build();
        merchantRepository.save(merchant);
        return MerchantResponseDTO.builder()
                .merchantId(merchant.getMerchantId())
                .merchantName(merchant.getMerchantName())
                .email(merchant.getEmail())
                .phone(merchant.getPhone())
                .companyName(merchant.getCompanyName())
                .companyAddress(merchant.getCompanyAddress())
                .GSTNumber(merchant.getGSTNumber())
                .warehouseAddress(merchant.getWarehouseAddress())
                .build();
    }
    @Override
    public MerchantResponseDTO updateMerchant(String merchantId,MerchantRequestDTO merchantRequestDTO){
Merchant merchant= merchantRepository.findByMerchantId(merchantId);
if(merchant==null){
    throw  new RuntimeException("Element Not Found");
}
merchant.setMerchantName(merchantRequestDTO.getMerchantName());
merchant.setEmail(merchantRequestDTO.getEmail());
merchant.setPhone(merchantRequestDTO.getPhone());
merchant.setCompanyName(merchantRequestDTO.getCompanyName());
merchant.setCompanyAddress(merchantRequestDTO.getCompanyAddress());
merchant.setGSTNumber(merchantRequestDTO.getGSTNumber());
merchant.setWarehouseAddress(merchantRequestDTO.getWarehouseAddress());
merchantRepository.save(merchant);
return MerchantResponseDTO.builder()
        .merchantId(merchant.getMerchantId())
        .merchantName(merchant.getMerchantName())
        .email(merchant.getEmail())
        .phone(merchant.getPhone())
        .companyName(merchant.getCompanyName())
        .companyAddress(merchant.getCompanyAddress())
        .GSTNumber(merchant.getGSTNumber())
        .warehouseAddress(merchant.getWarehouseAddress())
        .build();

    }

    @Override
public  void deleteMerchant(String merchantId){
    Merchant merchant= merchantRepository.findByMerchantId(merchantId);
    if(merchant==null){
        throw  new ResourceNotFoundException("Merchant Not Found");
    }
    merchantRepository.deleteById(merchantId);

}

    @Override
    public MerchantResponseDTO getMerchantDetails(String merchantId) {
     Merchant merchant= merchantRepository.findByMerchantId(merchantId);
        if(merchant==null){
            throw  new ResourceNotFoundException("Merchant Not Found");
        }
        return  MerchantResponseDTO.builder()
                .merchantId(merchant.getMerchantId())
                .merchantName(merchant.getMerchantName())
                .email(merchant.getEmail())
                .phone(merchant.getPhone())
                .companyName(merchant.getCompanyName())
                .companyAddress(merchant.getCompanyAddress())
                .GSTNumber(merchant.getGSTNumber())
                .warehouseAddress(merchant.getWarehouseAddress())
                .build();
    }

    private String generateMerchantId() {

        long count = merchantRepository.count();

        return String.format("MID_%03d", count + 1);
    }
}
