package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Module.Cart;
import com.example.ShoppingVerse.Module.Customer;
import com.example.ShoppingVerse.Module.Item;
import com.example.ShoppingVerse.Module.Product;
import com.example.ShoppingVerse.Repository.CartRepository;
import com.example.ShoppingVerse.Repository.CustomerRepository;
import com.example.ShoppingVerse.Repository.ItemRepository;
import com.example.ShoppingVerse.Repository.ProductRepository;
import com.example.ShoppingVerse.dto.request.ItemRequestDto;
import com.example.ShoppingVerse.dto.responce.CartResponeDto;
import com.example.ShoppingVerse.transformer.CartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    public CartResponeDto addItemToCart(ItemRequestDto itemRequestDto, Item item) {
        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        Product product = productRepository.findByProductNumber(itemRequestDto.getProductNumber());

        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal() + product.getPrice() * itemRequestDto.getRequiredQuantity());

        item.setCart(cart);
        item.setProduct(product);
        Item savedItem = itemRepository.save(item);

        cart.getItems().add(savedItem);
        product.getItems().add(savedItem);
        Cart savedCart = cartRepository.save(cart);
        productRepository.save(product);

        return CartTransformer.cartToCartResponce(savedCart);
    }
}
