//关于我们-安全保障
$(function(){
	getSecurityGuarantee();
});

//获取安全保障
function getSecurityGuarantee(){
	$.ajax({
    	url:"aboutUs/securityGuaranteef.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		if(data.content){
	    		$(".safeContent").append(data.content);
    		}else{
    			var noData = '<div class="noData">暂无数据</div>';
	    		$(".safeContent").append(noData);
    		}
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}