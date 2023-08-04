package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Module.Seller;
import com.example.ShoppingVerse.Repository.SellerRepository;
import com.example.ShoppingVerse.dto.request.SellerRequest;
import com.example.ShoppingVerse.dto.responce.SellerResponce;
import com.example.ShoppingVerse.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public SellerResponce addSeller(SellerRequest sellerRequest) {
        Seller seller = SellerTransformer.SellerRequestToSeller(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        return SellerTransformer.SellerToSelleResponce(savedSeller);
    }
}
