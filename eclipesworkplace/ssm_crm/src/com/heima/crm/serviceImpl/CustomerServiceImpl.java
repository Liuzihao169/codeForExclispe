package com.heima.crm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heima.common.utils.Page;
import com.heima.crm.mapper.CustomerMapper;
import com.heima.crm.pojo.Customer;
import com.heima.crm.pojo.QueryVo;
import com.heima.crm.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customermapper;
	
	   /*private int total;
	private int page;
	private int size;
    private List<T> rows;*/
	@Override
	public Page<Customer> findPage(QueryVo vo) {
		// TODO Auto-generated method stub
		//先判断vo 然后判空 判断查询条件是否是空
		Page<Customer> page=new Page<Customer>();
		vo.setSize(5);
		vo.setStart((vo.getPage()-1)*vo.getSize());
		page.setSize(vo.getSize());
		Long totallong=customermapper.fingCustomerCountByQveryVo(vo);
		List<Customer> list=customermapper.fingCustomerListByQveryVo(vo);
		page.setPage(vo.getPage());
		page.setTotal(totallong.intValue());
		page.setRows(list);
		return page;
	}

	@Override
	public Customer findCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customermapper.findCustomerById( id);
	}

	@Override
	public void update(Customer cust) {
		// TODO Auto-generated method stub
		 customermapper.update( cust);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		customermapper.deleteById( id);
	}

	
}
