package com.heima.service;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.domain.LinkMan;
import com.heima.utils.PageBean;

public interface Linkmanservice {

	void saveOrUpdate(LinkMan lm);

	PageBean getpagebean(DetachedCriteria criteria, Integer currentCount, Integer currentPage);

	LinkMan getById(Long lkm_id);

	
}
