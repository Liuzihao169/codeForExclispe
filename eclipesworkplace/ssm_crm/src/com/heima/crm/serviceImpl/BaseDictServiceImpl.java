package com.heima.crm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heima.crm.mapper.BaseDictMapper;
import com.heima.crm.pojo.BaseDict;
import com.heima.crm.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService {
	//自动从容器中去拿对象
	@Autowired
	private BaseDictMapper basedictmapper;
	@Override
	public List<BaseDict> findBaseDictListByCode(Integer code) {
		// TODO Auto-generated method stub
		return basedictmapper.findBaseDictListByCode(code);
	}

}
