package com.mrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.ProductModelDAO;
import com.mrs.entity.Product;

@Service
@Transactional
public class ProductModelServiceImpl implements ProductModelService {

	@Autowired
	private ProductModelDAO modelDAO;
	
	public List getListBrand() {
		return modelDAO.getListBrand();
	}

	public List getListModelName(String brand) {
		return modelDAO.getListModelName(brand);
	}
}
