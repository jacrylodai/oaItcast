(function($){
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
