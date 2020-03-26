package Filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		/*
		 * ���ܼ�ǿ
		 * 1.��ǿ��Ҫ�뱻��ǿ����ʵ��ͳһ�Ľӿ�
		 * 2.����ǿ���д��뱻��ǿ����
		 * 3.��Ҫ����ķ����Ӿ���д������Ҫ���͵��ö���
        */
		/*HttpServletRequest requ=(HttpServletRequest) request;
		//��ǿ����
		EnhanceRequest enhanceRequest=new EnhanceRequest(requ);
		//���뱻��ǿ���࣬
		System.out.println("����ͨ�й�");
		chain.doFilter(enhanceRequest, response);
	*/
		
		/*
		 * 
		 * ʹ�ö�̬����ķ�ʽ���ȫ�ֵ���������*/
		HttpServletRequest requ=(HttpServletRequest) request;
		HttpServletRequest  pro=(HttpServletRequest)Proxy.newProxyInstance(
				requ.getClass().getClassLoader(),
				requ.getClass().getInterfaces(),
				new InvocationHandler(){

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						if(method.getName().equals("getParameter")){
							String invok=(String) method.invoke(requ, args);
						   invok=new String(invok.getBytes("iso8859-1"),"UTF-8"); 
						   return invok;
						}
						return method.invoke(requ, args);
					}}
			);
		chain.doFilter(pro, response);
				
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
/*	ʹ��װ���ߵķ�ʽ����ǿת
 * class EnhanceRequest extends HttpServletRequestWrapper{
		     HttpServletRequest request;
		public EnhanceRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
			// TODO Auto-generated constructor stub
		}
		public String getParameter(String name){
			String parameter=request.getParameter(name);
			try {
				parameter=new String(parameter.getBytes("iso8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return parameter;
			
		}

	}*/

}
