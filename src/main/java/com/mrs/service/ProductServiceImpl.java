package com.mrs.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.ProductDAO;
import com.mrs.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	public List getProductsByUsername(String username) {
		return productDAO.getProductsByUsername(username);
	}
	
	public Serializable saveProduct(Product pro) {
		return productDAO.saveProduct(pro);
	}

	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

}
