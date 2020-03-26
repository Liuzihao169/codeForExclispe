package com.heima.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.heima.bos.entity.Staff;
import com.heima.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

    /*
     * 这是一个basicacation 提取了 pagequery  和 extends ActionSupport  和 implements ModelDriver*/
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected T model;
	protected PageBean pageBean = new PageBean();
	private DetachedCriteria detachedCriteria = null;

	//
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 子类运行调 时候 实例化时 会调用父类的构造方法    目的获得父类《T》的类型
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class modelclass = (Class) actualTypeArguments[0];
		detachedCriteria=DetachedCriteria.forClass(modelclass);
		pageBean.setDetachedCriteria(detachedCriteria);
		try {
			model = (T) modelclass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public void java2Json(Object object,String[]exclude){
		 JsonConfig config = new JsonConfig();
		 config.setExcludes(exclude);
		String json = JSONObject.fromObject(object,config).toString();//将对象转换成son格式
		
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void java2Json(List list,String[]exclude){
		 JsonConfig config = new JsonConfig();
		 config.setExcludes(exclude);
		String json = JSONArray.fromObject(list,config).toString();//将对象转换成son格式
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public void setPage(Integer page) {
		pageBean.setCurrentPage(page);
	}

	public void setRows(Integer rows) {
		pageBean.setPageSize(rows);

	}
}
