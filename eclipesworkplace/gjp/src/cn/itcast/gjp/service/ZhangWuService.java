package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.Zhangwu;

/*
 * 业务层
 * 接收上一层 （控制层的信息）*/
public class ZhangWuService {
	private ZhangWuDao dao=new ZhangWuDao();
	 public List<Zhangwu> selectAll(){
		 return dao.selectAll();
   	  
     }
  public List<Zhangwu>select(String startData,String endData){
	  return dao.select(startData, endData);
	  
  }
  public List<Zhangwu> select_money (Double min,Double max){
	  return dao.select_money(min, max);
	  
  }
  public void addZhangwu(Zhangwu zw){
	  dao.addZhangwu(zw);
 	 
  }
  public void editZhangwu(Zhangwu zw){
	  dao.editZhangwu(zw);
 	 
  }
  public void deleteZhangwu(int zwid){
  	dao.deleteZhangwu(zwid);
  }
}
