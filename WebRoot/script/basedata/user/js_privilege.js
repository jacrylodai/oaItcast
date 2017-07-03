var privilege={
	
	init:{
		/**
		 * 页面加载时初始化事件
		 * ×点击“设置权限”后触发事件
		 * ×点击保存触发事件
		 */
		initEvent:function(){
			$("a[name='setPrivilege']").each(function(index,domElt){
				$(domElt).unbind("click");
				$(domElt).bind("click",function(){
					console.log("click setPrivilege");
					privilege.init.initData.call(this);
					privilege.otherFunc.showDiv();
					privilege.otherFunc.showUsername();
					privilege.privilegeTree.loadPrivilegeTree();
					
					return false;
				});
			});
			
			$("#savePrivilege").unbind("click")
			$("#savePrivilege").bind("click",function(){
				privilege.privilegeTree.savePrivilege();
			});
		},
		/**
		 * 初始化数据
		 */
		initData:function(){
			console.log("initData");
			var $userId = $(this).parent().siblings("input[type='hidden']").first();
			var userId = $userId.val();
			
			var username = $(this).parent().siblings("td").eq(1).text();
			
			privilege.data.user.userId = userId;
			privilege.data.user.username = username;
		}
	},
	
	privilegeTree:{
		
		zTreePlugin:null,
		setting:{
			isSimpleData: true,
			treeNodeKey: "menuId",
			treeNodeParentKey: "pid",
			nameCol:"menuName",
			showLine: true,
			checkable:true,
			checkType:{"Y":"p","N":"s"},
			root:{ 
				isRoot:true,
				nodes:[]
			},
			callback:{
				 change:function(event, treeId, treeNode){
				 	console.log("beforeChange");
				 	//根据权限树的选中状态设置全选框的值
					var nodeList = 
						privilege.privilegeTree.zTreePlugin.getCheckedNodes(false);
					if(nodeList.length == 0){
						$("#checkAllElt").attr("checked",true);
					}else{
						$("#checkAllElt").attr("checked",false);
					}
				 }
			}
		},
		checkTypeDefault:{"Y":"ps","N":"ps"},
		checkTypePro:{"Y":"p","N":"s"},
		/**
		 * 加载权限树
		 */
		loadPrivilegeTree:function(){
			
			var params = {
				"userId":privilege.data.user.userId
			}
			
			$.post("basedata/privilege/privilegeAction_listPrivilege.action"
				,params,function(data){
				privilege.privilegeTree.zTreePlugin = 
					$("#privilegeTree").zTree(
						privilege.privilegeTree.setting, data.menuItemList);
					
				//选择相应的节点	
				var menuIdList = data.selectedMenuIdList;
				for(var i=0;i<menuIdList.length;i++){
					var menuId = menuIdList[i];
					var menuItemNode = 
						privilege.privilegeTree.zTreePlugin.getNodeByParam("menuId"
							,menuId);
					if(menuItemNode.checked == false){
						menuItemNode.checked = true;
						privilege.privilegeTree.zTreePlugin.updateNode(menuItemNode,true);
					}
				}
						
				//权限树加载后初始化
				privilege.privilegeTree.initEventAfterLoading();
			});
		},
		/**
		 * 权限树加载后初始化
		 * 	×根据权限树的选中状态设置全选框的值
		 * 	×绑定全选事件
		 */
		initEventAfterLoading:function(){
			//根据权限树的选中状态设置全选框的值
			var nodeList = 
				privilege.privilegeTree.zTreePlugin.getCheckedNodes(false);
			if(nodeList.length == 0){
				$("#checkAllElt").attr("checked",true);
			}else{
				$("#checkAllElt").attr("checked",false);
			}
			
			//绑定全选事件
			$("#checkAllElt").unbind("click");
			$("#checkAllElt").bind("click",function(){
				privilege.privilegeTree.updateAllCheckBox.call(this);
			});
		},
		/**
		 * 全选
		 */
		updateAllCheckBox:function(){
			console.log("updateAllCheckBox");
			
			privilege.privilegeTree.updateTreeCheckType(
				privilege.privilegeTree.checkTypeDefault);
			
			var isChecked = $(this).attr("checked");
			if(isChecked){
				privilege.privilegeTree.zTreePlugin.checkAllNodes(true);
			}else{
				privilege.privilegeTree.zTreePlugin.checkAllNodes(false);
			}
			
			privilege.privilegeTree.updateTreeCheckType(
				privilege.privilegeTree.checkTypePro);
		},
		/**
		 * 改变checkType 配置点击 CheckBox 后，父子节点的影响规则
		 * @param {Object} preCheckType
		 */
		updateTreeCheckType:function(preCheckType){
			var preSetting = privilege.privilegeTree.zTreePlugin.getSetting();
			preSetting.checkType = preCheckType;
			privilege.privilegeTree.zTreePlugin.updateSetting(preSetting);
		},
		updateSubMenuCheckBox:function(flag){
			
		},
		savePrivilege:function(){
			
			if(privilege.privilegeTree.zTreePlugin == null){
				alert("权限树还没有加载完成，无法保存");
				return;
			}
			
			var nodeList = 
				privilege.privilegeTree.zTreePlugin.getCheckedNodes(true);
			var nodeIdList = new Array(nodeList.length);
			for(var i=0;i<nodeList.length;i++){
				var node = nodeList[i];
				nodeIdList[i] = node.menuId;
			}
			
			var params = {
				"userId":privilege.data.user.userId,
				"menuIdListJson":JSON.stringify(nodeIdList)
			}			
			console.log(params);
			
			$.ajax({
				type: "POST",
				url: "basedata/privilege/privilegeAction_savePrivilege.action",
				data: params,
				success: function(data, textStatus){
				// data 可能是 xmlDoc, jsonObj, html, text, 等等...	
					alert("修改成功");
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
				// 通常 textStatus 和 errorThrown 之中
				// 只有一个会包含信息
					alert("修改失败:"+textStatus);
				}
			});

		}		
	},
	
	otherFunc:{
		/**
		 * 
		 */
		showUsername:function(){
			$("#usernameElt").text(privilege.data.user.username); 
		},
		showDiv:function(){
			$("#userTitle").show();
			$("#privilegeTitle").show();
			$("#privilegeContent").show();
		}
	},
	
	/**
	 * json对象对数据的封装
	 */
	data:{
		user:{
			userId:"",
			username:""
		}		
	}
}

$().ready(function(){
	console.log("privilege init");
	privilege.init.initEvent();
});
