package com.xiaomi.service;

import com.xiaomi.entity.PageBean;
import com.xiaomi.entity.Product;

public interface ProductService {
	PageBean getPageBean( int currentpage, int currentcount);
	Product findProductInfo(String pid);
}
