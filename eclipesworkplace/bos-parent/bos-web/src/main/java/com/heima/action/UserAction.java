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
	//��½
	public String login(){
		//�����֤��
		String code = (String) ActionContext.getContext().getSession().get("key");
		//���ж���֤���Ƿ���ȷ 
		if(StringUtils.isNotBlank(identifyingCode)&&code.equals(identifyingCode)){
			Subject subject = SecurityUtils.getSubject();//��õ�ǰ�û�
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
			//ת��������Ϣ����½ҳ��
			addActionError("��֤�벻��ȷ");
			return "login";
		}
		
	
	}
	public String login_bak(){
		//�����֤��
		String code = (String) ActionContext.getContext().getSession().get("key");
		//���ж���֤���Ƿ���ȷ 
		if(StringUtils.isNotBlank(identifyingCode)&&code.equals(identifyingCode)){
			//��֤����ȷ ִ�е�½����
			User findUserByUsernameAndPassWord = userService.findUserByUsernameAndPassWord(model);
			if(findUserByUsernameAndPassWord!=null){
				ActionContext.getContext().getSession().put("user", findUserByUsernameAndPassWord);
				return "home";
			}else{
				addActionError("�����û����������벻��ȷ");
				return "login";
			}
		}else{
			//ת��������Ϣ����½ҳ��
			addActionError("��֤�벻��ȷ");
			return "login";
		}
		
	
	}
	//�˳���½
	//logout
	public String logout(){
		//���session���е�����
		ActionContext.getContext().getSession().put("user", null);
		return "login";
	}
	//�޸�����
	public String editPassword(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		//������־�ɹ�Ϊ1
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
	//����û��ķ���
	public String add(){
		userService.save(model,roleTD);
		return "list";
	}
	//��ѯ����
	public String pageQuery(){
		userService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","noticebills","roles"});
		return null;
	}
	public void setRoleTD(String[] roleTD) {
		this.roleTD = roleTD;
	}
	
}
