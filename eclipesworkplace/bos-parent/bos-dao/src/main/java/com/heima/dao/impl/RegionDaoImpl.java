package com.heima.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heima.bos.entity.Region;
import com.heima.dao.RegionDao;
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {
	@Override
	public List<Region> findbyQuery(String q) {
		String hql="from Region r where r.province like ? or r.city like ? or r.district like ? or r.shortcode like ? or r.citycode like ?";
		List<Region> findRegion = (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return findRegion ;
	}
}
