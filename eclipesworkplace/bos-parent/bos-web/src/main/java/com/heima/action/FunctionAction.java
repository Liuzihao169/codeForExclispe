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
	//��ѯ����Ȩ������
	@Autowired
	private FunctionService functionService;
	public String listajax(){
		//���Գ�conbotree�����ݸ�ʽ ����Ҫ����������
		List<Function>list=functionService.findAll();
		java2Json(list, new String []{"parentFunction","code","description","page","generatemenu","zindex","roles"});
		return null;
	}
	//���Ȩ��
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
		if(user.getUsername().equals("����")){
			//����ʾ���еĲ˵�
			list=functionService.findAllMenu();
		}else{
			list = functionService.findMenuByUserId(user.getId());
		}
		java2Json(list, new String []{"roles","children","parentFunction"});
		return null;
	}
 }
