<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../common/common_head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="../../../../common/common_script.jsp" %>
	<script language="javascript" src="script/jquery-ztree-2.5.js"></script>
	<script language="javascript" src="script/basedata/user/js_list_user.js"></script>
	<script language="javascript" src="script/basedata/user/js_privilege.js"></script>
	
  	<link rel="stylesheet" href="style/zTreeStyle/zTreeStyle.css" type="text/css">
	
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td><input type="checkbox" name="selectAll" id="selectAllCB"/></td>
                <td width="100">用户名</td>
                <td width="100">所属部门</td>
                <td>岗位</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData">
        	<s:iterator value="top">
	            <tr class="TableDetail1 template">
	            	<s:hidden name="userId"
	            		value="%{userId}"></s:hidden>
	            	<td>
	            	<input type="checkbox" name="itemCheck" 
	            		value="<s:property value='userId'/>"/>
	            		</td>
	                <td><s:property value="username"/></td>
	                <td><s:property value="department.departmentName"/>&nbsp;</td>
	                <td>
	                	<s:iterator value="postSet">
	                		<s:property value="postName"/>
	                	</s:iterator>
	                </td>
	                <td><a onClick="return delConfirm()" href="list.html">删除</a>
	                    <a href="saveUI.html">修改</a>
	                    <a name="setPrivilege" href="#">设置权限</a>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
    
     <div id="TableTail">
        <div id="TableTail_inside">
        	<s:a action="userAction_savePrepareUser" namespace="/basedata/user">
        	<img src="style/images/createNew.png" />
        	</s:a>
        </div>
    </div>
    
    <div class="ItemBlock_Title1" id="userTitle" style="display: none;"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif"/>
        	用户:<span id="usernameElt"></span>
        	<div id="userImage"></div>
        </div>
    <div class="ItemBlock_Title1" id="privilegeTitle" style="display: none;"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" />选择权限</div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder" style="display: none;" id="privilegeContent">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="checkbox" id="checkAllElt"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<ul id='privilegeTree' class="tree">
							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <image id="savePrivilege" src="style/images/save.png"/>
        </div>
</div>

</body>
</html>


