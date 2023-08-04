package com.example.ShoppingVerse.dto.responce;

import com.example.ShoppingVerse.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponce {

    String customerName;

    String cardNo;

    Date validTill;

    CardType cardType;

}
