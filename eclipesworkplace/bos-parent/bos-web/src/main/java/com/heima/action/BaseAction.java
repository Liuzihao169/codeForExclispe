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
     * ����һ��basicacation ��ȡ�� pagequery  �� extends ActionSupport  �� implements ModelDriver*/
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected T model;
	protected PageBean pageBean = new PageBean();
	private DetachedCriteria detachedCriteria = null;

	//
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// �������е� ʱ�� ʵ����ʱ ����ø���Ĺ��췽��    Ŀ�Ļ�ø��ࡶT��������
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
		String json = JSONObject.fromObject(object,config).toString();//������ת����son��ʽ
		
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
		String json = JSONArray.fromObject(list,config).toString();//������ת����son��ʽ
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
