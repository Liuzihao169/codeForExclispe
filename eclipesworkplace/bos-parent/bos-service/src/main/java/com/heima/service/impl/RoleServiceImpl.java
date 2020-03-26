package com.heima.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Function;
import com.heima.bos.entity.Role;
import com.heima.dao.FunctionDao;
import com.heima.dao.RoleDao;
import com.heima.service.RoleService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private FunctionDao functionDao;
	@Override
	public void save(Role model, String functionIds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(functionIds)){
			String[] split = functionIds.split(",");
			for (String id : split) {
				//set集合不允许存储相同的元素
				//还可以直接 给一个游离的状态的function 这样可以少查询一次数据库
				Function function = functionDao.findById(id);
				model.getFunctions().add(function);
			}
			roleDao.save(model);
		}
	}
	/*
	 * 
	 * 第二种方法 是可以  先持久化model这个对象，然后利用持久化对象的改变会动态影响数据库的改变的特性 然后维护关系
	 */
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}
	public List<Role> findAll() {
		List<Role> list = roleDao.findAll();
		return list;
	}
}
