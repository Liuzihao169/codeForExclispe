package com.heima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Function;
import com.heima.dao.FunctionDao;
import com.heima.service.FunctionService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionDao functionDao;
	@Override
	public List<Function> findAll() {
		// TODO Auto-generated method stub
		return functionDao.findAll();
	}
	@Override
	public void save(Function function) {
		functionDao.save(function);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		functionDao.pageQuery(pageBean);
	}
	@Override
	public List<Function> findAllMenu() {
		// TODO Auto-generated method stub
		return functionDao.findAllMenu();
	}
	public List<Function> findMenuByUserId(String Id) {
		return functionDao.findMenuByUserId(Id);
	}
}
