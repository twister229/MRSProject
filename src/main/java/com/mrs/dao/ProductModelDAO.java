package com.mrs.dao;

import java.util.List;

import com.mrs.entity.Product;

public interface ProductModelDAO {
	public List getListBrand();
	public List getListModelName(String brand);
}
