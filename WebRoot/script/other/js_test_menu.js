var setting = {
	isSimpleData: true,
	treeNodeKey: "menuId",
	treeNodeParentKey: "pid",
	nameCol:"menuName",
	showLine: true,
	root:{ 
		isRoot:true,
		nodes:[]
	}
};
	
var menu={
	loadMenu:function(){
		$.post("basedata/menuItem/menuItemAction_getAllMenuItem.action",null,function(data){
			$("#tree").zTree(setting,data.menuItemList);
		});
	}
};

$().ready(function(){
	menu.loadMenu();	
});

