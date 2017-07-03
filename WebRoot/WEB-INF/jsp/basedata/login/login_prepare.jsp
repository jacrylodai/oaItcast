<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../common/common_head.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    
    <title>Itcast OA</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@ include file="../../../../common/common_script.jsp" %>
	<script language="javascript" src="script/client_validate.js"></script>
	<script language="javascript" src="script/basedata/login/js_login_prepare.js"></script>
	
  	<link rel="stylesheet" href="style/blue/login.css" type="text/css">
  	
    <script type="text/javascript">
    </script>
</head>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form name="loginForm" action="loginAction_validateLogin"
	 namespace="/basedata/login" method="post">
	 
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="style/blue/images/logo.png" /></DIV>
            <DIV ID="LoginInfo">
            
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/userId.gif" /></TD>
                        <TD>
                        <s:textfield name="username" cssClass="TextField"></s:textfield></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/password.gif" /></TD>
                        <TD>
                        <s:password name="password" cssClass="TextField"></s:password></TD>
                    </TR>
                    <TR>
                        <TD colspan="2" STYLE="padding-left:90px;">
                        	<INPUT id="submitImage" TYPE="image" SRC="style/blue/images/login/userLogin_button.gif"
                        		/></TD>
                    </TR>
                </TABLE>
                
  				<s:actionerror/>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2010 版权所有 itcast</A></DIV>
        </DIV>
    </DIV>
</s:form>
</BODY>

</html>




