$(function(){
	$(".admRest>button").hover(function(){
		$(this).css("backgroundColor","#4195F2");
		$(this).css("color","#fff");
	},function(){
		$(this).css("backgroundColor","#B4B4B4");
	});
});
//jQuery.fn.changeRemarks = function(){//ÓÃÀ´ÌÞ³ýÌØÊâ×Ö·û
//	var remarks2 = $(this).val() ;
//	var cont = remarks2.length;
//	for(var c = 0;c < cont ; c++){
//		remarks2=remarks2.replace(/["'<>%;)(&+]/,"");
//	}
//	$(this).val(remarks2);
//};
$(".getYan input").click(function(){
	$(this).attr("disabled","true");
	$(this).siblings("span").css("display","inline-block");
	var sh;
	sh=setInterval(function(){
		
	},180000);
	clearInterval(sh);
	
});
$(function(){
	$("#forget_pass").Validform({
		tiptype:3,
		btnSubmit:"#Change-Btn", 
		datatype:extdatatype,
		ajaxPost:{
			
		    },
			success:function(data,obj){
	            
	        },
	        error:function(data,obj){
	            
	        }
		});
});