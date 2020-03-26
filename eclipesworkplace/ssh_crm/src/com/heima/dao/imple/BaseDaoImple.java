package com.heima.dao.imple;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.heima.dao.BaseDao;

public class BaseDaoImple<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class clazz;
	public BaseDaoImple(){
		//获得basedaoimple的泛型的父类
			ParameterizedType paramet = (ParameterizedType) this.getClass().getGenericSuperclass();
	     	//获得当前这歌类的class(运行时期的泛型)
			clazz=	(Class) paramet.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}
	@Override 
	public void deleteByid(Serializable id) {
		// TODO Auto-generated method stub 		   
		T t=this.getByid(id);
		//先获得再删除
		getHibernateTemplate().delete(t);
	}
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer findcountByname(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		criteria.setProjection(Projections.rowCount());
		//返回结果是long型的
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		//要清空 
		criteria.setProjection(null);
		if(list!=null&&list.size()>0){
			return  list.get(0).intValue();
		}
		else{
			return null;
		}
	}

	@Override
	public List<T> findlist(DetachedCriteria criteria, Integer index, Integer currentCount) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(criteria, index, currentCount);
		return list;
	}
   
	@Override
	public T getByid(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
		
	}
	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(t);
		
	}

}
