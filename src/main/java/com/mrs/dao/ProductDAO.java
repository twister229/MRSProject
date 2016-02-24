package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Product;

public interface ProductDAO {
	public List getProductsByUsername(String username);
	public Serializable saveProduct(Product pro);
}
