<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- page,request,session,application数据域的顺序--%>

<% request.setAttribute("name","zhangshan");
 application.setAttribute("name","wangwu");%>
 
 <!-- el的全域查找 -->
 
 ${name }
 ${requestScope.name}
 ${applicationScope.name}  
 ${empty ""}
</body>
</html>