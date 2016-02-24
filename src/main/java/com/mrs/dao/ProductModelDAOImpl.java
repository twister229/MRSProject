package com.mrs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Product;
import com.mrs.entity.ProductModel;

@Repository
public class ProductModelDAOImpl implements ProductModelDAO {

	@Autowired
	private HibernateRepository repository;

	public List getListBrand() {
		String query = "GROUP BY brandName";
		List<ProductModel> listModel = repository.fetchAllByQuery(query, ProductModel.class);
		List result;
		if (listModel != null) {
			System.out.println("Num of brand: " + listModel.size());
			result = new ArrayList<String>();
			for (ProductModel model : listModel) {
				result.add(model.getBrandName());
			}
			return result;
		}
		return null;
	}

	public List getListModelName(String brand) {
		String query = String.format("WHERE brandName = '%s'", brand);
		List<ProductModel> listModel = repository.fetchAllByQuery(query, ProductModel.class);
		return listModel;
	}
}
