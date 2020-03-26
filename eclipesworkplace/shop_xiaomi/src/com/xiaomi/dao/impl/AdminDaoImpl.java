package com.xiaomi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xiaomi.dao.AdminDao;
import com.xiaomi.entity.Product;
import com.xiaomi.utils.DataSourceUtils;

public class AdminDaoImpl implements AdminDao {

	public int findcount() {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from product";
		Long lo=null;
		try {
			lo=(Long) qy.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lo.intValue();
	}
	
	public List<Product> findproduct(int start, int currentcount) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select *from product limit ?,?";
		List<Product>list=null;
	     try {
			list=qy.query(sql, new BeanListHandler<Product>(Product.class),start ,currentcount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addproduct(Product product) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into product values(?,?,?,?,?,?)";
		try {
			qy.update(sql,product.getPid(),product.getPname(),product.getPversion(),
					product.getPrice(),product.getPimage(),product.getPdesc() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新操作
	@Override
	public void delProdect(String pid) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from product where pid=?";
		try {
			qy.update(sql, pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//返回修改时候的ProductUi
	@Override
	public Product updateProductUi(String pid) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid=? ";
		Product product;
		try {
			product = qy.query(sql, new BeanHandler<Product>(Product.class), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set pname=?,pversion=?,price=?,pimage=?,pdesc=? where pid=?";
		try {
			qy.update(sql, product.getPname(),
					product.getPversion(),product.getPrice(),
					product.getPimage(),product.getPdesc(),product.getPid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
