<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js" ></script>
<script type="text/javascript">
                /*    $("#is_hot option[value='${product.is_hot}']").prop("selected",true);*/
    function addselectbymethod(typecode,positionid,name,selectvalue){
    	//构建一个select对象
    
    	var $select=$("<select name="+name+"></select>");
		var $option=$("<option>------请选择-------</option>");
		 $select.append($option);
    
                
		//往select添加option首选项
		//ajax加载获得数据 
			$.post(
					"${pageContext.request.contextPath}/Basedict",
					{"dict_type_code":typecode},
					function(data){
						for(var i=0;i<data.length;i++){
							var $options=$("<option value='"+data[i].dict_id+"'}>"+data[i].dict_item_name+"</option>");
							if(data[i].dict_id==selectvalue){
								$options.attr("selected",true)
							}
							 $select.append($options);
					
					}
						 $("#"+positionid).append($select);
                }
					,"json"
					);
			
		}
		/* $.post(
				"${pageContext.request.contextPath}/Basedict",
				{"dict_type_code":typecode},
				function(data){
					for(var i=0;i<data.length;i++){
						var $options=$("<option value='"+data[i].dict_id+"'}>"+data[i].dict_item_name+"</option>");
						//如果需要被回显示
						if(data[i].dict_id==selectvalue){
							$options.attr("selected",true)
						}
						 $select.append($options);
				}	
						
					 $("#"+positionid).append($select);
				}
				,"json"		//解析数据 动态添加
                }    */       
/* 	$(function(){
		 addselect("009","source","cust_source.dict_id");
		 addselect("006","level","cust_level.dict_id");
		 $("#level option[value='${customer.cust_level.dict_id}']").prop("selected",true);
 		 alert(${customer.cust_level.dict_id})
		 	
		 //属性选择器无效果
		
	}); */
	$(function(){
		alert(${customer.cust_industry.dict_id});
		 addselectbymethod("009","source","cust_source.dict_id",${customer.cust_source.dict_id});
		 addselectbymethod("006","level","cust_level.dict_id",${customer.cust_level.dict_id});
		 addselectbymethod("001","industry","cust_industry.dict_id",${customer.cust_industry.dict_id});
	});
              
	
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath}/CusAction_add"
		method=post>
		<input type="hidden" name="cust_id" value="${customer.cust_id}"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
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
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
											style="WIDTH: 180px" maxLength=50 name="cust_name" value="${customer.cust_name }">
								</td>
								<td>客户级别 ：</td>
								<td id="level">
								
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td id="source">
							
								</td>
								<td >所属行业：</td>
								<td id="industry">
								
								</td>
							</TR>
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${customer.cust_phone }">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${customer.cust_mobile }">
								</td>
							</TR>
														<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
	</FORM>
</BODY>
</HTML>
