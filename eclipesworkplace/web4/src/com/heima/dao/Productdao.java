package com.heima.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.heima.domain.Category;
import com.heima.domain.Product;
import com.heima.vo.PageBean;

import utils.DataSourceUtils;

public class Productdao {
            //显示所有的商品
	public List<Product> findAllproduct() {
		// TODO Auto-generated method stub
	    try {
	    	QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
	    	String sql="select * from product";
			List<Product>productlist=qy.query(sql, new BeanListHandler<Product>(Product.class));
			return productlist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
            //商品种类的显示
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		try {
			QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from category";
			List<Category> addproductui;
			addproductui = qy.query(sql, new BeanListHandler<Category>(Category.class));
			return addproductui;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		
		}
		
	}
                   //添加商品
	public void Addproduct(Product product) {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		try {
			String sql="insert into product values(?,?,?,?,?,?,?,?,?,?)";
			qy.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Delproduct(String pid) {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		try {
			qy.update("delete from product where pid=?", pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Product UpdateproductUi(String pid) {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid=?";
		Product product;
		try {
			product = qy.query(sql, new BeanHandler<Product>(Product.class), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return product;
	}
	public void Updateproduct(Product product) {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set  pname=?, market_price=?,  shop_price=?,pimage=?, pdate=?, is_hot=?, pdesc=?,  pflag=?, cid=? where pid=?";
		try {
			qy.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Product> ProductSeach(Product seachpro) throws SQLException {
		// TODO Auto-generated method stub
		List<Object>list=new ArrayList<Object>();
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where 1=1 ";
		if(seachpro.getPname()!=null&&!"".equals(seachpro.getPname().trim())){
			sql=sql+" and pname like ? ";
			list.add("%"+seachpro.getPname()+"%");
		}
		if(seachpro.getCid()!=null&&!"".equals(seachpro.getCid())){
			sql=sql+" and cid=? ";
			list.add(seachpro.getCid());
		}
		if( seachpro.getIs_hot()!=3){
			sql=sql+" and cid=? ";
			list.add(seachpro.getIs_hot());

		}
		List<Product>productlist=qy.query(sql, new BeanListHandler<Product>(Product.class),list.toArray());
		return productlist;
	}
	public List<Product> findAllPhone() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
	    try {
	    	QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
	    	String sql="select * from product";
			List<Product>productlist=qy.query(sql, new BeanListHandler<Product>(Product.class));
			return productlist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public int FindAllPageTotal() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
    	String sql="select count(*) from product";
    	Long totalcount=(Long)qy.query(sql,new ScalarHandler<>());
    
		return totalcount.intValue();
	}
	public List<Product> FindAllPageBeanList(int inde, int currentcount) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
    	String sql="select * from product limit ?,?";
    	List<Product>Beanpagelist=qy.query(sql, new BeanListHandler<Product>(Product.class),inde,currentcount);
		return Beanpagelist;
	}

}
