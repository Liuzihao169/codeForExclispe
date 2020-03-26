<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>我的购物车-小米商城</title>
		<link rel="stylesheet" type="text/css" href="./css/style2.css">
		<script type="text/javascript">
		function checkDel(pid){
			if(confirm("是否确定要删除该商品")){
				location.href="${pageContext.request.contextPath}/product?method=delItemFromCart&pid="+pid;
			}
		}
		</script>
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						序号
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div> 
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
					<c:forEach items="${cart.cartmap}" var="items" varStatus="vs">
						<div class="content2 center">
							<div class="sub_content fl ">
							${vs.count}
							</div>
							<div class="sub_content fl"><img src="${pageContext.request.contextPath}/${items.value.product.pimage}" width="70" height="60"></div>
							<div class="sub_content fl ft20">${items.value.product.pversion }</div>
							<div class="sub_content fl ">${items.value.product.price}</div>
							<div class="sub_content fl">
							  ${items.value.buyNum}
							</div>
							<div class="sub_content fl">${items.value.tatalsub}</div>
							<div class="sub_content fl"><a href="javascript:"  onclick="checkDel('${items.value.product.pid}')">×</a></div>
							<div class="clear"></div>
						</div>
					</c:forEach>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="${pageContext.request.contextPath}/index.jsp">继续购物</a></li>
						<li>|</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>${cart.total}元</span></div>
					<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
	</body>
</html>
