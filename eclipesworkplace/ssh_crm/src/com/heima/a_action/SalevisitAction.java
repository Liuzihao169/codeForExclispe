package com.heima.a_action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.heima.domain.Customer;
import com.heima.domain.SaleVisit;
import com.heima.domain.User;
import com.heima.service.Salevisitservice;
import com.heima.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalevisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private Integer currentCount;
	private Integer currentPage;
	private Salevisitservice svs;
	private SaleVisit salevisit = new SaleVisit();
	
	public String add(){
		//调用保存的方法。然后转发到 listaction
		/*User  u = (User) ActionContext.getContext().getSession().get("user");
		salevisit.setUser(u);*/
		User u = (User) ActionContext.getContext().getSession().get("user");
		salevisit.setUser(u);
		svs.save(salevisit);
		return "tolist";
	}
	public String list(){
		//从页面获得 customer_id  currentpage currentcount;
		//传入方法 获得pagebean;
		DetachedCriteria criteria=DetachedCriteria.forClass(SaleVisit.class);
		//判断如果不为空 那么加入判断条件
		if(salevisit.getCustomer()!=null&&salevisit.getCustomer().getCust_id()!=null){
			criteria.add(Restrictions.eq("customer.cust_id",salevisit.getCustomer().getCust_id() ));
		}
		PageBean pb=svs.getpageBean( criteria, currentCount,  currentPage);
		//将pagebean放入jsp页面进行解析
		System.out.println(pb);
		ActionContext.getContext().put("pagebean", pb);
		return "list";
	}
	public String edit(){
		//点击修改，传送id值，根据id查询salevist
		SaleVisit saleVisit=svs.getById(salevisit.getVisit_id()); 
		System.out.println(saleVisit);
		//将查询到的vist对象放在request当中 转发到编辑页面回显
		ActionContext.getContext().put("saleVisit", saleVisit);
		return "toedit";
	}
	@Override
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return salevisit;
	}
	public void setSvs(Salevisitservice svs) {
		this.svs = svs;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
