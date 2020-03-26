package com.heima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.bos.entity.Subarea;
import com.heima.utils.HighchartsByPrivence;
import com.heima.utils.PageBean;

public interface SubareaService {

	void save(Subarea model);

	void pageQuery(PageBean pageBean);

	List<Subarea> findByIds(String ids);

	List<Subarea> findHasNoDecidezone(DetachedCriteria criteria);

	List<Subarea> findListByDecidedzoneId(DetachedCriteria criteria);

	List<Object> findSubareaByProvince();



}
