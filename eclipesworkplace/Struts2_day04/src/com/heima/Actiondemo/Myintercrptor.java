package com.heima.Actiondemo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Myintercrptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ִ��������֮ǰ");
		//���У�Ȼ���������20��������
		arg0.invoke();
		System.out.println("ִ��������֮��");
		//����ύ�ַ�success��result�����������תҳ��
		return "success";
	}

}
