<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test_menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  <link rel="stylesheet" href="style/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="script/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="script/jquery-ztree-2.5.js"></script>
	<script type="text/javascript" src="script/other/js_test_menu_click.js"></script>

  </head>
  
  <body>
    This is my JSP page. <br>
	<div>
		<ul id="tree" class="tree" style="width:230px; overflow:auto;"></ul>
	</div>
  </body>
</html>
