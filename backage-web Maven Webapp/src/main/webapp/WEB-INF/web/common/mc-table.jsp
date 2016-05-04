<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<ul class="nav nav-tabs" id="navList">
	<!-- <li id="0" class="active"><a href="web/member/realNameAuthen.jsp?content=0">实名认证</a></li>
	<li id="1"><a href="web/member/per-senceAuthen.jsp?content=1">现场认证</a></li>
	<li id="2"><a href="web/member/per-senceAuthen.jsp?content=2">征信认证</a></li>
	<li id="3"><a href="web/member/per-addressAuthen.jsp?content=3">住址认证</a></li>
	<li id="4"><a href="web/member/per-senceAuthen.jsp?content=4">职称认证</a></li>
	<li id="5"><a href="web/member/per-senceAuthen.jsp?content=5">社保认证</a></li>
	<li id="6"><a href="web/member/per-freeholdAuthen.jsp?content=6">房产认证</a></li>
	<li id="7"><a href="web/member/per-carProductionAuthen.jsp?content=7">车产认证</a></li>
	<li id="8"><a href="web/member/per-senceAuthen.jsp?content=8">银行流水证认证</a></li>
	<li id="9"><a href="web/member/per-marrigeAuthen.jsp?content=9">婚姻认证</a></li>
	<li id="10"><a href="web/member/per-titleAuthen.jsp?content=10">学历认证</a></li>
	<li id="11"><a href="web/member/per-senceAuthen.jsp?content=11">其它</a></li> -->
</ul>
<script>
	var num = location.search.slice(9,location.search.length);
	$(function(){
		TradeType();
	});
	
	/**
	 * 认证类型列表
	 */
	function TradeType(){
		$.ajax({  
			url:appPath+"/memberidety/getIdentyTypeList.do",
			data:{
				content:0  //会员类型  0 个人会员 1 企业会员
			},
			type:'get',  
			cache:false,  
			dataType:'json',  
			success:function(result) { 
				var html = "";
				if(result!=null){
				var data = result.results;
				    $.each(data,function(index,obj){
						if(obj.attestTypeID==1){
							html+="<li id="+obj.attestTypeID+" class='active'><a href='web/member/realNameAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==2){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-senceAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==3){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-senceAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==4){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-addressAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==5){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-senceAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==6){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-senceAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==7){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-freeholdAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==8){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-carProductionAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==9){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-senceAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==10){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-marrigeAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else if(obj.attestTypeID==11){
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-titleAuthen.jsp?content="+obj.attestTypeID+"'>"+obj.attestTypeName+"</a></li>";
						}else{
							html+="<li id="+obj.attestTypeID+"><a href='web/member/per-senceAuthen.jsp?content="+obj.attestTypeID+"'>其他认证</a></li>";
						
						}
					});
					$("#navList").append(html);
					$("#navList li").each(function(){
						if ($(this).attr("id")==num){
							$(this).addClass("active").siblings().removeClass("active");
						}
					});
				}
			},  
			error : function() {  
				layer.alert("操作失败!",{icon:0});  
			}  
		});
	}	
</script>				