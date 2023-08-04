package com.example.ShoppingVerse.Repository;

import com.example.ShoppingVerse.Module.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

    public Seller findBySellerEmailId(String sellerEmailId);
}
