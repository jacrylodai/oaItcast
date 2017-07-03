(function($){
    $.fn.addDeleteMessage = function(options){
        var defaults = {
            'message': '你确定要删除吗？',
        };
        var settings = $.extend({}, defaults, options);//将一个空对象做为第一个参数
        
		console.log("execute addDeleteMessage");
		
		this.each(function(){
			$domEle = $(this);
			var domText = $domEle.text();
			if(domText == "删除"){
				$domEle.unbind("click");
				$domEle.bind("click",function(){
					return window.confirm(settings.message);
				});
			}
		});
		
		return this;
    };
	
	$.fn.addCheckAllFunc = function(eleName){
		
		console.log("execute addCheckAllFunc");
		
		this.each(function(){
			$domEle = $(this);
			
			var isChecked = $domEle.attr("checked");
			console.log("isChecked:"+isChecked);
			
			$("input[type='checkbox'][name='"+eleName+"']").attr(
				"checked",isChecked);
		});
		
		return this;
    };
	
})(jQuery);
