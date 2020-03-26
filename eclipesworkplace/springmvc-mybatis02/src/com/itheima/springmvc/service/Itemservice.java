package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface Itemservice {

	List<Items> findItemList();

	Items findItemById(Integer id);

	void updataItem(Items item);

}
