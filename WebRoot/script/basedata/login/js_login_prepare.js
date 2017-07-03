function validateInput(){

    var $username = $("input[name='username']")[0];
	var username = $username.val();
    if (isEmpty(username)) {
        alert("用户名不能为空");
        return false;
    }
    return true;
}


$().ready(function(){

    $("#submitImage").unbind("click");
    $("#submitImage").bind("click", function(){
    
        if (validateInput()) {
            console.log("validate success");
            
            var $loginForm = $("form[name='loginForm']")[0];
            $loginForm.submit();
        }
        return false;
    });
    
});
