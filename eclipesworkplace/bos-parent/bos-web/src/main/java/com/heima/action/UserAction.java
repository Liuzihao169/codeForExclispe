package com.heima.action;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.heima.bos.entity.User;
import com.heima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
@Controller("useraction")
@Scope("prototype") 
public class UserAction extends BaseAction<User>{
	@Autowired
	private UserService userService;
	private String [] roleTD;
	private String identifyingCode;
	public String findById(){
		User custoemrbyid = userService.findById(model.getId());
		ActionContext.getContext().put("custoemrbyid", custoemrbyid);
		return "my";
	}
	//登陆
	public String login(){
		//获得验证码
		String code = (String) ActionContext.getContext().getSession().get("key");
		//先判断验证码是否正确 
		if(StringUtils.isNotBlank(identifyingCode)&&code.equals(identifyingCode)){
			Subject subject = SecurityUtils.getSubject();//获得当前用户
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),model.getPassword());;
			try {
				subject.login(token);
			} catch (Exception e) {
				e.printStackTrace();
				return "login";
			} 
			User user  = (User) subject.getPrincipal();
			ActionContext.getContext().getSession().put("user", user);
			return "home";
		}else{
			//转发错误消息到登陆页面
			addActionError("验证码不正确");
			return "login";
		}
		
	
	}
	public String login_bak(){
		//获得验证码
		String code = (String) ActionContext.getContext().getSession().get("key");
		//先判断验证码是否正确 
		if(StringUtils.isNotBlank(identifyingCode)&&code.equals(identifyingCode)){
			//验证码正确 执行登陆操作
			User findUserByUsernameAndPassWord = userService.findUserByUsernameAndPassWord(model);
			if(findUserByUsernameAndPassWord!=null){
				ActionContext.getContext().getSession().put("user", findUserByUsernameAndPassWord);
				return "home";
			}else{
				addActionError("您的用户名或者密码不正确");
				return "login";
			}
		}else{
			//转发错误消息到登陆页面
			addActionError("验证码不正确");
			return "login";
		}
		
	
	}
	//退出登陆
	//logout
	public String logout(){
		//清除session当中的数据
		ActionContext.getContext().getSession().put("user", null);
		return "login";
	}
	//修改密码
	public String editPassword(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		//声明标志成功为1
	 String f="1";
		try {
			userService.excuteUpdate("user.updatePassword", model.getPassword(), user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
	//添加用户的方法
	public String add(){
		userService.save(model,roleTD);
		return "list";
	}
	//查询所有
	public String pageQuery(){
		userService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","noticebills","roles"});
		return null;
	}
	public void setRoleTD(String[] roleTD) {
		this.roleTD = roleTD;
	}
	
}
