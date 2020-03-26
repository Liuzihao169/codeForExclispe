package com.heima.crm.service;

import java.util.List;

import com.heima.crm.pojo.BaseDict;

public interface BaseDictService {
	   public List<BaseDict> findBaseDictListByCode(Integer code);
}
