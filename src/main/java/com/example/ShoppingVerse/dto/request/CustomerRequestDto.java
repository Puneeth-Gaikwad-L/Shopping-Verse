package com.example.ShoppingVerse.dto.request;

import com.example.ShoppingVerse.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequestDto {

    String name;

    String emailId;

    String modNo;

    Gender gender;
}
