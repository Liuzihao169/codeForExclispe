package com.heima.service.impl;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Workordermanage;
import com.heima.dao.WorkordermanageDao;
import com.heima.service.WorkordermanageService;
@Service
@Transactional
public class WorkordermanageServiceImpl implements WorkordermanageService {
	@Autowired
	private WorkordermanageDao workordermanageDao;
	public void save(Workordermanage model) {
	  String f="0";
		try {
			workordermanageDao.save(model);
		} catch (Exception e) {
			// 如果失败那么返回标志错误
			f="1";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().println(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
