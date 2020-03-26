package com.heima.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.heima.entity.Customer;
import com.heima.service.CustomerService;
@Transactional
public class CustomerServiceImpl extends JdbcDaoSupport implements CustomerService {

	
	public List<Customer> findAll() {
		String sql="select * from t_customer";
		List<Customer>list=this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}});
		return list;
	}

	
	public List<Customer> findNotAssocition() {
		String sql="select * from t_customer where decidedzone_id is null";
		List<Customer>list=this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}});
		return list;
	}

	
	public List<Customer> findHasAssocition(String decidedzone_id) {
		String sql="select * from t_customer where decidedzone_id =?";
		List<Customer>list=this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}},decidedzone_id);
		return list;
	}

	
	public void assigncustomerstodecidedzone(Integer [] ids, String id) {
		//1.更新关联定区ID 全部清空为null
		String sql1="UPDATE t_customer SET decidedzone_id = NULL WHERE decidedzone_id =?";
		this.getJdbcTemplate().update(sql1, id);
		String sql2="update t_customer set decidedzone_id=? where id=?";
		for (Integer customerid : ids) {
			this.getJdbcTemplate().update(sql2,id, customerid);
		}
	}
	/*
	 * 
	 * (non-Javadoc)
	 * @see com.heima.service.CustomerService#findCustomerListByDecidedzoneId(java.lang.String)
	 * 通过deicidedzone查询客户
	 */

	
	public Customer findCustomerByTelphone(String telphone) {
		String sql="select * from t_customer where telephone =?";
		List<Customer>list=this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}},telphone);
		//任何查询结果返回的都是一个list集合
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public String findDecidedzoneIdByAdderss(String address) {
		String sql="select decidedzone_id from t_customer where address=?";
		String decidedzone_id = this.getJdbcTemplate().queryForObject(sql, String.class, address);
		return decidedzone_id;
	}

}
