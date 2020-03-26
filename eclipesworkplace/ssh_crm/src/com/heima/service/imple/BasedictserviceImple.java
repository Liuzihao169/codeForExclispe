package com.heima.service.imple;

import java.util.List;

import com.heima.dao.Basedictdao;
import com.heima.domain.BaseDict;
import com.heima.service.Basedictservice;

public class BasedictserviceImple implements Basedictservice {

	private Basedictdao basedictdao;

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		return basedictdao.getListByTypeCode( dict_type_code);
	}

	public void setBasedictdao(Basedictdao basedictdao) {
		this.basedictdao = basedictdao;
	}

}
