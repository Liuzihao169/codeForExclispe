package com.heima.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.heima.dao.Customerdao;
import com.heima.domain.Customer;

public class CustomerdaoImple extends BaseDaoImple<Customer> implements Customerdao {

	@Override
	public List<Object[]> findindustyCount() {
		String sql="SELECT ba.`dict_item_name`,COUNT(*)  total FROM cst_customer cs,base_dict ba WHERE cs.`cust_industry`=ba.`dict_id` GROUP BY cs.`cust_industry`";
		return getHibernateTemplate().execute( new HibernateCallback<List<Object[]>>(){

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
			SQLQuery query = session.createSQLQuery(sql);
			List <Object[]>list = query.list();
				return list;
			}});
	
		
	}

	
}
