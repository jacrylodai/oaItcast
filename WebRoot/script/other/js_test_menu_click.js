var menu={
	
	zTreePlugin:null,
	
	setting:{
		async:true,
		isSimpleData: true,
		treeNodeKey: "menuId",
		treeNodeParentKey: "pid",
		nameCol:"menuName",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		},
		callback:{
			expand:function(event, treeId, treeNode){
				menu.loadSubMenu(treeNode);
			}
		}
	},
	
	loadRootMenu:function(){
		var params = {
			pid:0
		}
		$.post("basedata/menuItem/menuItemAction_listMenuItemListByPid.action",params,function(data){
			menu.zTreePlugin = $("#tree").zTree(menu.setting,data.menuItemList);
		});
	},
	loadSubMenu:function(treeNode){
		
		if(treeNode.isLoadSubMenu != null && treeNode.isLoadSubMenu == true){
			return;
		}
		
		var params = {
			pid:treeNode.menuId
		}
		$.post("basedata/menuItem/menuItemAction_listMenuItemListByPid.action",params,function(data){
			menu.zTreePlugin.addNodes(treeNode, data.menuItemList, true);
			treeNode.isLoadSubMenu = true;
		});
	}
};

$().ready(function(){
	menu.loadRootMenu();	
});

