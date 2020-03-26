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
		 * 功能加强
		 * 1.增强类要与被增强的类实现统一的接口
		 * 2.在增强类中传入被增强的类
		 * 3.需要正清的方法从就重写，不需要发就调用对象
        */
		/*HttpServletRequest requ=(HttpServletRequest) request;
		//增强对象
		EnhanceRequest enhanceRequest=new EnhanceRequest(requ);
		//传入被增强的类，
		System.out.println("我是通行管");
		chain.doFilter(enhanceRequest, response);
	*/
		
		/*
		 * 
		 * 使用动态代理的方式解决全局的乱码问题*/
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
	
/*	使用装饰者的方式进行强转
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
