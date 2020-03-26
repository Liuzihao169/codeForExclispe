package com.heima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Staff;
import com.heima.dao.StaffDao;
import com.heima.service.StaffService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;
	@Override
	public void add(Staff staff) {
		staffDao.save(staff);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
	@Override
	public void delete(String ids) {
		String[] split = ids.split(",");
		for(String id:split){
			staffDao.excuteUpdate("staff.delete", id);
		}
	}
	@Override
	public void edit(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.excuteUpdate("staff.edit", staff.getName(),staff.getTelephone(),staff.getHaspda(),
			                  staff.getStation(),staff.getStandard(),staff.getId());
	}
	@Override
	public List<Staff> findListIsNotDelete(DetachedCriteria criteria) {
		
		return staffDao.findByCreaitar(criteria);
	}
	
}
