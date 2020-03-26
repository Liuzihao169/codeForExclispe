package com.heima.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Subarea;
import com.heima.dao.SubareaDao;
import com.heima.service.SubareaService;
import com.heima.utils.HighchartsByPrivence;
import com.heima.utils.PageBean;
@Service
@Transactional
public class SubareaServiceImpl implements SubareaService {
	@Autowired
	private SubareaDao subareaDao;

	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findByIds(String ids) {
		List<Subarea>list=new ArrayList<Subarea>();
		String[] split = ids.split(",");
		for (String id : split) {
			Subarea findById = subareaDao.findById(id);
			list.add(findById);
		}
		return list;
	}

	@Override
	public List<Subarea> findHasNoDecidezone(DetachedCriteria criteria) {
		return subareaDao.findByCreaitar(criteria);
	}

	@Override
	public List<Subarea> findListByDecidedzoneId(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return subareaDao.findByCreaitar(criteria);
	}

	public List<Object> findSubareaByProvince() {
		return subareaDao.findSubareaByProvince();
	}
}
