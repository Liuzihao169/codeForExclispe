package com.heima.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.bos.entity.Function;
import com.heima.bos.entity.Region;
import com.heima.utils.PageBean;

public interface BaseDao <T>{
	
	   public void save(T t);
	   public void delete(T t);
	   public void updade(T t);
	   public List<T> findAll();
	   public T findById(Serializable id);
	   //更新的公共方法
	   public void excuteUpdate(String queryName,Object...object);
	   //分页的公共方法
	   public void pageQuery(PageBean pageBean);
	   //更新或者保存的方法
	   public void saveOrUpdate(T t);
	   //公用查询方法
	  List<T> findByCreaitar(DetachedCriteria criteria);
}
