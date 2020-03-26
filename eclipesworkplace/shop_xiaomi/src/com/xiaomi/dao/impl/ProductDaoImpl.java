package com.xiaomi.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xiaomi.dao.ProductDao;
import com.xiaomi.entity.Product;
import com.xiaomi.utils.DataSourceUtils;

public class ProductDaoImpl implements ProductDao {
	//找到总的条数
	public int findProductCount() {
		
		// TODO Auto-generated method stub
				QueryRunner qy= new QueryRunner(DataSourceUtils.getDataSource());
				String sql="select count(*) from product ";
				Long lo=null;
				try {
					 lo=(Long) qy.query(sql, new ScalarHandler());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lo.intValue();
	}
	//找到指定的List集合
	public List<Product> findProductList(int index, int currentcount) {
		QueryRunner qy= new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product limit ?,?";
		List<Product>list=null;
		  try {
			list = qy.query(sql, new BeanListHandler<Product>(Product.class),index,currentcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Product findProductInfo(String pid) {
		// TODO Auto-generated method stub
				QueryRunner qy= new QueryRunner(DataSourceUtils.getDataSource());
				String sql="select * from product where pid=?";
				Product product=null;
				try {
					 product=qy.query(sql, new BeanHandler<Product>(Product.class), pid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return product;
	}
}
