var common = {
	
	myconfig:function(message){
		return window.confirm(message);
	}
};

$(document).ready(function() {
	
	$('a').each(function(index) {
	  
	  if( $(this).text() == "删除" ){
	  	
	  	$(this).unbind('click');
	  	$(this).bind('click', function(event) {
			return common.myconfig("你确定要删除吗？");
		  });
	  }
	});
});

