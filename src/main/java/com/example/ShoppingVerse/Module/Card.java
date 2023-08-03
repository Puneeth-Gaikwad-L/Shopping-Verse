package com.example.ShoppingVerse.Module;

import com.example.ShoppingVerse.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "card")
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(unique = true)
    String cardNo;

    int cvv;

    Date validTill;

    @Enumerated(EnumType.STRING)
    CardType cardType;

    @ManyToOne
    @JoinColumn(referencedColumnName = "emailId")
    Customer customer;
}
