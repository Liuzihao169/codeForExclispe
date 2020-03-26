﻿ <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
/* 点击下一页 上一页  跳转到某一页  这三个点击都要提交表单 那么也就是 可以通过 js/jq获得参数 然后然后把参数 放到特定的
表单隐藏域 hidden当中  然后再使用js 提交表单*/
/* $(function(){
	  $("#currentPage option[value='${pb.currentCount}']").prop("selected",true);
	  alert($("#currentPage option:selected").val());
}); */

	
	function changepage(pagenum){
	
	    //获得值 然后传送  action的后面尽量不要用参数提交
		$("#currentPageInput").val(pagenum)	;
	    //获得currentPage的input 然后传入值进去  
	    $("#currentCountInput").val($("#currentPage option:selected").val())
	     
		$("#customerForm").submit();
	   /*  $("#currentPage option[value='${pb.currentCount}']").prop("selected",true);
	    alert(1) */
	}


/*
$(fnction{
	  $("#currentPage option[value='${pb.currentCount}']").prop("selected",true);
	  alert(${pb.currentCount});
})
	
	/*   $("#cid option[value='${product.category.cid}']").prop("selected",true);*/
	function checkCustomer(cust_id,cust_name){
		//获得添加页面的window对象
		var win=window.opener;
		//获得页面的document对象
		var doc=win.document;
		doc.getElementById("cust_id").value=cust_id;
		doc.getElementById("cust_name").value=cust_name;
		window.close();
	}

</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/CusAction_list"
		method=post>
		<!-- 隐藏域 用来传数据到action去 ，这样不用再链接后面加参数 更加便捷-->
		<!-- 用于传当前页  -->
		<input type="hidden" name="currentPage" id="currentPageInput">
		<input type="hidden" name="currentCount" id="currentCountInput">
		<%-- 前台没有字段接收的属性 存储在parameters当中value="<s:property value='#parameters.selected'/>"--%>
		<input type="hidden" name="selected" value="${param.selected}" >
	
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
									 	 			<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="cust_name" value="<s:property value='cust_name'/>"></TD>
													<TD><INPUT class=button id=sButton2 type="submit"
														value="筛选 " ></TD>
												</TR>
											</TBODY>
										</TABLE>
										</FORM>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>联系人</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${pb.list}" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${customer.cust_name }</TD>
													<TD>${customer.cust_level.dict_item_name}</TD>
													<TD>${customer.cust_source.dict_item_name}</TD>
													<TD>${customer.cust_linkman }</TD>
													<TD>${customer.cust_phone }</TD>
													<TD>${customer.cust_mobile }</TD>
													<TD>
													<%--采用actionContext 中的取值方法 判断是否存在阐述 如果不存在 那么就正常显示
													如果存在参数 那就显示选择的样式   #parameters.selected==null
													 --%>
													<s:if test="#parameters.selected==null">
													<a href="${pageContext.request.contextPath }/CusAction_toEdit?cust_id=${customer.cust_id}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/customerServlet?method=delete&custId=${customer.cust_id}">删除</a>
													</s:if>
													<s:else>
														<input type="button" value="选择" onclick="checkCustomer(${customer.cust_id },'${customer.cust_name }')">
													</s:else>
													</TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${pb.totalCount}</B>]条记录,[<B>${pb.totalPage}</B>]页
												,每页显示
												<select name="totalCount" id="currentPage">
												<c:forEach begin="1" end="${pb.totalCount}" var="vars">
													<option value="${vars}" ${vars==pb.currentCount?"selected":""} >${vars}</option>
												</c:forEach>
											<%-- 	<option value="15" <c:if test="${pageSize==1 }">selected</c:if>>1</option>
												<option value="30" <c:if test="${pageSize==30 }">selected</c:if>>30</option> --%>
												</select>
												<span><s:property value="#pb.totalPage"/></span>
												页
												[<A href="javascript:void(0)" onclick="changepage(<s:property value="#pb.currentPage-1"/>)">前一页</A>]
												<B><s:property value="#pb.currentPage"/></B>
												[<A href="javascript:void(0)" onclick="changepage(<s:property value="#pb.currentPage+1"/>)">后一页</A>] 
												到
												<input type="text" size="3" id="page" name="page" value='<s:property value="#pb.currentPage"/>'/>
												页
												<input type="button" value="Go" onclick="changepage($('#page').val())"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	<s:debug></s:debug>
</BODY>
</HTML>
