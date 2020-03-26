package com.heima.action;
import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Staff;
import com.heima.service.StaffService;
import com.heima.utils.PageBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller("staffAction")//默认注入的名字是staffAction
 @Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private StaffService staffService;
	//添加取派员员工
	private String ids;
	public String add(){
		staffService.add(model);
		 return "list"; 
	}
	//分页
	public String pageQuery(){
		staffService.pageQuery(pageBean);//经过这么一个方法后  pageBean就经过封装维护了
		this.java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","decidedzones"});
		return null;
	}
	//删除取派员 逻辑上的删除
	@RequiresPermissions("staff-delete")
	public String delete(){
		staffService.delete(ids);
		return "list";
	}
	//取派员的编辑更新
	public String edit(){
		staffService.edit(model);
		return "list";
	}
	//查询取派员列表
	public String listAjax(){
		DetachedCriteria criteria=DetachedCriteria.forClass(Staff.class);
		criteria.add(Restrictions.eq("deltag", "0"));
		List<Staff>list = staffService.findListIsNotDelete(criteria);
		java2Json(list, new String[]{"decidedzones"});
		return null;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
}
