var usernameValid = false;

var user = {
	
	initPage:function(){
		$('input[type=image]').bind("click",user.formValidate);
		$("input[name='username']").bind("blur",function(){
			var username = $(this).val();
			user.checkUsername(username);
		});
	},
	
	formValidate:function(){
		
    	if($('select[name="departmentId"] option:selected').attr('value') == '-1'){
    		alert("请选择部门");
    		return false;
    	}
		
		var usernameElt = $("input[name='username']").get(0);
		var username = usernameElt.value;
		if(username.length == 0){
			alert("请输入用户名");
			return false;
		}
		
		var usernameReg = new RegExp("^[\\w\\d\\_]{6,30}$");
		if(!usernameReg.test(username)){
			alert("用户名至少输入6位，且只能由字母，数字，下划线组成");
			return false;
		}
		
		if(usernameValid == false){
			alert("用户名已经存在，请重新输入");
			return false;
		}
    	
    	if($('select[name="postIdList"] option:selected').size() == 0){
    		alert("请选择岗位，至少选择一项");
    		return false;
    	}
    	return true;
	},
	
	resetCheckUsername:function(){
		var usernameMsgElt = $("#usernameMsg");
		usernameMsgElt.text("");
		usernameValid = false;
	},
	
	checkUsername:function(username){
		
		console.log("username:"+username);
		var usernameReg = new RegExp("^[\\w\\d\\_]{6,30}$");
		
		var usernameMsgElt = $("#usernameMsg");
		
		if(!usernameReg.test(username)){
			user.resetCheckUsername();
			return false;
		}		
		
		var params = {
			"username":username
			};
			
		$.post("basedata/user/userAjaxAction_checkUserByUsername.action",params,function(data){
			console.log("data:"+data);
			
			if(data.errorMessage != null){
				user.resetCheckUsername();
				alert("请求数据失败："+data.errorMessage);
				return;
			}
			
			if(data.usernameValid){
				usernameValid = true;
				usernameMsgElt.text("用户名是唯一的");
				usernameMsgElt.css("color","blue");
			}else{
				usernameValid = false;
				usernameMsgElt.text("用户名已经存在，请重新输入");
				usernameMsgElt.css("color","red");
			}
		});
	},
	
	checkUsernameAjax:function(username){
		
		console.log("username:"+username);
		var usernameReg = new RegExp("^[\\w\\d\\_]{6,30}$");
		
		var usernameMsgElt = $("#usernameMsg");
		
		if(!usernameReg.test(username)){
			user.resetCheckUsername();
			return false;
		}		
		
		var params = {
			"username":username
			};
			
		$.ajax({
			type:"POST",
			url:"basedata/user/userAjaxAction_checkUserByUsername.action",
			data:params,
			success:function (data, textStatus) {
			    // data 可能是 xmlDoc, jsonObj, html, text, 等等...
				console.log("success post");
			    console.log("data:"+data);
				if(data.usernameValid){
					usernameValid = true;
					usernameMsgElt.text("用户名是唯一的");
					usernameMsgElt.css("color","blue");
				}else{
					usernameValid = false;
					usernameMsgElt.text("用户名已经存在，请重新输入");
					usernameMsgElt.css("color","red");
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
			    // 通常 textStatus 和 errorThrown 之中
			    // 只有一个会包含信息
				console.log("error happen");				
			    console.log("textStatus:"+textStatus);
				console.log("errorThrown:"+errorThrown);
				
				user.resetCheckUsername();
				alert("请求服务器时发生错误："+textStatus);
			}
			
		});
	}
	
};

$(document).ready(function(){
	user.initPage();
});
