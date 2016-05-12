$(function(){
	$(".choose1").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
	getPlatformIntro();
});

//function
//获取平台简介
function getPlatformIntro(){
	$.ajax({
    	url:"aboutUs/PlatformIntroduce.html",
    	type:"get",
    	timeout:10000,
    	dataType:"json",
    	success:function(data){
    		$(".plaform_content").append(data.content);
    	},
    	error:function(XMLHttpRequest, textStatus, errorThrown){
        	layer.alert("请求异常，请稍后再试",{icon:2});
		}
    });
}