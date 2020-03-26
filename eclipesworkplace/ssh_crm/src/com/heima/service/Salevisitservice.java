package com.heima.service;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.domain.SaleVisit;
import com.heima.utils.PageBean;

public interface Salevisitservice {

	void save(SaleVisit salevisit);

	PageBean getpageBean(DetachedCriteria criteria, Integer currentCount, Integer currentPage);

	SaleVisit getById(String visit_id);

}
