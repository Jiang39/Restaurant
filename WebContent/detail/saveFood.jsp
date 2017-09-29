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
$(function(){
	
	$.ajax({
		url:"<%=request.getContextPath()%>/cuisineServlet?method=getList",
		type:"post",
		//data:"",
		dataType:"json",
		success:function(obj){
			for(var i in obj){
// 				$("#cid").append("<tr class='TableDetail1'><td>"+obj[i].fid+"</td><td>"+obj[i].fname+"</td><td>"+obj[i].cname+"</td><td>"+obj[i].price+"</td><td>"+obj[i].vipprice+"</td><td><a href='updateFood.html' class='FunctionButton'>更新</a><a class='FunctionButton' onClick='return delConfirm();' href='/wirelessplatform/food.html?method=delete&id=1'>删除</a></td></tr>");
				$("#cid").append("<option value="+obj[i].cid+" >"+obj[i].cname+"</option>")
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
					<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 添加新菜品
		</div>
    </div>	
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="<%=request.getContextPath() %>/foodServlet" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
							<td width="80px">菜系</td>
							<td>
                            <select name="cid" id="cid" style="width:80px">
                            </select>
                             *
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="fname" class="InputStyle" /> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="price" class="InputStyle" value=""/> *</td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><input type="text" name="vipprice" class="InputStyle" value=""/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="introduce" class="TextareaStyle"></textarea></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								
								<input type="file" name="imgurl"/> *
								<input type="hidden" name="url" value="aaaa">
								<input type="hidden" name="method" value="insert">
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
				
					 <input type="submit" value="添加" class="FunctionButtonInput">
				
			
            
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
</html>
