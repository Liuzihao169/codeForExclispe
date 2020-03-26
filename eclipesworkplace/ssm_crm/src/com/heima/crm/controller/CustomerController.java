package com.heima.crm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.heima.common.utils.Page;
import com.heima.crm.pojo.BaseDict;
import com.heima.crm.pojo.Customer;
import com.heima.crm.pojo.QueryVo;
import com.heima.crm.service.BaseDictService;
import com.heima.crm.service.CustomerService;
@Controller
public class CustomerController {
	@Autowired
	private BaseDictService basedictservice;
	@Autowired
	private CustomerService customerservice;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/customer/list.action")
	public String list(QueryVo vo,Model model){
		//fromType002,industryType001 levelType006
		List<BaseDict> fromType = basedictservice.findBaseDictListByCode(002);
		List<BaseDict> industryType = basedictservice.findBaseDictListByCode(001);
		List<BaseDict> levelType = basedictservice.findBaseDictListByCode(006);
	   Page<Customer> findPage = customerservice.findPage(vo);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("page", findPage);
		//把数据传去jsp页面让其显
		model.addAttribute("cust_name", vo.getCustName());
		model.addAttribute("cust_source", vo.getCustSource());
		model.addAttribute("cust_industry", vo.getCustIndustry());
		model.addAttribute("cust_level", vo.getCustLevel());
		return "customer";
	}
	//修改 把查询回来的 数据 转换成json的数据格式 然后传回到页面上

	@RequestMapping(value="/customer/edit.action")
	public 	@ResponseBody Customer edit(Integer id) throws IOException{
		Customer cust=customerservice.findCustomerById(id);
			return cust;
	}
	//保存编辑页面
	@RequestMapping(value="/customer/update.action")
	public 
	@ResponseBody
	String update(Customer cust){
		customerservice.update(cust);
		return "OK";
	}
	//customer/delete.action
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody String delete(Integer id){
		customerservice.deleteById(id);
		return "OK";
	}
}
