<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
sdfasdfasdf
${empty userjstl}
<li>${sessionScope.userjstl.username}</li>
			<li>${userjstl.id}</li>
			<li>${userjstl.password}</li>
			<li>${userjstl.emila}</li>
			<hr>
			<c:if test="${empty userjstl}">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
			</c:if>
			<c:if test="${!empty userjstl}">
			<li>${sessionScope.userjstl.username}</li>
			<li>${userjstl.id}</li>
			<li>${userjstl.password}</li>
			<li>${userjstl.emila}</li>
			</c:if>
</body>
</html>