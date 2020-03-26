package com.heima.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.heima.dao.BaseDao;
import com.heima.utils.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	@Resource//根据类型注入spring工厂中的会话工厂对象sessionFactory,第一部先
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	public BaseDaoImpl(){
		//
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		clazz=	(Class) actualTypeArguments[0];
	}
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void updade(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public List<T> findAll() {
		String sql="from "+clazz.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(sql);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	@Override
	public void excuteUpdate(String queryName, Object... object) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		//添加参数
		for(Object obj:object){
			query.setParameter(i++, obj);
		}
		//执行更新操作
		query.executeUpdate();
	}
	
	@Override
	public void pageQuery(PageBean pageBean) {
		int currentPage=pageBean.getCurrentPage();
		int pageSize=pageBean.getPageSize();
		int startIndex=(currentPage-1)*pageSize;
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//查询总数
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> findByCriteria = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		pageBean.setTotal(findByCriteria.get(0).intValue());
		detachedCriteria.setProjection(null);//清空查询总数的
		//解决多表查询 封装对象不对的情况，把对象里的 对象字段   与本身维护成一个关系了,维护在一个对象里面
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		//查询rows
		List  rows= this.getHibernateTemplate().findByCriteria(detachedCriteria, startIndex, pageSize);
		pageBean.setRows(rows);
	}
	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate( t);
	}
	@Override
	public List<T> findByCreaitar(DetachedCriteria criteria) {
		return (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
	}
}
