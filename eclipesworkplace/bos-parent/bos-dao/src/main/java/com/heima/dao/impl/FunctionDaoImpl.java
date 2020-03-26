package com.heima.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.heima.bos.entity.Function;
import com.heima.dao.FunctionDao;
import com.heima.utils.PageBean;
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {
/*
 * 
 * 重写findAll方法
 */
		public List<Function>findAll(){
			String hql="from Function f where f.parentFunction is null";
			List<Function>list=(List<Function>) this.getHibernateTemplate().find(hql);
			return list;
		}
		public List<Function> findFunctionByUserId(String id) {
			String hql="SELECT	DISTINCT f From Function f LEFT OUTER JOIN f.roles r  LEFT OUTER JOIN r.users u WHERE u.id=? ";
			List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);
			return list;
		}
		public List<Function> findAllMenu() {
			//查询全部有菜单的权限
			String hql="SELECT	DISTINCT f From Function f LEFT OUTER JOIN f.roles r  LEFT OUTER JOIN r.users u WHERE f.generatemenu='1' ORDER BY f.zindex DESC ";
			List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
			return list;
		}
		//根据登陆用户的id查询菜单栏目
		public List<Function> findMenuByUserId(String Id) {
			//查询全部有菜单的权限
			String hql="SELECT	DISTINCT f From Function f LEFT OUTER JOIN f.roles r  LEFT OUTER JOIN r.users u WHERE f.generatemenu='1' AND u.id=? ORDER BY f.zindex DESC ";
			List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,Id);
			return list;
		}
}
