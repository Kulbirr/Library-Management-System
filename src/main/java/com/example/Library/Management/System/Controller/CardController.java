package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card/")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("generateCard")
    public ResponseEntity generatePlainCard(){
        String response = "Plain card has been generated with cardNo "+  cardService.generatePlainCard().getCardNo();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("linkcardwithstudent")
    public ResponseEntity associateWithStudent(@RequestParam("cardNo") Integer cardNo, @RequestParam("studentId") Integer studentId){
        String response = cardService.associateWithStudent(cardNo, studentId);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
