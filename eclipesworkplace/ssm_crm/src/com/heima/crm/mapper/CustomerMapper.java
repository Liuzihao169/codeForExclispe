package com.heima.crm.mapper;

import com.heima.common.utils.Page;
import com.heima.crm.pojo.Customer;
import com.heima.crm.pojo.CustomerExample;
import com.heima.crm.pojo.QueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
  public Long fingCustomerCountByQveryVo(QueryVo vo);
  public List<Customer> fingCustomerListByQveryVo(QueryVo vo);
  public Customer findCustomerById(Integer id);
  public void update(Customer cust);
public void deleteById(Integer id);
}