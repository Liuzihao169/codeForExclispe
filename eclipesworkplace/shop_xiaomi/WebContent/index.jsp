<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>小米商城</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style2.css">
		<script type="text/javascript">
		 function checkExit(){
				if(confirm("您是否要确认退出")){
					location.href="${pageContext.request.contextPath}/user?method=exituser"
				}
			}
		</script>
	</head>
	<body>
	<!-- start header -->
<%-- 	<jsp:include page="/header.jsp"></jsp:include> --%>
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
		<div style="margin-top: 0px">
		<div class="banner_x center">
			<div class="nav fl">
				<ul><li><a href="" style=" margin-right: 10px"><img src="img/logo.png"></a></li>
					<li><a href="${pageContext.request.contextPath}/product?method=productlistbycid" target="">小米手机</a></li>
					<li><a href="#">红米</a></li>
					<li><a href="#">平板·笔记本</a></li>
					<li><a href="#">电视</a></li>
					<li><a href="#">盒子·影音</a></li>
					<li><a href="#">路由器</a></li>
					<li><a href="#">智能硬件</a></li>
					<li><a href="#">服务</a></li>
					<li><a href="#">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="....搜索">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
			</div>
		</div>
		</div>
		<!-- 轮播图 -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- 轮播图的中的小点 -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- 轮播图的轮播图片 -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="img/1.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="img/2.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="img/3.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
					</div>
	              <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
<!-- end banner_x -->
<div class="clear"></div>
			
		<div class="sub_banner center">
			<div class="sidebar fl">
				<div class="fl"><a href=""><img src="./image/hjh_01.gif"></a></div>
				<div class="fl"><a href=""><img src="./image/hjh_02.gif"></a></div>
				<div class="fl"><a href=""><img src="./image/hjh_03.gif"></a></div>
				<div class="fl"><a href=""><img src="./image/hjh_04.gif"></a></div>
				<div class="fl"><a href=""><img src="./image/hjh_05.gif"></a></div>
				<div class="fl"><a href=""><img src="./image/hjh_06.gif"></a></div>
				<div class="clear"></div>
			</div>
			<div class="datu fl"><a href=""><img src="./image/hongmi4x.png" alt=""></a></div>
			<div class="datu fl"><a href=""><img src="./image/xiaomi5.jpg" alt=""></a></div>
			<div class="datu fr"><a href=""><img src="./image/pinghengche.jpg" alt=""></a></div>
			<div class="clear"></div>


		</div>
	
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
	</body>
</html>