﻿<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$.ajax({
		url:"<%=request.getContextPath()%>/foodServlet?method=getList",
		type:"post",
		//data:"",
		dataType:"json",
		success:function(obj){
			
			for(var i in obj){
				$("#TableData").append("<tr class='TableDetail1'><td>"+obj[i].fid+"</td><td>"+obj[i].fname+"</td><td>"+obj[i].cname+"</td><td>"+obj[i].price+"</td><td>"+obj[i].vipprice+"</td><td><a href='updateFood.html' class='FunctionButton'>更新</a><a class='FunctionButton' onClick='return delConfirm();' href='/wirelessplatform/food.html?method=delete&id=1'>删除</a></td></tr>");
			}
			
		}
		
	});})
</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 菜品列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/food.html" method="get">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="keyword" title="请输入菜品名称"> <input
				type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜编号</td>
					<td>菜名</td>
					<td>所属菜系</td>
					<td>价格</td>
					<td>会员价格</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">

				<tr class="TableDetail1">
					<td>1&nbsp;</td>
					<td>白灼虾&nbsp;</td>
					<td>粤菜&nbsp;</td>
					<td>36.0&nbsp;</td>
					<td>23.0&nbsp;</td>
					<td><a href="updateFood.html" class="FunctionButton">更新</a> <a
						href='/wirelessplatform/food.html?method=delete&id=1'
						onClick='return delConfirm();' class='FunctionButton'>删除</a></td>
				</tr>


			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="saveFood.html">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
