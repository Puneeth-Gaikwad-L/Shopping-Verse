package com.example.ShoppingVerse.Controller;

import com.example.ShoppingVerse.Service.CardService;
import com.example.ShoppingVerse.dto.request.CardRequest;
import com.example.ShoppingVerse.dto.responce.CardResponce;
import com.example.ShoppingVerse.exception.CustomerNotFound;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequest cardRequest){
        try {
            CardResponce cardResponce = cardService.addCard(cardRequest);
            return new ResponseEntity<>(cardResponce, HttpStatus.ACCEPTED);
        }catch (CustomerNotFound c){
            return new ResponseEntity<>(c.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
