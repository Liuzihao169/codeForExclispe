<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>

<body>
<a class="easyui-menubutton"  data-options="iconCls:'icon-help',menu:'#mm'">控制面板</a>
<div id="mm">
	<div data-options="iconCls:'icon-edit' ">修改密码</div>
	<div>保存密码</div>
	<div class="menu-sep"></div>
	<div>告诉管理员</div>
</div>
<input id="cc" class="easyui-combobox" name="dept"   
    data-options="valueField:'id',textField:'text',url:'${pageContext.request.contextPath}/json/combobox.json'" />  

</body>
</html>