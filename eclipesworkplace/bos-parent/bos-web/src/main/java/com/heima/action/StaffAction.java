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
@Controller("staffAction")//Ĭ��ע���������staffAction
 @Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private StaffService staffService;
	//���ȡ��ԱԱ��
	private String ids;
	public String add(){
		staffService.add(model);
		 return "list"; 
	}
	//��ҳ
	public String pageQuery(){
		staffService.pageQuery(pageBean);//������ôһ��������  pageBean�;�����װά����
		this.java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","decidedzones"});
		return null;
	}
	//ɾ��ȡ��Ա �߼��ϵ�ɾ��
	@RequiresPermissions("staff-delete")
	public String delete(){
		staffService.delete(ids);
		return "list";
	}
	//ȡ��Ա�ı༭����
	public String edit(){
		staffService.edit(model);
		return "list";
	}
	//��ѯȡ��Ա�б�
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
