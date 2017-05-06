(function($){
    $.useFckEditor = function(eleName){
		
		console.log("execute useFckEditor");
		
		var oFCKeditor = new FCKeditor(eleName) ;
		oFCKeditor.BasePath	= "fckeditor/" ;
		oFCKeditor.ReplaceTextarea() ;
		
    };
	
})(jQuery);
