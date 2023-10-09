package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Enum.ProductCategory;
import com.example.ShoppingVerse.Module.Product;
import com.example.ShoppingVerse.Repository.ProductRepository;
import com.example.ShoppingVerse.dto.responce.ProductResponce;
import com.example.ShoppingVerse.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService {

    @Autowired
    ProductRepository productRepository;
    public List<ProductResponce> getProdByPriceandCategory(ProductCategory category, int price) {
        List<Product> products = productRepository.getProdByPriceandCategory(price, category);
        List<ProductResponce> productResponceList = new ArrayList<>();
        for (Product p : products){
            productResponceList.add(ProductTransformer.ProductToProductResponce(p));
        }
        return productResponceList;
    }
}
