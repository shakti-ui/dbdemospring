package com.example.dbdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbdemo.dao.ProductDAOImpl;
import com.example.dbdemo.dto.ProductDTO;

@Service
public class ProductService {

    @Autowired
private ProductDAOImpl productDAOImpl;
    public void addProduct(String productId, String productName) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setProductName(productName);
        productDAOImpl.addProduct(productDTO);
    }
}
