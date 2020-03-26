<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
	var parments='{"id":4,"name":"张三","price":199,"detail":"这是一个测试商品","pic":"123456.jpg"}';
	$.ajax({
		data:parments,
		dataType:"json",
		type:"post",
		success:function(data){
			alert(data.name);
		},
		url:"${pageContext.request.contextPath }/json.action",
		contentType:"application/json;charset=UTF-8"
	});

});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/deleteIds.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList}" var="item" varStatus="vs">
<tr>
	<td>
	<input type="checkbox" name="ids" value="${item.id}">
	<input type="text" name="list[${vs.index}].name" value="${item.name}"></td>
	<td><input type="text" name="list[${vs.index}].price" value="${item.price}"></td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
<input type="submit" value="删除修改">
</form>
</body>

</html>