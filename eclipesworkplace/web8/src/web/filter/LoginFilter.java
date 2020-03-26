package web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.LoginService;

           /*
            * 
            * 
            * 
            * 
            * 
            * 这个过滤器的功能就是加强功能的
            * 就是提取cookie中的个人信息*/
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest res=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		//只有http里的request和response才能获得cookie的
		
		Cookie[] cookies = res.getCookies();
		//判断cookie是否为空
		String password=null;
		String username=null;
		if(cookies!=null){
			for(Cookie cook:cookies){
				if(cook.getName().equals("password")){
					password=cook.getValue();
					
				}
				if(cook.getName().equals("username")){
					username=cook.getValue();
					
				}
			}
			
		}
		//自动登陆的功能
		if(password!=null&&username!=null){
		LoginService loginservice=new LoginService();
		User user=null;
		HttpSession session = ((HttpServletRequest) request).getSession();
		try {
			 user=loginservice.login(username,password);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("user", user);
		chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}
