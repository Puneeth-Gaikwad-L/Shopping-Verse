package com.example.ShoppingVerse.transformer;

import com.example.ShoppingVerse.Module.Card;
import com.example.ShoppingVerse.Module.Customer;
import com.example.ShoppingVerse.dto.request.CardRequest;
import com.example.ShoppingVerse.dto.responce.CardResponce;

import java.net.CacheResponse;

public class CardTransformer {

    public static Card cardRequestTOCard(CardRequest cardRequest){
        return Card.builder()
                .cardNo(cardRequest.getCardNo())
                .cardType(cardRequest.getCardType())
                .validTill(cardRequest.getValidTill())
                .cvv(cardRequest.getCvv())
                .build();
    }

    public static CardResponce cardToCardResponce(Card card){
        return CardResponce.builder()
                .cardNo(card.getCardNo())
                .cardType(card.getCardType())
                .validTill(card.getValidTill())
                .customerName(card.getCustomer().getName())
                .build();
    }
}
