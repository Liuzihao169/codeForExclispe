package com.xiaomi.service;

import com.xiaomi.entity.PageBean;
import com.xiaomi.entity.Product;

public interface AdminService {
	public PageBean getPagebean(int currentpage, int currentcount);

	public void addproduct(Product product);
	public void delProduct(String pid);
	public Product updateProductUI(String pid);
	public void updateProduct(Product product);
}
