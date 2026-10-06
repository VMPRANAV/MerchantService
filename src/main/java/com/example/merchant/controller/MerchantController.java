package com.example.merchant.controller;

import com.example.merchant.dto.MerchantRequestDTO;
import com.example.merchant.dto.MerchantResponseDTO;
import com.example.merchant.service.MerchantService;
import com.example.merchant.service.MerchantServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;
    @PostMapping
    public ResponseEntity<MerchantResponseDTO> createMerchant(@Valid @RequestBody MerchantRequestDTO merchantRequestDTO){

        return  ResponseEntity.ok().body(merchantService.createMerchant(merchantRequestDTO));
    }
    @PutMapping("/{merchantId}")
    public ResponseEntity<MerchantResponseDTO> updateMerchant(@PathVariable String merchantId, @RequestBody MerchantRequestDTO merchantRequestDTO){
        return  ResponseEntity.ok().body(merchantService.updateMerchant(merchantId,merchantRequestDTO));

    }
    @DeleteMapping("/{merchantId}")
    public  ResponseEntity<Void> deleteMerchant(@PathVariable String merchantId){
        merchantService.deleteMerchant(merchantId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{merchantId}")
    public ResponseEntity<MerchantResponseDTO> getMerchantDetails(@PathVariable String merchantId){
        return ResponseEntity.ok().body(merchantService.getMerchantDetails(merchantId));
    }

}
