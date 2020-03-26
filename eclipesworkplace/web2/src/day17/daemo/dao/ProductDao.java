package day17.daemo.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import day17.demo.domin.Product;
import utils.C3p0Utils;

public class ProductDao {

	public List<Product> findProduct() {
		// TODO Auto-generated method stub
		 String sql="select *from product";
		QueryRunner qy=new QueryRunner(C3p0Utils.getDataSource());
		try {
			List<Product>ProductList=qy.query(sql, new BeanListHandler<Product>(Product.class));
			return ProductList;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
	        throw new RuntimeException(ex);
		}
	
	}

}
