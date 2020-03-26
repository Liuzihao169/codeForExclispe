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
<script type="text/javascript">
	$(function() {
		$("#myadd").click(function() {
			var e = $('#mytab').tabs('exists', '系统管理');
			if (e) {
				$('#mytab').tabs('select', '系统管理');
			} else {
				$('#mytab').tabs('add', {
					title : '系统管理',
					content : '这是我添加的选项卡',
					closable : true
				})
			}
		});
		//创建ztree;
		var setting = {};
		//创建节点
		ztreeNodes = [ {
			"name" : "节点1",
			"children" : [ {
				"name" : "1.1"
			}, {
				"name" : "1.2"
			} ]
		}, {
			"name" : "节点2"
		}, {
			"name" : "节点3"
		} ];
		//初始化树
		$.fn.zTree.init($("#mytree"), setting, ztreeNodes);
		var setting2 = {
			//使用简单json数据格式来构造节点
			data : {
				simpleData : {
					enable : true
				}
			},
			callback : {
				//为ztree绑定单击事件
				onClick : function(event, treeId, treeNode) {
					//动态添加选项卡
					//判断如果是根节点 那么 就添加选项卡
					alert(treeNode.page);
					//如果page 不存在 那么就是现undefined
					if (treeNode.page != undefined) {
						var e = $('#mytab').tabs('exists', treeNode.name);
						if (e) {
							$('#mytab').tabs('select', treeNode.name);
						} else {
							$('#mytab')
									.tabs(
											'add',
											{
												title : treeNode.name,
												content : '<iframe width="100%" height="100%" frameborder="0" src="http://www.baidu.com"></iframe>',
												closable : true
											});
						}
					}
				}
			}
		};
		var nodes = [ {
			id : 1,
			pId : 0,
			name : "父节点1"
		}, {
			id : 11,
			pId : 1,
			name : "子节点1"
		}, {
			id : 12,
			pId : 1,
			name : "子节点2"
		} ];
		//初始化树
		$.fn.zTree.init($("#mytree2"), setting2, nodes);
		//利用ajax来获取数据然后加载出菜单栏
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/json/menu.json',
			success : function(data) {
				$.fn.zTree.init($("#mytree3"), setting2, data);
			},
			dataType : 'json'
		})
	});
</script>
</head>
<body class="easyui-layout">
	<!-- 使用div元素描述每个区域 -->

	<div title="牛逼的管理系统VS1.0" style="height: 100px"
		data-options="region:'north'">北部区域</div>
	<div title="系统菜单" style="width: 200px" data-options="region:'west'">
		<!-- 制作accordion折叠面板 
			fit:true----自适应(填充父容器)
		-->
		<div class="easyui-accordion" data-options="fit:true">
			<!-- 使用子div表示每个面板 -->
			<div data-options="iconCls:'icon-cut'" title="面板一">
				<a id="myadd" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">添加一个选项卡</a>
			</div>
			<div title="面板二">
				<ul class="ztree" id="mytree">

				</ul>
			</div>
			<div title="面板三">
				<ul class="ztree" id="mytree2">

				</ul>
			</div>
			<div title="面板四">
				<ul class="ztree" id="mytree3">

				</ul>
			</div>
		</div>

	</div>
	<div data-options="region:'center'">
		<!-- 制作一个tabs选项卡面板 -->
		<div id="mytab" class="easyui-tabs" data-options="fit:true">
			<!-- 使用子div表示每个面板 -->
			<div data-options="iconCls:'icon-cut'" title="面板一"></div>
			<div data-options="closable:true" title="面板二">2222</div>
			<div title="面板三">3333</div>
		</div>
	</div>
	<div style="width: 100px" data-options="region:'east',split:true">东部区域</div>
	<div style="height: 50px" data-options="region:'south'">南部区域</div>
</body>
</html>