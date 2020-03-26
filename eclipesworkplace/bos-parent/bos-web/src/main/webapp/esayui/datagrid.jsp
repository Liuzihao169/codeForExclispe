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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid({    
	    url:'${pageContext.request.contextPath }/json/datagrid_data.json',    
	    columns:[[    
	        {field:'id',title:'编号',checkbox:true},    
	        {field:'age',title:'姓名'},    
	        {field:'address',title:'地址'}    
	    ]],
	    toolbar:[
	    		{text:'添加',iconCls:'icon-add',handler:function(){
	    			alert();
	    		}},
	    		{text:'删除',iconCls:'icon-remove'},
	    		{text:'修改',iconCls:'icon-edit'}
	            ],
	  pagination:true
	});  
})
</script>
<body>
  <table id="dg"></table> 
</body>
</html>