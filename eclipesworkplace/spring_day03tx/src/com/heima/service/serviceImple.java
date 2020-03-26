package com.heima.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.heima.dao.dao;

public class serviceImple implements service {
   
	private dao userdao;
	@Override
	@Transactional(isolation=Isolation.DEFAULT ,readOnly=false,propagation=Propagation.REQUIRED)
	public void transform(Integer from, Integer to, Double money) {
		userdao.removeMonery(from, money);
	int i=1/0;
		userdao.addMonery(to, money);
	}
	public void setUserdao(dao userdao) {
		this.userdao = userdao;
	}

}
