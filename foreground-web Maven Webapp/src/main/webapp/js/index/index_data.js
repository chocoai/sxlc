$(function(){
	/**统计**/
	quryIndexStatic();
	/**banner**/
	quryBannerfront();
	/**最新平台公告**/
	quryLiveBroadcast();
	/**平台宣传点**/
	quryPlatformBooth();
	/**投资专区**/
	quryInvestListIndex();
	/**网站公告***/
	quryPlatformListIndex();
	/**投资理财榜**/
	quryInvestRecordIndex("0");
	/**新闻动态**/
	quryMediaReportsList();
	/**查询合作伙伴**/
	quryPartnersList();
	/**债权转让**/
	quryCreditorTransferList();
	/**新手体验标**/
	quryNewbieExperience();
	
	//投资理财榜 ，点击切换
	$(".ranking_list span").click(function(){
		var id=$(this).attr("id");
		quryInvestRecordIndex(id);
	});	
	
});

/**
 * 查询首页顶部统计
 */
function quryIndexStatic(){
	$.ajax({
		type:"GET",
		url:"selectIndexStatistic.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
			   
			}else{
				
			}
		}
	});	
}

/**
 * 查询banner
 */
function quryBannerfront(){
	$.ajax({
		type:"GET",
		url:"selectHomeBannerfront.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
					var html = template('bannerList', object);
			        document.getElementById('banner_ul').innerHTML = html;
			        
			        bannerScorll();//banner图动态切换效果
			}else{
				
			}
		}
	});		
}
/**
 * banner图动态切换效果
 */
function bannerScorll(){
	var slidey = $('.banner').unslider({
		speed: 500,			   
		delay: 3000,			
		complete: function() {}, 
		keys: true,			 
		dots: true,			  
		fluid: true
	});
	data = slidey.data('unslider'); 
	data.move(2, function() {});	
}

/**
 * 查询最新平台公告
 */
function quryLiveBroadcast(){
	$.ajax({
		type:"GET",
		url:"selectLiveBroadcast.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				if(data!=null){
					var html = template('broadcastList', object);
			        document.getElementById('indemo').innerHTML = html;		
			        broadcastScroll();
				}
			}else{
				
			}
		}
	});	
}

/**
 * 查询平台宣传点
 */
function quryPlatformBooth(){
	$.ajax({
		type:"GET",
		url:"selectPlatformBooth.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				if(object!=null){
					var html = template('PlatformBoothList', object);
			        document.getElementById('PlatformBooth').innerHTML = html;		
				}
			}else{
				
			}
		}
	});	
}

/**
 * 查询投资专区
 */
function quryInvestListIndex(){
	$.ajax({
		type:"GET",
		url:"selectInvestListIndex.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				if(object!=null){
					var html = template('investList', object);
			        document.getElementById('investL').innerHTML = html;		
				}
			}else{
				
			}
		}
	});	
}

/**
 * 查询网站公告
 */
function quryPlatformListIndex(){
	$.ajax({
		type:"GET",
		url:"selectPlatformListIndex.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				if(data!=null){
					var html = template('announcementList', object);
			        document.getElementById('announcement').innerHTML = html;		
				}
			}else{
				
			}
		}
	});	
}

/**
 * 查询投资理财榜
 */
function quryInvestRecordIndex(type){
	var str_url="selectInvestRecordIndex.html";
	NetUtil.ajax(
			str_url,
			{type:type},
			function(r){
				var object = JSON.parse(r);
				if (object.code == 200){
					var html = template('investRecordList', object);
			        document.getElementById('investRecord').innerHTML = html;					
				}else{
				}
			}
		)	
}

/**
 * 查询新闻动态
 */
function quryMediaReportsList(){
	$.ajax({
		type:"GET",
		url:"selectMediaReportsListIndex.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				var html = template('mediaReportsList', object);
		        document.getElementById('mediaReports').innerHTML = html;	
		        
		        var data=object.data;
		        if(data.length>0){
		        	var media=data[0];
		        	var url=media.logo;
		        	$(".newsImg").attr("src",""+attachPrefix+url+"");
		        }
			}else{
				
			}
		}
	});	
}

/**
 * 查询合作伙伴
 */
function quryPartnersList(){
	$.ajax({
		type:"GET",
		url:"selectPartnersListIndex.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				var html = template('partnersList',object);
		        document.getElementById('partners').innerHTML=html;
			}else{
				
			}
		}
	});	
}

/**
 * 查询债权转让
 */
function quryCreditorTransferList(){
	$.ajax({
		type:"GET",
		url:"selectCreditorTransferListIndex.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				var html = template('transferList',object);
		        document.getElementById('transfer').innerHTML=html;
			}else{
				
			}
		}
	});	
}

/**
 * 查询新手体验标
 */
function quryNewbieExperience(){
	$.ajax({
		type:"GET",
		url:"selectNewbieExperienceSetIndex.html",
		success:function(r){
			var object=JSON.parse(r);
			if(object.code == 200){
				console.log(object);
				var html = template('newMemberList',object);
		        document.getElementById('newMemberL').innerHTML=html;
			}else{
				
			}
		}
	});	
}