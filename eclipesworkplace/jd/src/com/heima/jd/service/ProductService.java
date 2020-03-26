package com.heima.jd.service;

import java.util.List;

import com.heima.jd.pojo.ProductModel;

public interface ProductService {

	List<ProductModel> findProductListByQuery(String queryString, String catalog_name, String price, String sort);

}
