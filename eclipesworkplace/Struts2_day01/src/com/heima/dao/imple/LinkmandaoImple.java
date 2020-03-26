package com.heima.dao.imple;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.heima.dao.Linkmandao;
import com.heima.domain.Customer;
import com.heima.domain.LinkMan;
import com.heima.utils.HibernateUtils;

public class LinkmandaoImple implements Linkmandao {

	@Override
	public Customer findCusByid(Long cus_id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getcurrentSession();
		return session.get(Customer.class, cus_id);
	
	}

	@Override
	public void save(LinkMan linkman) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getcurrentSession();
		session.save(linkman);
	}

	@Override
	public List<LinkMan> findlinkmanList() {
		Session session=HibernateUtils.getcurrentSession();
		String hql="from LinkMan";
		Query qy = session.createQuery(hql);
		List<LinkMan>list=qy.list();
		return list;
	}

	@Override
	public List<LinkMan> findlinklistByname(String lkm_name) {
		Session session = HibernateUtils.getcurrentSession();
		String hql="from LinkMan where lkm_name like ?";
		Query qy = session.createQuery(hql);
		qy.setParameter(0, "%"+lkm_name+"%");
		List <LinkMan>list = qy.list();
		return list;
	}

	
	

	

}
