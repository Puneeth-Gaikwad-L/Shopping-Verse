package com.example.ShoppingVerse.dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerResponce {
    String name;

    String sellerEmailId;

    String pan;
}
