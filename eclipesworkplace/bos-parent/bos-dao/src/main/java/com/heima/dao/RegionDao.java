package com.heima.dao;

import java.util.List;

import com.heima.bos.entity.Region;

public interface RegionDao extends BaseDao<Region>{

	List<Region> findbyQuery(String q);
}
