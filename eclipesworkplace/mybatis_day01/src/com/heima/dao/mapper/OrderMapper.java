package com.heima.dao.mapper;

import java.util.List;

import com.heima.bean.Orders;

public interface OrderMapper {
	public List<Orders> findAllorder();
	public List<Orders>findOrders();

}
