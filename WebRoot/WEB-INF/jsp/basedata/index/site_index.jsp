<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../common/common_head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    
    <title>Itcast OA</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="../../../../common/common_script.jsp" %>
	
    <script type="text/javascript">
    </script>
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="basedata/index/indexAction_topPage.action" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="basedata/index/indexAction_leftPage.action" scrolling="yes" />
        <frame noresize name="right" src="basedata/index/indexAction_rightPage.action" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="basedata/index/indexAction_bottomPage.action" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
