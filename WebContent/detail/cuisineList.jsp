<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
function to_delete(cid){
	location.href="<%=request.getContextPath()%>/cuisineServlet?method=delete&cid="+cid;
}
function to_update(cid){
	location.href="updateCuisine.html?cid="+cid;
}
$(function(){
	
	$.ajax({
		url:"<%=request.getContextPath()%>/cuisineServlet?method=getList",
		type:"post",
		//data:"",
		dataType:"json",
		success:function(obj){
			
			for(var i in obj){
// 				return delConfirm();
				$("#TableData").append("<tr class='TableDetail1'><td>"+obj[i].cid+"</td><td>"+obj[i].cname+"</td><td><a onClick='to_update("+obj[i].cid+")' class='FunctionButton'>更新</a><a class='FunctionButton' onClick='to_delete("+obj[i].cid+")' >删除</a></td></tr>");
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
					src="style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/cuisine.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜系名称">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				
					
				
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="saveCuisine.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
