package com.heima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.bos.entity.Function;
import com.heima.utils.PageBean;

public interface FunctionService {

	List<Function> findAll();
	void save(Function function);
	void pageQuery(PageBean pageBean);
	List<Function> findAllMenu();
	public List<Function> findMenuByUserId(String Id);
}
