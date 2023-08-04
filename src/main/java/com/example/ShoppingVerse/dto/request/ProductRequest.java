package com.example.ShoppingVerse.dto.request;

import com.example.ShoppingVerse.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequest {
    String productName;

    int price;

    int availableQuantity;

    ProductCategory productCategory;

    String sellerEmailId;
}
