package com.example.ShoppingVerse.dto.request;

import com.example.ShoppingVerse.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardRequest {

    String cardNo;

    int cvv;

    Date validTill;

    CardType cardType;

    String customerEmail;

}
