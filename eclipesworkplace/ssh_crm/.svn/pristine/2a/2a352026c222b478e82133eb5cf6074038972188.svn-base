package com.heima.dao.imple;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.heima.dao.Basedictdao;
import com.heima.domain.BaseDict;

public class BasedictdaoImple extends HibernateDaoSupport implements Basedictdao {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		DetachedCriteria dc=DetachedCriteria.forClass(BaseDict.class);
		//设置条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
