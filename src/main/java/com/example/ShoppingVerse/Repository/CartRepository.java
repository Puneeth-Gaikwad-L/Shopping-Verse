package com.example.ShoppingVerse.Repository;

import com.example.ShoppingVerse.Module.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
