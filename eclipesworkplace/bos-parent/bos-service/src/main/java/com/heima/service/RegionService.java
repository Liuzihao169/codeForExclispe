package com.heima.service;

import java.util.List;

import com.heima.bos.entity.Region;
import com.heima.utils.PageBean;

public interface RegionService {

	void save(List<Region> list);

	void pageQuery(PageBean pageBean);

	List<Region> findAll();

	List<Region> findByQuery(String q);

}
