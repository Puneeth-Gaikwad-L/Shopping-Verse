package com.example.ShoppingVerse.dto.responce;

import com.example.ShoppingVerse.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponceDto {

    String itemName;

    int itemPrice;

    int addedQuantity;

    ProductCategory category;
}
