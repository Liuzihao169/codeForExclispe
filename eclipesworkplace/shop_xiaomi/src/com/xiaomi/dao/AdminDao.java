package com.xiaomi.dao;

import java.util.List;

import com.xiaomi.entity.Product;

public interface AdminDao {
	public int findcount();
	List<Product>findproduct( int index, int currentcount);
	public void addproduct(Product product);
	public void delProdect(String pid);
	public  Product updateProductUi(String pid);
	public void updateProduct(Product product);
}
