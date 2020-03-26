package com.heima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.bos.entity.Function;

public interface FunctionDao extends BaseDao<Function> {

	List<Function> findFunctionByUserId(String id);

	List<Function> findAllMenu();
	public List<Function> findMenuByUserId(String Id);
}
