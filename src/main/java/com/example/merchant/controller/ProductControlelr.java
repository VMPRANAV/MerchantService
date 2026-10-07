package com.example.merchant.controller;

import com.example.merchant.dto.ProductVariantResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductControlelr {
    @GetMapping(value="/products/variant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductVariantResponseDTO getProductVariant(
            @RequestParam String productId,
            @RequestParam String variantId) {

        return new ProductVariantResponseDTO(
                productId,
                "iPhone 17",
                "Powerful smartphone",
                "Apple",
                "Mobile",
                "Latest iPhone",
                variantId,
                "iphone.jpg",
                "Black",
                null,
                "256GB",
                "8GB",
                null
        );
    }

}
