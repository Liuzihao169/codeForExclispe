package com.heima.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.heima.dao.BaseDao;
import com.heima.dao.Userdao;
import com.heima.domain.User;

public class UserdaoImple extends BaseDaoImple <User>implements Userdao {

	@Override
	//匿名内部类使用参数要设置成final
	public User getUserByuserCode( final String user_code) {
	/*	//第一种通过hql方式查询，通过spring自带的hibernate模板,继承HIbernatesupport可以从dao中获得
		//hibernate模板
     	return	getHibernateTemplate(). e(new HibernateCallback<User>(){

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				//hql查询的语句中不会出现任何与数据库相关的信息，这个是对象查询的语句
				String hql="from User where user_code=?";
			    //获得操作对象 hql
				Query qy = session.createQuery(hql);
				//设置参数
				qy.setParameter(0, user_code);
				//获得一个返回结果的 方法 uniqueResult
				User user = (User) qy.uniqueResult();
				return user;
			}});*/
		
		//使用Criteria查询语句
		DetachedCriteria criteria= DetachedCriteria.forClass(User.class);
		//设置条件 如果没有条件那么返回数据库当中 第一行的值
		criteria.add(Restrictions.eq("user_code", user_code));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
     	
	
	}



}
