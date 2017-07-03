
var menu = {
    setting: {
        isSimpleData: true,
        treeNodeKey: "menuId",
        treeNodeParentKey: "pid",
        nameCol: "menuName",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    },
    
    loadMenu: function(){
        $.post("basedata/menuItem/menuItemAction_listCurrUserMenuItemList.action", null, function(data){
            $("#tree").zTree(menu.setting, data.menuItemList);
        });
    }
};

$().ready(function(){
    menu.loadMenu();
});

