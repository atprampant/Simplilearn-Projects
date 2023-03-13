package org.simplilearn.sportyshoes.controllers;

import org.simplilearn.sportyshoes.dto.ShoeDto;
import org.simplilearn.sportyshoes.entities.Shoes;
import org.simplilearn.sportyshoes.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sportyshoes/shoes")
public class ShoeController {

    @Autowired
    ShoeService shoeService;

    @PostMapping("")
    public ResponseEntity<Shoes> addAShoe(@RequestBody ShoeDto shoeDto){

        return new ResponseEntity<Shoes>(shoeService.addAShoe(shoeDto), HttpStatus.OK);
    }
}
