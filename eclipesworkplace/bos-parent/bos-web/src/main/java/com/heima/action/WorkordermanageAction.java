package com.heima.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Workordermanage;
import com.heima.service.WorkordermanageService;
@Controller("workordermanageAction")
@Scope("prototype")
public class WorkordermanageAction extends  BaseAction<Workordermanage>{
	//速添加工作单是功能
	@Autowired
	private WorkordermanageService  workordermanageService;  
	//快速添加功能
	public String quickadd(){
		workordermanageService.save(model);
		return null;
	}
}
