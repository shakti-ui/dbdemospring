package com.example.dbdemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbdemo.dao.ProductDAOImpl;
import com.example.dbdemo.dto.ProductDTO;
import com.example.dbdemo.model.AddProductRequest;
import com.example.dbdemo.model.Product;

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
    public void addProduct(AddProductRequest addProductRequest) {
    	ProductDTO productDTO=new ProductDTO();
    	productDTO.setProductId(addProductRequest.getProductId());
    	productDTO.setProductName(addProductRequest.getProductName());
    	productDAOImpl.addProduct(productDTO);
    }
    public List<Product>listAllProducts(){
    	List<ProductDTO>productDTOs=productDAOImpl.listAllProducts();
    	List<Product>products=new ArrayList<>();
    	for(ProductDTO productDTO:productDTOs) {
    		Product product=new Product();
    		product.setProductId(productDTO.getProductId());
    		product.setProductName(productDTO.getProductName());
    		products.add(product);
    	}
    	return products;
    }
   
}
