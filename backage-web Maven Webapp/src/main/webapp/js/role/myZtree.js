//此方法是每级都可以点击并进行跳转
/* zTree插件加载目录的处理  */
		var zTree;
		var setting = {
				view: {
					dblClickExpand: false,
					showLine: false,
					expandSpeed: true
				},
				data: {
					key: {
						name: "resourceName"
					},
					simpleData: {
						enable:true,
						idKey: "resourceID",
						pIdKey: "parentID",
						rootPId: ""
					}
				},
				callback: {
					onClick: zTreeOnClick		
				}
		};
		
		/** 用于捕获节点被点击的事件回调函数  **/
		function zTreeOnClick(event, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			//
			showListOfDataTable(treeNode.resourceID); //显示datatable 
			// 如果节点路径为空或者为"#"，不允许单击操作
			if(treeNode.accessPath=="" || treeNode.accessPath=="#"){
				//alert("节点路径为空或者为'#'哦...");
				return false;
			}
		    // 跳到该节点下对应的路径, 把当前资源ID(resourceID)传到后台，写进Session
		};
		
		
		function onStart(){
			$("#ajaxDialog").show();
		}
				
		function onStop(){
			$("#ajaxDialog").hide();
		}
		