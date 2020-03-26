package com.heima.crm.mapper;

import com.heima.crm.pojo.BaseDict;
import java.util.List;

public interface BaseDictMapper {
   public List<BaseDict> findBaseDictListByCode(Integer code);
}