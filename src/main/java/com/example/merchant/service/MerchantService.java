package com.example.merchant.service;

import com.example.merchant.dto.MerchantRequestDTO;
import com.example.merchant.dto.MerchantResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface MerchantService {
    public MerchantResponseDTO createMerchant(MerchantRequestDTO merchantRequestDTO);
    public  MerchantResponseDTO updateMerchant(String merchantId, MerchantRequestDTO merchantRequestDTO);
    public void deleteMerchant(String merchantId);
    public MerchantResponseDTO getMerchantDetails(String merchantId);
    public boolean verifyMerchant(String merchantId,String merchantName);
}
