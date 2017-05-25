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
	
	checkUsername:function(username){
		
		console.log("username:"+username);
		var usernameReg = new RegExp("^[\\w\\d\\_]{6,30}$");
		if(!usernameReg.test(username)){
			return false;
		}
		
		var usernameMsgElt = $("#usernameMsg");
		
		var params = {
			"username":username
			};
			
		$.post("basedata/user/userAjaxAction_checkUserByUsername.action",params,function(data){
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
		});
	}
	
};

$(document).ready(function(){
	user.initPage();
});
