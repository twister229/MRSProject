package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {	
	
	@Autowired
	private HibernateRepository repository;

	public List getProductsByUsername(String username) {
		String query = String.format("WHERE customerUsername = '%s'", username);
		return repository.fetchAllByQuery(query, Product.class);
	}
	
	public Serializable saveProduct(Product pro) {
		Serializable result = repository.create(pro);
		System.out.println("RESULT" + result);
		return result;
	}

}
