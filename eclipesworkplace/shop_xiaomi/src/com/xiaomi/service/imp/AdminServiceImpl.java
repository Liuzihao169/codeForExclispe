package com.xiaomi.service.imp;

import java.util.List;

import com.xiaomi.dao.AdminDao;
import com.xiaomi.dao.impl.AdminDaoImpl;
import com.xiaomi.entity.PageBean;
import com.xiaomi.entity.Product;
import com.xiaomi.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao = new AdminDaoImpl();
	public PageBean getPagebean(int currentpage, int currentcount) {
		// TODO Auto-generated method stub
		//封装当前页
		PageBean pagebean=new PageBean();
		pagebean.setCurrentpage(currentpage);
		//封装当前页面条数
		pagebean.setCurentcount(currentcount);
		
		//总条数
		int totalcount=adminDao.findcount();
		pagebean.setTotalcount(totalcount);
		//总的页数
		/*	int pagetotal=(int) Math.ceil(1.0*totalcount/currentcount);*/
		int totalpage=(int) Math.ceil(1.0*totalcount/currentcount);
		pagebean.setTotalpage(totalpage);
		//当前页的productlist
		int index=(currentpage-1)*7;
		List<Product>productlistbycid=adminDao.findproduct(index, currentcount);
		//封装当前分类的当前页数的productlist
		pagebean.setProductlistbycid(productlistbycid);
		
		return pagebean;
	}
	@Override
	public void addproduct(Product product) {
		adminDao.addproduct( product);
		
	}
	@Override
	public void delProduct(String pid) {
		adminDao.delProdect(pid);
	}
	@Override
	public Product updateProductUI(String pid) {
		// TODO Auto-generated method stub
		return adminDao.updateProductUi(pid);
	}
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		adminDao.updateProduct(product);
	}
}
