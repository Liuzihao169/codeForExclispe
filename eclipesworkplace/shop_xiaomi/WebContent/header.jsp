<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/style2.css">
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
					<div class="gouwuche fr"><a href="gouwuche.jsp">购物车</a></div>
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