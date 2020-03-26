package com.heima.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Workbill;
@Controller("workbillAction")
@Scope("prototype")
public class WorkbillAction extends BaseAction<Workbill> {

}
