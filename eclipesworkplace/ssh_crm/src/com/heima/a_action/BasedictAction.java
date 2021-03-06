package com.heima.a_action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.heima.domain.BaseDict;
import com.heima.service.Basedictservice;
import com.opensymphony.xwork2.ActionSupport;

public class BasedictAction extends ActionSupport{
	//利用属性驱动
	private String dict_type_code;
	//利用set方法注入
	private Basedictservice basedictservice;

	@Override
	public String execute() throws Exception {
		
		//从后台获得 typecode
		
		//通过typecode查询BaseDict list
		List<BaseDict>list=basedictservice.getListByTypeCode(dict_type_code);
		//将对象转换成json数据格式
		Gson gson=new Gson();
		String json = gson.toJson(list);
		//写入页面 
		//可能出现中文数据
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		//告诉action不用处理结果
		return null;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBasedictservice(Basedictservice basedictservice) {
		this.basedictservice = basedictservice;
	}
	
}
