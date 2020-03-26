package com.xiaomi.service.imp;

import java.util.List;

import com.xiaomi.dao.ProductDao;
import com.xiaomi.dao.impl.ProductDaoImpl;
import com.xiaomi.entity.PageBean;
import com.xiaomi.entity.Product;
import com.xiaomi.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao = new ProductDaoImpl ();
	@Override
	public PageBean getPageBean(int currentpage, int currentcount) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		//获得条数
		int totalCount = productDao.findProductCount();
		pageBean.setTotalcount(totalCount);
		//获得总页数
		int totalPage=(totalCount+currentcount-1)/currentcount;
		pageBean.setTotalpage(totalPage);
		//封装currentCount
		pageBean.setCurentcount(currentcount);
		//封装当前页
		pageBean.setCurrentpage(currentpage);
		//获得开始index
		int index=(currentpage-1)*currentcount;
		List<Product>list=productDao.findProductList(index,currentcount);
		//封装list
		pageBean.setProductlistbycid(list);
		return pageBean ;
	}
	@Override
	public Product findProductInfo(String pid) {
		// TODO Auto-generated method stub
		return productDao.findProductInfo(pid);
	}

}
