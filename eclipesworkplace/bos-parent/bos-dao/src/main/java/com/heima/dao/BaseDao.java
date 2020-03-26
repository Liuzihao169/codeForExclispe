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
	   //���µĹ�������
	   public void excuteUpdate(String queryName,Object...object);
	   //��ҳ�Ĺ�������
	   public void pageQuery(PageBean pageBean);
	   //���»��߱���ķ���
	   public void saveOrUpdate(T t);
	   //���ò�ѯ����
	  List<T> findByCreaitar(DetachedCriteria criteria);
}
