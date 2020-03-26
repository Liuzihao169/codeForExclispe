package com.heima.service;

import java.sql.SQLException;
import java.util.List;

import com.heima.dao.Productdao;
import com.heima.domain.Category;
import com.heima.domain.Product;
import com.heima.vo.PageBean;

public class ProductService {
   Productdao productdao=new Productdao();
	public List<Product> findAllproduct() {
		// TODO Auto-generated method stub
		return productdao.findAllproduct();
	}
	public List<Category> findAllCateogry() {
		// TODO Auto-generated method stub
		return productdao.findAllCategory();
	}
	public void Addproduct(Product product) {
		// TODO Auto-generated method stub
		productdao.Addproduct(product);
		
	}
	public void Delproduct(String pid) {
		// TODO Auto-generated method stub
		productdao.Delproduct(pid);
		
	}
	public Product UpdateproductUi(String pid) {
		// TODO Auto-generated method stub
		return productdao. UpdateproductUi(pid);
		
	}
	public void Updateproduct(Product product) {
		// TODO Auto-generated method stub
	productdao.Updateproduct(product);
		
		
		
	}
	public List<Product> ProductSeach(Product seachpro) throws SQLException {
		// TODO Auto-generated method stub
		
		return productdao.ProductSeach(seachpro);
	}
	public List<Product> findAllPhone() {
		// TODO Auto-generated method stub
		return productdao.findAllPhone();
	}
	public PageBean findPageBean(int currentpage, int currentcount) throws SQLException {
	
		PageBean pageBean=new PageBean();
		// TODO Auto-generated method stub
		//1.��װ��ǰҳ
	  pageBean.setCurrentpage(currentpage);
		//��װ��ǰҳ����ʾ����
		pageBean.setCurrentcount(currentcount);
		//��װ�ܵ�����
	    int totalcount =productdao.FindAllPageTotal();
	    pageBean.setTotalcount(totalcount);
		//�ܵ�ҳ��
		int pagetotal=(int) Math.ceil(1.0*totalcount/currentcount);
		pageBean.setTotalpage(pagetotal);
		//ÿҳ��ʾ������
		int inde=(currentpage-1)*currentcount;
		List<Product>list=productdao.FindAllPageBeanList(inde,currentcount);
	     pageBean.setProductList(list);
		return pageBean;
	}
	

}
