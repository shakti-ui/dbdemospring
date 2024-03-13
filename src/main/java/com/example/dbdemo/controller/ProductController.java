package com.example.dbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbdemo.model.AddProductRequest;
import com.example.dbdemo.service.ProductService;

@RestController
public class ProductController {
	 @Value("${successfull.message}")
	    private String successfulMessage;
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/action/add")
    public ResponseEntity<?> addProduct(@RequestParam String productId, @RequestParam String productName) {
        productService.addProduct(productId, productName);
        return new ResponseEntity<>(successfulMessage, HttpStatus.OK);
    }
    @PostMapping(value = "/product/action/add1")
    public ResponseEntity<?>addProduct(@RequestBody AddProductRequest addProductRequest){
    	productService.addProduct(addProductRequest);
    	return new ResponseEntity<>(successfulMessage,HttpStatus.OK);
    }
    
    @GetMapping(value="/product/action/list-all")
    public ResponseEntity<?>listAllProducts(){
    	return new ResponseEntity<>(productService.listAllProducts(),HttpStatus.OK);
    }
   
}
