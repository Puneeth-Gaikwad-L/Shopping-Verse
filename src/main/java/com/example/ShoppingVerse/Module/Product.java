package com.example.ShoppingVerse.Module;

import com.example.ShoppingVerse.Enum.ProductCategory;
import com.example.ShoppingVerse.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="product")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productNumber;

    String productName;

    int price;

    int availableQuantity;

    @Enumerated(EnumType.STRING)
    ProductCategory category;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(referencedColumnName = "sellerEmailId")
    Seller seller;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
}
