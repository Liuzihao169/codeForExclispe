package com.heima.jd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heima.jd.dao.ProductDao;
import com.heima.jd.pojo.ProductModel;
import com.heima.jd.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductModel> findProductListByQuery(String queryString, String catalog_name, String price,
			String sort) {
		// TODO Auto-generated method stub
		return productDao.findProductListByQuery( queryString,  catalog_name,  price,
				 sort);
	}

}
