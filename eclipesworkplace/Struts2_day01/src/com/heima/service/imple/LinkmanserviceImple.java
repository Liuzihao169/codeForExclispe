package com.heima.service.imple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.heima.dao.Linkmandao;
import com.heima.dao.imple.LinkmandaoImple;
import com.heima.domain.Customer;
import com.heima.domain.LinkMan;
import com.heima.service.Linkmanservice;
import com.heima.utils.HibernateUtils;

public class LinkmanserviceImple implements Linkmanservice {

	private Linkmandao linkmandao;

	@Override
	public void save(LinkMan linkman) {
		// TODO Auto-generated method stub
	Session session=	HibernateUtils.getcurrentSession();
	Transaction ts = session.beginTransaction();
		Long cus_id=linkman.getCus_id();
		/*
		 * 只要维护了数据库的关系即可，
		 * dao层不用维护实体的关系*/
		//找到客户
		Customer customer=linkmandao.findCusByid(cus_id);
		//添加指定联系人添加客户的cust_id(外键)
		//
		//将客户对象保存在联系人的对象表达式当中,因为linkman中包含Customer，所以添加linkman属性的时候，同时将customer属性添加减去了
		linkman.setCustomer(customer);
	
		//保存联系人
		linkmandao.save(linkman);
		ts.commit();
	
	}

	@Override
	public List<LinkMan> findLinkman() {
		Session session= HibernateUtils.getcurrentSession();
		//-----------开启事物
		Transaction tx = session.beginTransaction();
		List<LinkMan>list=linkmandao.findlinkmanList();
		tx.commit();
		return list;
	}

	@Override
	public List<LinkMan> findlinklistByname(String lkm_name) {
		Session session= HibernateUtils.getcurrentSession();
		Transaction tx = session.beginTransaction();
		List<LinkMan>list=linkmandao.findlinklistByname(lkm_name);
		tx.commit();
		return list;
	}

	public void setLinkmandao(Linkmandao linkmandao) {
		this.linkmandao = linkmandao;
	}




}
