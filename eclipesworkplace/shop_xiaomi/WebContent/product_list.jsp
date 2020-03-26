<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/style2.css">
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
function checkExit(){
	if(confirm("您是否要确认退出")){
		location.href="${pageContext.request.contextPath}/user?method=exituser"
	}
}
</script>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>
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
					<div class="gouwuche fr"><a href="/cart.jsp">购物车</a></div>
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
<body>
	<div class="row" style="width: 1210px; margin: 0 auto;">
			<div style="margin-top: 0px">
		<div class="banner_x center">
			<div class="nav fl">
				<ul><li><a href="" style=" margin-right: 10px"><img src="img/logo.png"></a></li>
					<li><a href="./liebiao.html" target="_blank">小米手机</a></li>
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
		<!-- 	<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="....搜索">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
			</div> -->
		</div>
		</div>
		<c:forEach items="${pageBean.productlistbycid}" var="pro">
			<div class="col-md-2">
				<a href="${pageContext.request.contextPath}/product?pid=${pro.pid}&currentpage=${pageBean.currentpage}&method=productinfo"><img src="${pageContext.request.contextPath}/${pro.pimage}"
						width="170" height="170" style="display: inline-block;">
				</a>
				<p>
					<a href="${pageContext.request.contextPath}/product?pid=${pro.pid}&currentpage=${pageBean.currentpage}&method=productinfo" style='color: green'>${pro.pname}</a>
				</p>
				<p>
					<font color="#FF0000">商城价：&yen;${pro.price}</font>
				</p>
			</div>
		</c:forEach>
		 <%--  <c:forEach items="${pageBean.productlistbycid}" var="pro">
            	<div class="col-md-2" style="height:250px">
					<a href="${pageContext.request.contextPath}/product?pid=${pro.pid}&cid=${cid}&currentpage=${pageBean.currentpage}&method=productinfo"> <img src="${pageContext.request.contextPath}/${pro.pimage}"
						width="170" height="170" style="display: inline-block;">
					</a>
					<p>
						<a href="${pageContext.request.contextPath}/product?pid=${pro.pid}&cid=${cid}&currentpage=${pageBean.currentpage}&method=productinfo">${pro.pname}</a>
					</p>
					<p>
						<font color="#FF0000">商城价：&yen;${pro.shop_price}</font>
					</p>
			  </div> --%>
	            
    
	<!--分页 -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
			<!-- <li class="disabled"><a href="#" aria-label="Previous"><span
					aria-hidden="true">&laquo;</span></a></li>
			<li class="active"><a href="#">1</a></li> -->
		 <c:if test="${pageBean.currentpage==1}">
			<li class="disabled"><a href="javascript:void(0)" aria-label="Previous"><span
					aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:if test="${pageBean.currentpage!=1}">
			<li ><a href="${pageContext.request.contextPath}/product?currentpage=${pageBean.currentpage-1}&method=productlistbycid" 
			aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>	
		 <!-- 如果当前页是正好page这一页 那么显示被选中的状态并且是不能再点击的 -->
		<c:forEach begin="1" end="${pageBean.totalpage}" var="page">
			<c:if test="${pageBean.currentpage==page}">
				<li class="active"><a href="javascript:void(0)">${page}</a></li>
			</c:if>
			<c:if test="${pageBean.currentpage!=page}">
				<li ><a href="${pageContext.request.contextPath}/product?currentpage=${page}&method=productlistbycid">${page}</a></li>
			</c:if>
			<!-- <li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li> -->
		     	</c:forEach>
		     <c:if test="${pageBean.currentpage==pageBean.totalpage}">
		     	<li class="disabled"><a href="javascript:void(0)" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		     	</c:if>
		     	<c:if test="${pageBean.currentpage!=pageBean.totalpage}">
		     	<li><a href="${pageContext.request.contextPath}/product?currentpage=${pageBean.currentpage+1}&method=productlistbycid" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		     	</c:if> 
		</ul>
	</div>
	<!-- 分页结束 -->

	<!--商品的浏览记录-->
		<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
			<c:forEach items="${historyproductlsit}" var="pro">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="${pageContext.request.contextPath}/${pro.pimage}" width="130px" height="130px" /></li>
					</c:forEach>
			</ul>
		</div>
	</div>
	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>