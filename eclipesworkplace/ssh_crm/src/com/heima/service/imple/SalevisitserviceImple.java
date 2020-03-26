package com.heima.service.imple;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.dao.Salevisitdao;
import com.heima.domain.SaleVisit;
import com.heima.service.Salevisitservice;
import com.heima.utils.PageBean;

public class SalevisitserviceImple implements Salevisitservice {
	private Salevisitdao svd;
	



	@Override
	public void save(SaleVisit salevisit) {
		svd.saveOrUpdate(salevisit);;
		
	}
	

	

	@Override
	public PageBean getpageBean(DetachedCriteria criteria, Integer currentCount, Integer currentPage) {
		Integer totalCount = svd.findcountByname(criteria);
		//初始化参数，规格化参数
		PageBean pb=new PageBean(currentPage, currentCount, totalCount);
		List<SaleVisit> findlist = svd.findlist(criteria, pb.getIndex(), pb.getCurrentCount());
		pb.setList(findlist);
	return pb;
	}


	@Override
	public SaleVisit getById(String visit_id) {
		// TODO Auto-generated method stub
		return svd.getByid(visit_id);
	}
	
	public void setSvd(Salevisitdao svd) {
		this.svd = svd;
	}

}
