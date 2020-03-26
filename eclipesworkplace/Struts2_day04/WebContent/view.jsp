<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  --><hr/>
	<s:iterator value="#list">
	<!-- 自动去第一个栈顶元素 -->
		<s:property/><br>
	</s:iterator>
	<hr/>
      <s:iterator value="#list" var="name" ><!-- 会临时作为键存储在actioncontext当中 -->
		<s:property value="#name" />
	  </s:iterator>
     <hr>
     <!-- ------------------------------ -->
     <s:iterator begin="0" end="100" step="2">
     	<s:property/>|
     </s:iterator>
     <hr>
     <!-- ---------------------------------- -->
     <s:if test="#list.size()==3">
       list的长度为3
     </s:if>
     <s:elseif test="#list.size()==4">
     list的长度为4
     </s:elseif>
     <s:else>
     list的长度不3不4
     </s:else>
</body>
</html>