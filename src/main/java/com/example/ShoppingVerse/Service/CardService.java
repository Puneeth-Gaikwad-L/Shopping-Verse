package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Module.Card;
import com.example.ShoppingVerse.Module.Customer;
import com.example.ShoppingVerse.Repository.CustomerRepository;
import com.example.ShoppingVerse.dto.request.CardRequest;
import com.example.ShoppingVerse.dto.responce.CardResponce;
import com.example.ShoppingVerse.exception.CustomerNotFound;
import com.example.ShoppingVerse.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CustomerRepository customerRepository;
    public CardResponce addCard(CardRequest cardRequest) {
        Customer customer = customerRepository.findByEmailId(cardRequest.getCustomerEmail());
        if (customer == null){
            throw new CustomerNotFound("Invalid emailId");
        }
        Card card = CardTransformer.cardRequestTOCard(cardRequest);
        card.setCustomer(customer);
        customer.getCards().add(card);
        Customer savedCustomer = customerRepository.save(customer);
        List<Card> cardList = savedCustomer.getCards();
        Card savedCard = cardList.get(cardList.size()-1);

        CardResponce cardResponce = CardTransformer.cardToCardResponce(savedCard);
        cardResponce.setCardNo(generateMaskedCardNo(savedCard.getCardNo()));

        return cardResponce;
    }
    public String generateMaskedCardNo(String cardNo){
        return "XXXXXXXXXXXX"+cardNo.substring(cardNo.length()-4);
    }
}
