package com.heima.service;

import java.util.List;

import com.heima.bos.entity.Role;
import com.heima.utils.PageBean;

public interface RoleService {

	void save(Role model, String functionIds);
	void pageQuery(PageBean pageBean);
	List<Role> findAll();
}
