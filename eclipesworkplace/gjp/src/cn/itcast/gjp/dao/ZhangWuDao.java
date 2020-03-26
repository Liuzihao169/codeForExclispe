package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.Zhangwu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qy=new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 查询数据库
	 * 返回方法的结果集
	 * javabean*/
	 public List<Zhangwu> selectAll(){
		 String sql="SELECT*FROM gjp_zhangwu";
		 try{
			List<Zhangwu> list=qy.query(sql,new BeanListHandler<Zhangwu>(Zhangwu.class));
		    return list;}
		 catch(SQLException ex){
			 System.out.println(ex);
			 throw new RuntimeException("查询所有账户失败");
		 }
		 
		}
	 public List<Zhangwu> select(String startData,String endData){
		 String sql="SELECT *FROM gjp_zhangwu WHERE createtime BETWEEN ?and?";
		Object [] params={ startData,endData};
		try{
		List<Zhangwu>list=qy.query(sql, new BeanListHandler<>(Zhangwu.class), params);
	    return list;
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	 }
	 public List<Zhangwu>select_money(Double min,Double max){
		 String sql="SELECT*FROM gjp_zhangwu WHERE money BETWEEN ? AND ?";
	    Object []params={min,max};
	    try{
	    List<Zhangwu>list=qy.query(sql, new BeanListHandler<>(Zhangwu.class), params);
	    return list;
	    }
	    catch(SQLException ex){
	    	throw  new RuntimeException("出现错误");
	    }
	 }
public void addZhangwu(Zhangwu zw){
	String sql="INSERT INTO gjp_zhangwu VALUES(?,?,?,?,?,? )";
	Object [] params={zw.getZwid(),zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
    try {
		qy.update(sql, params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	 
     }
public void editZhangwu(Zhangwu zw){
	String sql="UPDATE gjp_zhangwu SET 	flname=?,money=?,zhanghu=?,createtime=?,description=?WHERE zwid=?";
	 Object []params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
      try{qy.update(sql, params);}
      catch(SQLException ex){
    	  System.out.println(ex);
      }
}
public void deleteZhangwu(int zwid){
	String sql="DELETE FROM gjp_zhangwu WHERE zwid=?;";
	Object[]params={zwid};
	try{
	qy.update(sql, params);
	}catch(SQLException ex){
		System.out.println(ex);
	}
}
}
