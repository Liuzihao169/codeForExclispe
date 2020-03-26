package com.heima.dao;

import java.util.List;

import com.heima.bos.entity.Subarea;
import com.heima.utils.HighchartsByPrivence;

public interface SubareaDao extends BaseDao<Subarea> {

	List<Object> findSubareaByProvince();

}
