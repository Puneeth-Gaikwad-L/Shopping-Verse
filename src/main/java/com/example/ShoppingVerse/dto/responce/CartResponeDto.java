package com.example.ShoppingVerse.dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponeDto {

    String customerName;

    List<ItemResponceDto> cartItems;

    int cartTotal;
}
