package com.heima.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Workordermanage;
import com.heima.service.WorkordermanageService;
@Controller("workordermanageAction")
@Scope("prototype")
public class WorkordermanageAction extends  BaseAction<Workordermanage>{
	//����ӹ������ǹ���
	@Autowired
	private WorkordermanageService  workordermanageService;  
	//������ӹ���
	public String quickadd(){
		workordermanageService.save(model);
		return null;
	}
}
