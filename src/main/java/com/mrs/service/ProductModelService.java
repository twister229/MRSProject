package com.mrs.service;

import java.util.List;

import com.mrs.entity.Product;

public interface ProductModelService {

	public List getListBrand();
	public List getListModelName(String brand);
	
}
