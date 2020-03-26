<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米6立即购买-小米商城</title>
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="./css/style2.css">
		<style type="text/css">
			#return a:hover{
			     color:green;
			     }
		</style>
		<script type="text/javascript">
	/* 当要获取页面标签的value的时候 可以用 jq/js获取 然后 在传到servlet */
			$(function(){
				$("#cart").click(function(){
					var buyNum=$("#buyNum").val();
					location.href="${pageContext.request.contextPath}/product?pid=${product.pid}&method=addProductToCart&buyNum="+buyNum;
				});
			});
			 function checkExit(){
					if(confirm("您是否要确认退出")){
						location.href="${pageContext.request.contextPath}/user?method=exituser"
					}
				}
		</script>
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<c:if test="${!empty user}"><div class="gouwuche fr"><a href="${pageContext.request.contextPath}/cart.jsp">购物车</a></div></c:if>
					<div class="fr">
					<c:if test="${empty user}">
						<ul>
								<li><a href="login.jsp">登陆</a></li>
								<li>|</li>
								<li><a href="">消息通知</a></li>
								</ul>
							</c:if>	
							<c:if test="${!empty user}">
							<ul>
								<li><a href=""> 欢迎..${user.username}</a></li>
								<li>|</li>
								<li><a href="">消息通知</a></li>
								<li>|</li>
								<li><a href="javascript:void(0)" onclick="checkExit()">退出登陆</a></li>
							</ul>
							</c:if>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	
	<!-- xiangqing -->
	<form action="post" method="">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">小米之家</div>
			<nav class="fr">
				<li><a href="">概述</a></li>
				<li>|</li>
				<li><a href="">变焦双摄</a></li>
				<li>|</li>
				<li><a href="">设计</a></li>
				<li>|</li>
				<li><a href="">参数</a></li>
				<li>|</li>
				<li><a href="">F码通道</a></li>
				<li>|</li>
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><img src="${pageContext.request.contextPath}/${product.pimage}"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20">${product.pname }</div>
			<div class="jianjie mr40 ml20 mt10">${product.pdesc}</div>
			<div class="jiage ml20 mt10">￥${product.price}</div>
			<div class="ft20 ml20 mt20">版本</div>
			<div class="xzbb ml20 mt10">
				<div class="banben fl">
					<a>
						<span>${product.pversion} </span>
					</a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ft20 ml20 mt20">颜色</div>
			<div class="xzbb ml20 mt10">
				<div class="banben">
					<a>
						<span class="yuandian"></span>
						<span class="yanse">亮黑色</span>
					</a>
				</div>
			</div>
			<div class="xqxq mt20 ml20">
				<div class="top1 mt10">
					<div class="clear"></div>
				</div>
				<div class="bot mt20 ft20 ftbc">
				购买数量: <input id="buyNum" name="buyNum" 
								maxlength="4" size="10" type="text" value="1">
				</div>
			</div>
			<div class="xiadan ml20 mt20">
					<input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
					<a id="cart" href="javascript:void(0)"><input class="jrgwc" type="button" name="jrgwc" value="加入购物车" /></a>
				<div id="return">
					 <a href="${pageContext.request.contextPath}/product?currentpage=${currentpage}&method=productlistbycid" >返回商品列表</a>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	</body>
</html>