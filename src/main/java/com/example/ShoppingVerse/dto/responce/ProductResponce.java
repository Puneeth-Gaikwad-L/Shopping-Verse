package com.example.ShoppingVerse.dto.responce;

import com.example.ShoppingVerse.Enum.ProductCategory;
import com.example.ShoppingVerse.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponce {
    String sellerName;

    String productName;

    int price;

    int availableQuantity;

    ProductCategory productCategory;

    ProductStatus productStatus;
}
