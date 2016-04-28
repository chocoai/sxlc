$(function(){
	$(".TB").addClass("down");
	$(".TB7").addClass("down2");
});
/*  个人认证和企业认证的样式切换代码      */
$(function(){
	$(".th span").each(function(){
		$(this).click(function(){
			var index = $(this).index();
			$(this).addClass("thClick").siblings().removeClass("thClick");
			$(this).parent().parent().children("ul").eq(index).show();
			$(this).parent().parent().children("ul").eq(index).siblings("ul").hide();
		});
	});
});
/*   end     */

/*      婚姻认证的切换             */
$(function(){
	$(".radioLabel").each(function(){
		$(this).click(function(){
			$(this).addClass("checked").siblings(".radioLabel").removeClass("checked");
			$(this).prev().attr("checked",true);
			$(this).siblings(".radioLabel").prev().attr("checked",false);
		});
	});
});
/*         end           */
/*  已认证、未认证等显示的链接页面不一的代码         */
$(function(){
	$(".tdSpan").each(function(){
		if($(this).html().match("已认证") || $(this).html().match("已审核") || $(this).html().match("已通过")){
			$(this).addClass("tdAuthen");
		}else if($(this).html().match("审核中")){
			$(this).addClass("tdReview");
		}else if($(this).html().match("未通过")){
			$(this).addClass("tdFile");
		}else if($(this).html().match("已过期")){
			$(this).addClass("tdOutOfDate");
		}else if($(this).html().match("未认证")){
			$(this).addClass("tdUnauth");
		}
		if($(this).html().match("已认证") || $(this).html().match("审核中")){
			$(this).parent().find(".linkCheck").show();
		}else if($(this).html().match("已过期") || $(this).html().match("未通过")){
			$(this).parent().find(".linkAlert").show();
		}else if($(this).html().match("未认证")){
			$(this).parent().find(".linkAuthen").show();
		}
	});
});
/*   end    */
/* 添加认证      */
$(function(){
	var content = $(".addAuthen").parent().next().html();
	content = "<div class='cloneDiv'>" + content + "</div>";
	$(".addAuthen").on("click",function(){
		$(this).parent().parent().append(content);
		inputText(".cloneDiv:last");
		checkCAR();
	});
});

function scale(obj){
	if(!$(obj).hasClass("authenScaleClick")){
		$(obj).addClass("authenScaleClick").removeClass("authenScaleBtn");
		$(obj).parent().parent().find(".inputArea").hide();
	}else{
		$(obj).removeClass("authenScaleClick").addClass("authenScaleBtn");
		$(obj).parent().parent().find(".inputArea").show();
	}
}
/*    图片上传预览             */
//function getFileUrl(sourceId) { 
//	var url; 
//	if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox 
//		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
//	} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome 
//		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
//	} else {
//		var file = document.getElementById(sourceId);
//		file.select();
//		file.blur();
//        var url = document.selection.createRange().text;
//	}
//	return url; 
//} 
//var countli =0;
//$(function(){
//	$(".subPicture-Area").each(function(){countli++;});
//	$(".subPicture-Area").each(function(){
//		if($(this).find('img').attr('src') != undefined){
//			$(this).find('button').show();
//		}else{
//			$(this).find('button').hide();
//		}
//	});
//});
//function preImg(path,sourceId, targetId) { 
//	var url = getFileUrl(sourceId);
//	countli++;
//	var stringli = 
//		'<li>'+
//		'<div class="input-Area">'+
//		'<input type="text" placeholder="请输入上传类型">'+
//		'</div>'+
//		'<div class="subPicture-Area">'+
//		'<div></div>'+
//		'<span>添加图片</span>'+
//		'<img id="img-'+countli+'" class="img"/>'+ 
//		'<input name="uploadFile" type="file"  class="file" id="file-'+countli+'" size="28"  onchange="preImg(\''+path+'\',this.id,\'img-'+countli+'\');" />'+
//		'<button onclick="$(this).parent().parent().remove();"></button>'+
//		'</div>'+
//		'<div class="infor-Area">'+
//		'<input type="hidden" value="" name="imgURL">'+
//		'</div>'+
//		'</li>';
//	var imgPre = document.getElementById(targetId); 
//	var isIE = navigator.userAgent.match(/MSIE/)!= null;
//	if(isIE) {
//		imgPre.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + url + "\")";
//		imgPre.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
//	} else{
//		imgPre.src = url; 
//	}
//	$("#"+sourceId).parent().next().find('input').val(url);
//	if($("#"+sourceId).prev('img').attr('src') != undefined){
//		if($("#"+sourceId).prev('img').attr('src') != 'null'){
//			if($("#"+sourceId).next('button').length > 0){
//				$("#"+sourceId).parent().parent().parent().append(stringli);
//				$("#file-"+(countli)).next('button').hide();
//				$("#"+sourceId).next('button').show();
//			}
//		}else if($("#"+sourceId).next('button').length > 0){
//			$("#"+sourceId).parent().parent().remove();
//		}
//	}
//	uploadProjectImg(path,sourceId,targetId);
//}
//function shoppreImg(path,sourceId, targetId) { 
//	var url = getFileUrl(sourceId);
//	var temp_index=parseInt($(".shopImagsCount:last").val())+1;
//	countli++;
//	var stringli = 
//		'<li>'+
//		'<div class="input-Area">'+
//		'<input type="hidden" value="'+temp_index+'" class="shopImagsCount">'+
//		'<input type="hidden" value="2" name="projectInfoEntity.projectInfoShopEntity['+temp_index+'].shopType">'+
//		'<input type="text" placeholder="请输入上传类型" maxlength="10" name="projectInfoEntity.projectInfoShopEntity['+temp_index+'].shopName">'+
//		'</div>'+
//		'<div class="subPicture-Area">'+
//		'<div></div>'+
//		'<span>添加图片</span>'+
//		'<img id="img-'+countli+'" class="img"/>'+ 
//		'<input name="uploadFile" type="file"  class="file" id="file-'+countli+'" size="28"  onchange="shoppreImg(\''+path+'\',this.id,\'img-'+countli+'\');" />'+
//		'<button onclick="$(this).parent().parent().remove();"></button>'+
//		'</div>'+
//		'<div class="infor-Area">'+
//		'<input type="hidden" value="" name="projectInfoEntity.projectInfoShopEntity['+temp_index+'].shopUrl">'+
//		'</div>'+
//		'</li>';
//	var imgPre = document.getElementById(targetId); 
//	var isIE = navigator.userAgent.match(/MSIE/)!= null;
//	if(isIE) {
//		imgPre.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + url + "\")";
//		imgPre.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
//	} else{
//		imgPre.src = url; 
//	}
//	$("#"+sourceId).parent().next().find('input').val(url);
//	if($("#"+sourceId).prev('img').attr('src') != undefined){
//		if($("#"+sourceId).prev('img').attr('src') != 'null'){
//			if($("#"+sourceId).next('button').length > 0){
//				$("#"+sourceId).parent().parent().parent().append(stringli);
//				$("#file-"+(countli)).next('button').hide();
//				$("#"+sourceId).next('button').show();
//			}
//		}else if($("#"+sourceId).next('button').length > 0){
//			$("#"+sourceId).parent().parent().remove();
//		}
//	}
//	uploadProjectImg(path,sourceId,targetId);
//}
//function creapreImg(path,sourceId, targetId) { 
//	var url = getFileUrl(sourceId);
//	var temp_index=parseInt($(".creadImagsCount:last").val())+1;
//	countli++;
//	var stringli = 
//		'<li>'+
//		'<div class="input-Area">'+
//		'<input type="hidden" value="'+temp_index+'" class="creadImagsCount">'+
//		'<input type="hidden" value="2" name="projectInfoEntity.projectInfoCreditEntity['+temp_index+'].annexType">'+
//		'<input type="text" placeholder="请输入上传类型" maxlength="10" name="projectInfoEntity.projectInfoCreditEntity['+temp_index+'].annexName">'+
//		'</div>'+
//		'<div class="subPicture-Area">'+
//		'<div></div>'+
//		'<span>添加图片</span>'+
//		'<img id="img-'+countli+'" class="img"/>'+ 
//		'<input name="uploadFile" type="file"  class="file" id="file-'+countli+'" size="28"  onchange="creapreImg(\''+path+'\',this.id,\'img-'+countli+'\');" />'+
//		'<button onclick="$(this).parent().parent().remove();"></button>'+
//		'</div>'+
//		'<div class="infor-Area">'+
//		'<input type="hidden" value="" name="projectInfoEntity.projectInfoCreditEntity['+temp_index+'].annexUrl">'+
//		'</div>'+
//		'</li>';
//	var imgPre = document.getElementById(targetId); 
//	var isIE = navigator.userAgent.match(/MSIE/)!= null;
//	if(isIE) {
//		imgPre.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + url + "\")";
//		imgPre.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
//	} else{
//		imgPre.src = url; 
//	}
//	$("#"+sourceId).parent().next().find('input').val(url);
//	if($("#"+sourceId).prev('img').attr('src') != undefined){
//		if($("#"+sourceId).prev('img').attr('src') != 'null'){
//			if($("#"+sourceId).next('button').length > 0){
//				$("#"+sourceId).parent().parent().parent().append(stringli);
//				$("#file-"+(countli)).next('button').hide();
//				$("#"+sourceId).next('button').show();
//			}
//		}else if($("#"+sourceId).next('button').length > 0){
//			$("#"+sourceId).parent().parent().remove();
//		}
//	}
//	uploadProjectImg(path,sourceId,targetId);
//}
/*      end      */

