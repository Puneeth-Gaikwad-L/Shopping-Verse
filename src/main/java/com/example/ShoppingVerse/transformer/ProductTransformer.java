package com.example.ShoppingVerse.transformer;

import com.example.ShoppingVerse.Enum.ProductStatus;
import com.example.ShoppingVerse.Module.Product;
import com.example.ShoppingVerse.dto.request.ProductRequest;
import com.example.ShoppingVerse.dto.responce.ProductResponce;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class ProductTransformer {

    public static Product ProductRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .availableQuantity(productRequest.getAvailableQuantity())
                .category(productRequest.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .productNumber(String.valueOf(UUID.randomUUID()))
                .build();
    }

    public static ProductResponce ProductToProductResponce(Product product){
        return ProductResponce.builder()
                .sellerName(product.getSeller().getName())
                .productName(product.getProductName())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .productCategory(product.getCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}
