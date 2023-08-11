package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Module.Customer;
import com.example.ShoppingVerse.Module.Item;
import com.example.ShoppingVerse.Module.Product;
import com.example.ShoppingVerse.Repository.CustomerRepository;
import com.example.ShoppingVerse.exception.InsufficentQuantityException;
import com.example.ShoppingVerse.exception.ProductDosntExitsException;
import com.example.ShoppingVerse.Repository.ProductRepository;
import com.example.ShoppingVerse.dto.request.ItemRequestDto;
import com.example.ShoppingVerse.exception.CustomerNotFound;
import com.example.ShoppingVerse.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {
        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        if (customer == null){
            throw new CustomerNotFound("Invalid emailId");
        }
        Product product = productRepository.findByProductNumber(itemRequestDto.getProductNumber());

        if (product == null){
            throw new ProductDosntExitsException("Invalid product number");
        }

        if (product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficentQuantityException("Sorry! required quantity is not available");
        }

        Item item = ItemTransformer.itemrequestToItem(itemRequestDto.getRequiredQuantity());

        return item;
    }
}
