package day17.daemo.service;

import java.util.List;

import day17.daemo.dao.ProductDao;
import day17.demo.domin.Product;

public class ProductService {
      ProductDao productdao=new ProductDao();
	public  List<Product> findProduct() {
		// TODO Auto-generated method stub
		return productdao.findProduct();
	}
  
}
