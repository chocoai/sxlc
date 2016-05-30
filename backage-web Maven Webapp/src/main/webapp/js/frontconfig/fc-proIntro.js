/* 产品介绍管理模块      */
/* 产品     */


/*    滚动条显示                 */
$(function(){
		//编辑器实例化
	var ue1 = UE.getEditor('introduceDetail');
	$(".addContainer").css({"height":"350px","overflow-y":"scroll"});
	$(".line").css({"display":"inline-block","width":"15px","height":"1px","background":"#888","margin":"0 9px","vertical-align":"inherit"});
});


/**
 *前台界面配置-平台安全保障管理
 *pr
 */
	var ue ;
	$(function(){
		var content ="";
		ue = UE.getEditor('introduceDetail');

		//查询
		ue.addListener( 'ready', function( ue ) {
			 $.post(appPath+"/ProductIntroduce/showProductIntroduce.do",
					function(data){	
						if(data !=null && data !=''){		
							var content = data.content; 
						   // var content = JSON.parse(data).content;
							UE.getEditor('introduceDetail').execCommand('insertHtml', content);
						}
			 });
		 } );
	});

/**
 * 保存
 */
function savaOrUpdate(){
		var content = ue.getContent();
		 $.ajax({
				url : appPath+"/ProductIntroduce/saveProductIntroduce.do",
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