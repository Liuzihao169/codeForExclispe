package com.heima.jd.dao;

import java.util.List;

import com.heima.jd.pojo.ProductModel;

public interface ProductDao {

	List<ProductModel> findProductListByQuery(String queryString, String catalog_name, String price, String sort);

}
