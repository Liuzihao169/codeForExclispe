package com.heima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Region;
import com.heima.dao.RegionDao;
import com.heima.service.RegionService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionDao regionDao;
	public void save(List<Region> list) {
		for (Region region : list) {
			regionDao.saveOrUpdate(region);
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}
	@Override
	public List<Region> findAll() {
		return regionDao.findAll();
	}
	@Override
	public List<Region> findByQuery(String q) {
		// TODO Auto-generated method stub
		return regionDao.findbyQuery(q);
	}
}
