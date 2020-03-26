package com.itheima.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QveryVo;
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
	public String itemList(Model model) {

		/*
		 * // List<Items> list = new ArrayList<Items>(); list.add(new Items(1,
		 * "1华为 荣耀8", 2399f, new Date(), "质量好！1")); list.add(new Items(2,
		 * "2华为 荣耀8", 2399f, new Date(), "质量好！2")); list.add(new Items(3,
		 * "3华为 荣耀8", 2399f, new Date(), "质量好！3")); list.add(new Items(4,
		 * "4华为 荣耀8", 2399f, new Date(), "质量好！4")); list.add(new Items(5,
		 * "5华为 荣耀8", 2399f, new Date(), "质量好！5")); list.add(new Items(6,
		 * "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		 */
//		ModelAndView mav = new ModelAndView();
		List<Items> itemList = is.findItemList();
//		System.out.println(itemList);
//		mav.addObject("itemList", itemList);
//		mav.setViewName("itemList");
		model.addAttribute("itemList", itemList);
		return "itemList";
	}

	@RequestMapping(value = "/item/my.action")
	public ModelAndView demo() {

		/*
		 * // List<Items> list = new ArrayList<Items>(); list.add(new Items(1,
		 * "1华为 荣耀8", 2399f, new Date(), "质量好！1")); list.add(new Items(2,
		 * "2华为 荣耀8", 2399f, new Date(), "质量好！2")); list.add(new Items(3,
		 * "3华为 荣耀8", 2399f, new Date(), "质量好！3")); list.add(new Items(4,
		 * "4华为 荣耀8", 2399f, new Date(), "质量好！4")); list.add(new Items(5,
		 * "5华为 荣耀8", 2399f, new Date(), "质量好！5")); list.add(new Items(6,
		 * "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		 */
		ModelAndView mav = new ModelAndView();

		mav.addObject("mytest", "1111111");
		mav.setViewName("my");
		return mav;
	}

	@RequestMapping(value = "/itemEdit.action")
	public String toEdit(Integer id,HttpServletRequest req,HttpServletResponse rep,Model model) {
		// 生成视图对象
		// 获得要编辑的 item对象
		Items item = is.findItemById(id);
		// 将item 对象转发到编辑页面
		model.addAttribute("item", item);
		return "/editItem";//默认就是转发
		
	}

	@RequestMapping(value = "/updateitem.action")
	// 从前端js 接收item对象
	public String updataItem(Items item,Model model,MultipartFile pictureFile,HttpServletRequest req) throws Exception, IOException {//,HttpServletRequest req,HttpServletResponse rep
		//获得upload的路径
		String realPath = req.getSession().getServletContext().getRealPath("upload");
		//货得后缀名 
		String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename() );
		//将文件写到指定路径
		String name=UUID.randomUUID().toString();
		//保存文件
		pictureFile.transferTo(new File(realPath+"\\"+name+"."+extension));
		item.setPic(name+"."+extension);
		is.updataItem(item);
		return "redirect:/itemEdit.action?id="+item.getId();
	}

	@RequestMapping(value = "/deleteIds.action") 
	// 从前端js 接收item对象
	public ModelAndView deleteIds(QveryVo vo) {
		// 生成视图对象
		ModelAndView mav = new ModelAndView();
		// 获得要编辑的 item对象
	//	is.deleteIds(vo);
		// 将item 对象转发到编辑页面 通过
		mav.setViewName("success");
		return mav;
	}
	
	@RequestMapping(value="/json.action")
	public @ResponseBody Items exchangeJson(@RequestBody Items item){
		System.out.println(item);
		return item;
	}
	@RequestMapping(value="/login.action")
	public String login(String username,HttpSession session){
		session.setAttribute("USERNAME",username);
		return "redirect:/item/you.action";
	}
}
