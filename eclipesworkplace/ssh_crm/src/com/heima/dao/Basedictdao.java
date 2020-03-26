package com.heima.dao;

import java.util.List;

import com.heima.domain.BaseDict;

public interface Basedictdao {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
