package cn.itcast.gjp.contorller;

import java.util.List;

import cn.itcast.gjp.domain.Zhangwu;
import cn.itcast.gjp.service.ZhangWuService;

public class ZhangWuContorller {
 private ZhangWuService  service=new ZhangWuService();
      public List<Zhangwu> selectAll(){
    	  return service.selectAll();
    	  
      }
      public List<Zhangwu> select(String startData,String endData){
    	return service.select(startData, endData);
   
      }
      public List<Zhangwu> select_money(Double min, Double max){
    	  return service.select_money(min, max);
      }
     public void addZhangwu(Zhangwu zw){
    	 service.addZhangwu(zw);
     }
     public void editZhangwu(Zhangwu zw){
    	 service.editZhangwu(zw);
     }
    public void deleteZhangwu(int zwid){
    	service.deleteZhangwu(zwid);
    }
}
