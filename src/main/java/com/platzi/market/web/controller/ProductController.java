package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("all")

    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>getProduct (@PathVariable("id") int productId){
        return productoService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory (@PathVariable("categoryId") int categoryId){
        return productoService.getByCategory(categoryId)
                .map(product ->  new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product>  save (@RequestBody Product product){
        return new ResponseEntity<>(productoService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity   delete (@PathVariable("id")  int productId){
        if (productoService.delete(productId)){
          return  new ResponseEntity<>(HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
