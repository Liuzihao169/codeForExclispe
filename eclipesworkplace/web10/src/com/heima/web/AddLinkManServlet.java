package com.heima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.heima.domain.LinkMan;
import com.heima.service.Linkmanservice;
import com.heima.service.imple.LinkmanserviceImple;

public class AddLinkManServlet extends HttpServlet {

	private Linkmanservice linkmanservice=new LinkmanserviceImple();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkMan linkman=new LinkMan();
		try {
			BeanUtils.populate(linkman, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		linkmanservice.save(linkman);
		response.sendRedirect(request.getContextPath()+"/listlinkman");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}