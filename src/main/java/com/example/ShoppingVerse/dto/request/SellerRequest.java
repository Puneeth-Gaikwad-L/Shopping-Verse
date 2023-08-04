package com.example.ShoppingVerse.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerRequest {
    String name;

    String sellerEmailId;

    String pan;
}
