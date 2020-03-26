package com.heima.a_action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.heima.domain.LinkMan;
import com.heima.service.Linkmanservice;
import com.heima.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkmanAction extends ActionSupport implements ModelDriven<LinkMan>{
	private  Integer currentPage;
	private Integer   currentCount;
	private LinkMan lm=new LinkMan();
	private Linkmanservice linkmanservice;
	//添加联系人
	public String add() {
		//获得数据存储在数据库
	//	System.out.println(lm.getCustomer().getCust_id());
		System.out.println(lm);
		
		linkmanservice.saveOrUpdate(lm);
	
		//转发到list的action
		return "tolinkmanlist";
	}
	public String toEdit(){
		//通过返回的id查询linkman对象
		LinkMan lkm=linkmanservice.getById(lm.getLkm_id());
		//将对象存储到request域当中
		ActionContext.getContext().put("lkm", lkm);
	
		
		return "add";
	}
	//联系人列表
	public String list(){
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		//System.out.println("11111"+lm.getLkm_name());
		if(lm.getLkm_name()!=null){
			criteria.add(Restrictions.like("lkm_name", "%"+lm.getLkm_name()+"%"));
		}
		if(lm.getCustomer()!=null&&lm.getCustomer().getCust_id()!=null){
			criteria.add(Restrictions.eq("customer.cust_id", lm.getCustomer().getCust_id()));
		}
		//获得pagebean
		//System.out.println("222222222");
		PageBean pg=linkmanservice.getpagebean(criteria,currentCount,currentPage);
		//将pagebean存储在request域当中 然后转发到list页面
		//System.out.println(pg+"33333333");
		ActionContext.getContext().put("pagebean", pg);
		return "listlinkman";
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return lm;
	}

	public void setLinkmanservice(Linkmanservice linkmanservice) {
		this.linkmanservice = linkmanservice;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	

}
