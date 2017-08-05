var menu = {

    zTreePlugin: null,
    
    currKynaItem: null,
    
    setting: {
        async: true,
        isSimpleData: true,
        treeNodeKey: "kynamicId",
        treeNodeParentKey: "pid",
        nameCol: "kynamicName",
        showLine: true,
		keepParent:true,
        root: {
            isRoot: true,
            nodes: []
        },
        callback: {
            expand: function(event, treeId, treeNode){
            
                console.log("expand Node");
                menu.loadSubMenu(treeNode);
            },
            rightClick: function(event, treeId, treeNode){
            
                console.log("tree right click");
                var rightMenuJson = new Object();
                if (treeNode.isParent) {
                    rightMenuJson.isAddFolder = true;
                    rightMenuJson.isAddNode = true;
                    rightMenuJson.isUpdateNode = true;
                    rightMenuJson.isDeleteNode = true;
                }
                else {
                    rightMenuJson.isAddFolder = false;
                    rightMenuJson.isAddNode = false;
                    rightMenuJson.isUpdateNode = true;
                    rightMenuJson.isDeleteNode = true;
                }
                rightMenuJson.positionX = event.clientX;
                rightMenuJson.positionY = event.clientY;
                
                rightMenuJson.treeNode = treeNode;
                
                menu.controlRightMenu(rightMenuJson);
            }
        }
    },
    
    initEvent: function(){
    
        $("#rMenu").bind("mouseleave", function(){
            console.log("menu onmouseleave");
            $(this).hide();
        });
        
        $("#addFolder").bind("click", function(){
        
            console.log("addFolder click");
            
            $("#rMenu").hide("fast", function(){
                menu.addFolderAjax();
            })
            
        });
		
		$("#addNode").bind("click", function(){
        
            console.log("addNode click");
            
            $("#rMenu").hide("fast", function(){
                menu.addNodeAjax();
            })
            
        });
		
		$("#deleteNode").bind("click", function(){
        
            console.log("deleteNode click");
            
            $("#rMenu").hide("fast", function(){
                menu.deleteNodeAjax();
            })
            
        });
		
		$("#updateNode").bind("click", function(){
        
            console.log("updateNode click");
            
            $("#rMenu").hide("fast", function(){
                menu.updateNodeAjax();
            })
            
        });
    },
    
    loadRootMenu: function(){
    
        console.log("loadRootMenu");
        var params = {
            pid: 0
        }
        $.post("resource/kynamic/kynamicAction_listKynamicListByPid.action", params, function(data){
            menu.zTreePlugin = $("#kynamicTree").zTree(menu.setting, data.kynamicList);
        });
    },
    loadSubMenu: function(treeNode){
    
        console.log("loadSubMenu");
        if (treeNode.isLoadSubMenu != null && treeNode.isLoadSubMenu == true) {
            return;
        }
        
        var params = {
            pid: treeNode.kynamicId
        }
        $.post("resource/kynamic/kynamicAction_listKynamicListByPid.action", params, function(data){
            menu.zTreePlugin.addNodes(treeNode, data.kynamicList, false);
            treeNode.isLoadSubMenu = true;
        });
    },
    /**
     * 控制右键菜单显示
     * @param {Object} rightMenuJson
     */
    controlRightMenu: function(rightMenuJson){
    
        console.log("controlRightMenu");
        $("#rMenu").show();
        if (rightMenuJson.isAddFolder) {
            $("#addFolder").show();
        }
        else {
            $("#addFolder").hide();
        }
        
        if (rightMenuJson.isAddNode) {
            $("#addNode").show();
        }
        else {
            $("#addNode").hide();
        }
        
        if (rightMenuJson.isUpdateNode) {
            $("#updateNode").show();
        }
        else {
            $("#updateNode").hide();
        }
        
        if (rightMenuJson.isDeleteNode) {
            $("#deleteNode").show();
        }
        else {
            $("#deleteNode").hide();
        }
        
        $("#rMenu").css("position", "absolute");
        $("#rMenu").css("left", rightMenuJson.positionX + "px");
        $("#rMenu").css("top", rightMenuJson.positionY + "px");
        
        menu.currKynaItem = rightMenuJson.treeNode;
    },
    
    hideRightMenu: function(){
        $("#rMenu").hide();
    },
    
    addFolderAjax: function(){
    
        console.log("addFolderAjax");
        var folderName = window.prompt("请输入目录名称");
		//点击取消时为null
		if(fileName == null){
			return;
		}
        if (isEmpty(fileName)) {
            alert("文件名称不能为空");
            return;
        };
        
        var params = {
            'pid': menu.currKynaItem.kynamicId,
            'kynamicName': folderName,
            'isParent': true
        };
        
        $.ajax({
            type: "POST",
            url: "resource/kynamic/kynamicAction_saveKynamic.action",
            data: params,
            success: function(data, textStatus){
                // data 可能是 xmlDoc, jsonObj, html, text, 等等...
                console.log("ajax success");
                var treeNode = menu.currKynaItem
                if (treeNode.isLoadSubMenu != null && treeNode.isLoadSubMenu == true) {
                    menu.zTreePlugin.addNodes(treeNode, data.modifyKynamic, false);
                }
                else {
                    menu.loadSubMenu(treeNode);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                // 通常 textStatus 和 errorThrown 之中
                // 只有一个会包含信息
                console.log("ajax error");
                alert("请求服务器时发生错误：" + textStatus);
            }
        });
    },
	
	addNodeAjax: function(){
    
        console.log("addNodeAjax");
        var fileName = window.prompt("请输入文件名称");
		//点击取消时为null
		if(fileName == null){
			return;
		}
		
        if (isEmpty(fileName)) {
            alert("文件名称不能为空");
            return;
        };
        
        var params = {
            'pid': menu.currKynaItem.kynamicId,
            'kynamicName': fileName,
            'isParent': false
        };
        
        $.ajax({
            type: "POST",
            url: "resource/kynamic/kynamicAction_saveKynamic.action",
            data: params,
            success: function(data, textStatus){
                // data 可能是 xmlDoc, jsonObj, html, text, 等等...
                console.log("ajax success");
                var treeNode = menu.currKynaItem
                if (treeNode.isLoadSubMenu != null && treeNode.isLoadSubMenu == true) {
                    menu.zTreePlugin.addNodes(treeNode, data.modifyKynamic, false);
                }
                else {
                    menu.loadSubMenu(treeNode);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                // 通常 textStatus 和 errorThrown 之中
                // 只有一个会包含信息
                console.log("ajax error");
                alert("请求服务器时发生错误：" + textStatus);
            }
        });
    },
	
	deleteNodeAjax:function(){
		
		console.log("deleteNodeAjax");
		var kynamicId = menu.currKynaItem.kynamicId;
		if(kynamicId == 1){
			alert("不能删除根目录");
			return;
		}
		
		var isConfirm = window.confirm("你确定要删除当前节点吗");
		if(isConfirm == false){
			return;
		}
		
		var params = {
			"kynamicId":kynamicId
        };
        
        $.ajax({
            type: "POST",
            url: "resource/kynamic/kynamicAction_deleteKynamic.action",
            data: params,
            success: function(data, textStatus){
                // data 可能是 xmlDoc, jsonObj, html, text, 等等...
                console.log("ajax success");
				menu.zTreePlugin.removeNode(menu.currKynaItem);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                // 通常 textStatus 和 errorThrown 之中
                // 只有一个会包含信息
                console.log("ajax error");
                alert("请求服务器时发生错误：" + textStatus);
            }
        });
	},
	
	updateNodeAjax:function(){
		
		var oldName = menu.currKynaItem.kynamicName;
		var newName = window.prompt("请输入名称",oldName);
		
		if(newName == null){
			return;
		}
		if(isEmpty(newName)){
			alert("名称不能为空");
			return;
		}
		
		var params = {
			"kynamicId":menu.currKynaItem.kynamicId,
			"kynamicName":newName
        };
        
        $.ajax({
            type: "POST",
            url: "resource/kynamic/kynamicAction_updateKynamic.action",
            data: params,
            success: function(data, textStatus){
                // data 可能是 xmlDoc, jsonObj, html, text, 等等...
                console.log("ajax success");
				menu.currKynaItem.kynamicName = newName;
				menu.zTreePlugin.updateNode(menu.currKynaItem,true);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                // 通常 textStatus 和 errorThrown 之中
                // 只有一个会包含信息
                console.log("ajax error");
                alert("请求服务器时发生错误：" + textStatus);
            }
        });
	}
};

$().ready(function(){
    menu.initEvent();
    menu.loadRootMenu();
});

