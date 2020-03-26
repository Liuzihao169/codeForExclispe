package com.heima.userdaoImpl;



import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.pojo.User;
import com.heima.userdao.userdao;

public class UserdaoImpl extends SqlSessionDaoSupport  implements userdao {
  //为user	通过spring注入的 方式  也可以手动注入
	/*@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sf;
*/
	@Test
	public void test1(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u=this.getSqlSession().selectOne("text.findbyid", 1);
	//	User u=sf.openSession().selectOne("text.findbyid", 1);
		System.out.println(u);
	}

/*	通过注解方式的时候 注入 sessionfactory
 * public void setSf(SqlSessionFactory sf) {
	super.setsetSessionFactory(sf)
	*/} 

