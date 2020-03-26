package com.heima.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.heima.bos.entity.Subarea;
import com.heima.dao.SubareaDao;
import com.heima.utils.HighchartsByPrivence;
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements SubareaDao{

	public List<Object> findSubareaByProvince() {
		String hql="SELECT r.province ,COUNT(*)	FROM Subarea s LEFT OUTER JOIN s.region r GROUP BY r.province";
		/*String sql="SELECT r.`province`,COUNT(*) Y FROM bc_subarea s RIGHT JOIN  bc_region r ON s.`region_id`=r.`id` GROUP BY r.`province`;";
		Session currentSession = this.getSessionFactory().getCurrentSession();
		SQLQuery query = currentSession.createSQLQuery(sql);
		query.addEntity(HighchartsByPrivence.class);
		List list = query.list();*/
		List<Object> find = (List<Object>) this.getHibernateTemplate().find(hql);
		return find;
	}
}
