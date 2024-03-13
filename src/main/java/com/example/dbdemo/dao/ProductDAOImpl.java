package com.example.dbdemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dbdemo.dto.ProductDTO;
@Repository
public class ProductDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	public void addProduct(ProductDTO productDTO) {
        sessionFactory.getCurrentSession().saveOrUpdate(productDTO);
    }
	public List<ProductDTO>listAllProducts(){
		return sessionFactory.getCurrentSession().createQuery("FROM ProductDTO").getResultList();
	}
	

}
