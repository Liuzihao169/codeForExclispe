package com.heima.service.imple;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.dao.Customerdao;
import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.utils.PageBean;

public class CustomerserviceImple implements Customerservice {
	private Customerdao customerdao;

	@Override
	public PageBean getpageBean(DetachedCriteria criteria, Integer currentCount, Integer currentPage) {
		//根据条件 查询总的条数
		Integer totalCount=customerdao.findcountByname(criteria);
		//封装总条数
		//封装每页显示的条数
		//封装当前页数
		/*
		 * 先封装pageBean
		 * 完成参数初始化*/
		//因为构造函数的原因 要求其一定要封装这三个参数，来进一步完成参数的初始化
		PageBean pg=new PageBean(currentPage, currentCount,totalCount);
		//总的页数
		//Integer totalPage=(int) Math.ceil(1.0*(totalCount/currentCount));
		//pg.setTotalPage(totalPage);
		
		//封装list集合
		List<Customer>list=customerdao.findlist(criteria,pg.getIndex(),pg.getCurrentCount());
		pg.setList(list);
		return pg;
	}

	
	public void setCustomerdao(Customerdao customerdao) {
		this.customerdao = customerdao;
	}


	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerdao.saveOrUpdate(customer);
		
	}


	@Override
	public Customer getById(Long cust_id) {
		// TODO Auto-generated method stub
		return customerdao.getByid(cust_id);
	}


	@Override
	public List<Object[]> findindustyCount() {
		// TODO Auto-generated method stub
		return customerdao.findindustyCount();
	}


	

	


	

}
