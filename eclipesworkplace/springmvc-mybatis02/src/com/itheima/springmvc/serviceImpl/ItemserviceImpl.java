package com.itheima.springmvc.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.mapper.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.Itemservice;
@Service
public class ItemserviceImpl implements Itemservice {
	//因为是扫描全包的让后使用这种自动注入的方式 更加稳妥
	@Autowired
	ItemsMapper im;
	@Override
	public List<Items> findItemList() {
		// TODO Auto-generated method stub
		return im.selectByExample(null);
	}
	@Override
	public Items findItemById(Integer id) {
		// TODO Auto-generated method stub
		return im.selectByPrimaryKey(id);
	}
	@Override
	public void updataItem(Items item) {
		// TODO Auto-generated method stub
		//item.setCreatetime(new Date());
		//通过id更新
		 im.updateByPrimaryKeyWithBLOBs(item);
	}

}
