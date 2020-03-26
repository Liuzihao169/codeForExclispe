package com.heima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.bos.entity.Staff;
import com.heima.utils.PageBean;

public interface StaffService  {
	public void add(Staff staff);
	public void pageQuery(PageBean pageBean);
	public void delete(String ids);
	public void edit(Staff staff);
	public List<Staff>findListIsNotDelete( DetachedCriteria criteria);
}
