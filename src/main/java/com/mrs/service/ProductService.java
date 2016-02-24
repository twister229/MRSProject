package com.mrs.service;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Product;

public interface ProductService {
	public List getProductsByUsername(String username);
	public Serializable saveProduct(Product pro);
}
