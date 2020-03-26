package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.Itemservice;

/**
 * 鍟嗗搧绠＄悊
 * 
 * @author lx
 *
 */
@Controller
public class ItemController {
	@Autowired
	private Itemservice is;
	@RequestMapping(value = "/item/you.action")
	public ModelAndView itemList(){
		
	/*	//
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));*/
		ModelAndView mav = new ModelAndView();
		 List<Items> itemList= is.findItemList();
		 System.out.println(itemList);
		mav.addObject("itemList", itemList);
		mav.setViewName("itemList");
		return mav;
	}
	
	@RequestMapping(value = "/item/my.action")
	public ModelAndView demo(){
		
	/*	//
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));*/
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mytest", "1111111");
		mav.setViewName("my");
		return mav;
	}
	@RequestMapping(value = "itemEdit.action")
	public ModelAndView toEdit(Integer id){
		//生成视图对象
		ModelAndView mav = new ModelAndView();
		//获得要编辑的 item对象
		Items item = is.findItemById(id);
		//将item 对象转发到编辑页面
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}

	@RequestMapping(value = "updateitem.action")
		//从前端js 接收item对象
	public ModelAndView updataItem(Items item){
		//生成视图对象
		ModelAndView mav = new ModelAndView();
		//获得要编辑的 item对象
		is.updataItem(item);
		//将item 对象转发到编辑页面
		mav.setViewName("success");
		return mav;
	}

	
}
