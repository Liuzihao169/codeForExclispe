package com.xiaomi.dao;

import java.util.List;

import com.xiaomi.entity.Product;

public interface ProductDao {
	int  findProductCount();

	List<Product> findProductList(int index, int currentcount);

	Product findProductInfo(String pid);

}
