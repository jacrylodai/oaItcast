<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../common/common_head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="../../../../common/common_script.jsp" %>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData">
        
        	<s:iterator value="#postList" var="post">
        	
				<tr class="TableDetail1 template">
					<td><s:property value="#post.postName"/>&nbsp;</td>
					<td><s:property value="#post.postDesc"/>&nbsp;</td>
					<td><s:a action="postAction_deletePost?postId=%{#post.postId}" namespace="/basedata/post">删除</s:a>
						<s:a action="postAction_updatePreparePost?postId=%{#post.postId}" namespace="/basedata/post">修改</s:a>
					</td>
				</tr>
				
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	<s:a action="postAction_savePreparePost" namespace="/basedata/post/">
        		<img src="style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>
</body>
</html>


