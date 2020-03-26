 package com.heima.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	void saveOrUpdate(T t);
	//增
	void save(T t);
	//删除
	void  deleteByid(Serializable id);
	//删除
	void delete(T t);
	//改
	void update(T t);
	//查,查总条数
	Integer findcountByname(DetachedCriteria criteria);
	//查
	List<T>findlist(DetachedCriteria criteria, Integer index, Integer currentCount);
	//查
	T getByid(Serializable id);
}
