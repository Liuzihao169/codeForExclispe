package com.heima.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Decidedzone;
import com.heima.bos.entity.Noticebill;
import com.heima.bos.entity.User;
import com.heima.bos.entity.Workbill;
import com.heima.dao.DecidedzoneDao;
import com.heima.dao.NoticebillDao;
import com.heima.dao.WorkbillDao;
import com.heima.service.CustomerService;
import com.heima.service.NoticebillService;
import com.opensymphony.xwork2.ActionContext;
@Service
@Transactional
public class NoticebillServiceImpl implements NoticebillService {
	@Autowired
	private NoticebillDao noticebillDao;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DecidedzoneDao decidedzoneDao;
	@Autowired
	private WorkbillDao workbillDao;
	public void save(Noticebill model) {
		noticebillDao.save(model);
		//还要封装完整 Noticebill这个对象
		User user = (User) ActionContext.getContext().getSession().get("user");
		model.setUser(user);
		String pickaddress = model.getPickaddress();
		//根据地址 找到相关的 定区id 
		String DecidedzoneId = customerService.findDecidedzoneIdByAdderss(pickaddress);
		//通过地区id可以找到定区的信息 从而可以知道取派员的信息  然后就可以自动派单
		Decidedzone decidedzone = decidedzoneDao.findById(DecidedzoneId);
		//如果id不为空 那么自动分单
		if(decidedzone!=null){
			model.setStaff(decidedzone.getStaff());
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			Workbill workbill=new Workbill();
			workbill.setAttachbilltimes(0);
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workbill.setNoticebill(model);
			workbill.setPickstate(Workbill.PICKSTATE_NO);
			workbill.setRemark(model.getRemark());
			workbill.setStaff(decidedzone.getStaff());
			workbill.setType(Workbill.TYPE_1);
			workbillDao.save(workbill);
		}else{
			//手动分单
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}
}
