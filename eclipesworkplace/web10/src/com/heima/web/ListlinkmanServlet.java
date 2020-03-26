package com.heima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.domain.LinkMan;
import com.heima.service.Linkmanservice;
import com.heima.service.imple.LinkmanserviceImple;

public class ListlinkmanServlet extends HttpServlet {

	private Linkmanservice service=new LinkmanserviceImple();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//km_name
		String lkm_name=request.getParameter("lkm_name");
		System.out.println(lkm_name+"111111111112");
		List<LinkMan>list=null;
		if(lkm_name!=null&&!"".equals(lkm_name)){//不为空的判断条件
		list=service.findlinklistByname(lkm_name);
		System.out.println(lkm_name+"1111111111111111");
		System.out.println(list);
		}
		else{
			list=service.findLinkman();//如果筛选条件为空，那么查找全部的联系人
			System.out.println(list);
		}
		request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}