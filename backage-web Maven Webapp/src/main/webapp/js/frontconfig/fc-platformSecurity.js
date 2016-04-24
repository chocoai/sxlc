/**
 *前台界面配置-平台安全保障管理
 *pr
 */
	var ue ;
	$(function(){
		var content ="";
		ue = UE.getEditor('applyguide');

		//查询
		ue.addListener( 'ready', function( ue ) {
			 $.post(appPath+"/Security/SecurityEntity.do",
					function(data){	
						if(data !=null && data !=''){		
							var content = data.content; 
						   // var content = JSON.parse(data).content;
							UE.getEditor('applyguide').execCommand('insertHtml', content);
						}
		});

	     /* $.ajax({
				url : appPath+"/Security/SecurityEntity.do",
					data:{
					},
					type : "post",
					dataType:"json",
				error : function() {
					alert('操作失败！');
					return;
				},
				success : function(data) {
					//1：失败 ， 0：成功 ，-1：部门信息不存在，-2:职务名称已存在，-3：职务信息不存在、-4：职务信息已存在、-5：上级职务不属于同一部门
					if(data !=null && data !=''){
					     content = data.content; // JSON.parse(data).content;
					     
					     ue.setContent(content);
					}
				 },
				 complete: function(){
					//('insertHtml', rowdata[0].sgContent);
				 }
			});*/
	      	
		 } );
	});

/**
 * 保存
 */
function savaOrUpdate(){
		var content = ue.getContent();
		 $.ajax({
				url : appPath+"/Security/SaveSecurity.do",
					data:{
						content:content
					},
					type : "post",
					dataType:"json",
				error : function() {
					alert('操作失败！');
					return;
				},
				success : function(data) {
					if(data==1)
						layer.alert("保存成功。",{icon:1});  
					else{
						layer.alert("保存失败！",{icon:2});  
					}
						
				 }
			});
	}