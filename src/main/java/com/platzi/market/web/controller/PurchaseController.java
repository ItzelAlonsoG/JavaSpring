package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
     private CompraService compraService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll (){
        return  new ResponseEntity<>(compraService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getByClient (@PathVariable("id") String clientId){
        return  compraService.getByClient(clientId)
                .map(purchase -> new ResponseEntity<>(purchase,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save (@RequestBody Purchase purchase){
        return new ResponseEntity<>(compraService.save(purchase), HttpStatus.CREATED);
    }
}
