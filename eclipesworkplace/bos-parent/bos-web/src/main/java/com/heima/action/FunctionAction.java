package com.heima.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Function;
import com.heima.bos.entity.User;
import com.heima.service.FunctionService;
@Controller("functionAction")
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {
	//查询父类权限名称
	@Autowired
	private FunctionService functionService;
	public String listajax(){
		//回显出conbotree的数据格式 ，需要利用懒加载
		List<Function>list=functionService.findAll();
		java2Json(list, new String []{"parentFunction","code","description","page","generatemenu","zindex","roles"});
		return null;
	}
	//添加权限
	public String add(){
		Function parentFunction = model.getParentFunction();
		if(parentFunction!=null&&parentFunction.getId().equals("")){
			model.setParentFunction(null);
		}
		functionService.save(model);
		return "list";
	}
	public  String pageQuery(){
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		functionService.pageQuery(pageBean);
		java2Json(pageBean, new String []{"currentPage","pageSize","detachedCriteria","roles","children","parentFunction"});
		return null;
	}
	public String findMenu(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<Function>list=null;
		if(user.getUsername().equals("刘钊")){
			//就显示所有的菜单
			list=functionService.findAllMenu();
		}else{
			list = functionService.findMenuByUserId(user.getId());
		}
		java2Json(list, new String []{"roles","children","parentFunction"});
		return null;
	}
 }
