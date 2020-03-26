package com.heima.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Role;
import com.heima.service.RoleService;
@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	@Autowired
	private RoleService roleService;
	private String functionIds;
	public String add(){
		roleService.save(model,functionIds);
		return "list";
	}
	//分页查询
	public String pageQuery(){
		roleService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","users","functions"});
		return null;
	}
	//查询所有角色
	public String listajax(){
		List<Role>list=roleService.findAll();
		java2Json(list, new String []{"functions","users"});
		return null;
	}
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
}
