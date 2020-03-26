package com.heima.dao.imple;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.heima.dao.Customerdao;
import com.heima.domain.Customer;
import com.heima.utils.HibernateUtils;

public class CustomerdaoImple implements Customerdao {

	@Override
	public void save(Customer c) {
          //获得session
		Session session=HibernateUtils.getcurrentSession();
		//打开事务
		Transaction beginTransaction = session.beginTransaction();
		//执行保存
		session.save(c);
		
		//提交事务
		beginTransaction.commit();
		//关闭资源
	
	}

	@Override
	public List<Customer> findcustomerlist() {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtils.getcurrentSession();
		 Transaction ts = session.beginTransaction();
		 String Hql="from Customer";
		 //创建查询对象
		Query createQuery = session.createQuery(Hql);
		List <Customer>list = createQuery.list();
		ts.commit();
	  
		return list;
	}

	@Override
	public List<Customer> findcustomerbyname(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		
			Session session = HibernateUtils.getcurrentSession();
		 Criteria criteria = dc.getExecutableCriteria(session);
	
		return criteria.list();
	}

}
