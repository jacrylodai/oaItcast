<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../common/common_head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    
    <title>部门列表</title>
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
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>
        

		<!--显示数据列表-->
        <tbody id="TableData">
        
			<s:iterator value="#departmentList" var="department">
			
				<s:url action="departmentAction_deleteDepartment" 
					namespace="/basedata/department"
					var="deleteUrl">
					<s:param name="departmentId" value="#department.departmentId"></s:param>
				</s:url>
				
				<tr class="TableDetail1 template">
					<td><a href="_list_level2.html"><s:property value="#department.departmentName"/></a>&nbsp;</td>
					<td>&nbsp;</td>
					<td><s:property value="#department.departmentDesc"/>&nbsp;</td>
					<td>
						<!-- 
						<s:a href="%{#deleteUrl}">delete2</s:a>
						 -->
						<s:a action="departmentAction_deleteDepartment?departmentId=%{#department.departmentId}"  namespace="/basedata/department">删除</s:a>
						<s:a action="departmentAction_updatePrepareDepartment?departmentId=%{#department.departmentId}" namespace="/basedata/department">修改</s:a>
					</td>
				</tr>
			</s:iterator>
			
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="departmentAction_savePrepareDepartment" namespace="/basedata/department">
            	<img src="style/images/createNew.png" />
            	</s:a>
        </div>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>

</body>
</html>

