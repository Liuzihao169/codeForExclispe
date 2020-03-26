<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="day15.demo.domainuser.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <%
           //模拟list《String》
           List<String>list=new ArrayList<String>();
        list.add("王二");
        list.add("dabai");
        list.add("shazhu");
      session.setAttribute("list", list);
      User user=new User(1,"dawang1","3451","emila1");
      User user1=new User(2,"dawang2","3452","emila2");
      User user2=new User(3,"dawang3","3453","emila3");
      
     List<User>list1=new ArrayList<User>();
     list1.add(user);
     list1.add(user1);
     list1.add(user2);
     session.setAttribute("userlist", list1);
        %>
       <%--  <c:forEach begin="0" end="${list.size}" var="${list.[i]}">
        ${var}
        </c:forEach> --%>
     
     <c:forEach items="${list}" var="li">
     ${li}
     </c:forEach>
     <hr>
     <c:forEach items="${userlist}" var="us">
        ${us.username}---------${us.id }--------${us.password }------${us.emila}
        <br>
        </c:forEach>
</body>
</html>