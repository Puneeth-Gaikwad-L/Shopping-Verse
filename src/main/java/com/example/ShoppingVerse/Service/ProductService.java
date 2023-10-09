package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Enum.ProductCategory;
import com.example.ShoppingVerse.Module.Product;
import com.example.ShoppingVerse.Module.Seller;
import com.example.ShoppingVerse.Repository.ProductRepository;
import com.example.ShoppingVerse.Repository.SellerRepository;
import com.example.ShoppingVerse.dto.request.ProductRequest;
import com.example.ShoppingVerse.dto.responce.ProductResponce;
import com.example.ShoppingVerse.exception.SellerNotFound;
import com.example.ShoppingVerse.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;
    public ProductResponce addProduct(ProductRequest productRequest) {
        Seller seller = sellerRepository.findBySellerEmailId(productRequest.getSellerEmailId());
        if (seller==null){
            throw new SellerNotFound("Sorry!! Seller doesn't exits");
        }
        Product product = ProductTransformer.ProductRequestToProduct(productRequest);
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller);

        List<Product> productList = savedSeller.getProducts();

        Product savedProduct = productList.get(productList.size()-1);

        return ProductTransformer.ProductToProductResponce(savedProduct);
    }


}
