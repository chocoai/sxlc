/*  对会员详情进行显示控制         */
/**
 * 会员基本信息
 */
function  showMemberDetail(memberId){
	var  url= appPath+"/member/getMemDetail.do";
	$.ajax( {  
		 url:url,
			data:{
				memberId:memberId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					var str="";
					console.log(JSON.stringify(data));
            		 if(data.provinceName!=null &&data.provinceName!=""){
            			str = data.provinceName;
            		 }
            		if(data.cityName!=null &&data.cityName!=""){
            			str +=" "+data.cityName;
            		 }
            		if(data.countyName!=null &&data.countyName!=""){
            			str +=" "+ data.countyName;
            		 }
            		if(data.townName!=null &&data.townName!=""){
            			str +=" "+ data.townName;
            		 }
					if(data.memberNo!=null){
						$("#memberNo").text(data.memberNo);
					}
					if(data.memberName!=null){
						$("#memberName").text(data.memberName);
					}
					if(data.userName!=null){
						$("#userName").text(data.userName);
					}
					if(data.memberIdCard!=null){
						$("#memberIdCard").text();
						var birth ="";
						var age= "";
						if(data.memberIdCard!=""){
							birth =  IdCard(data.memberIdCard,1);
							age =  IdCard(data.memberIdCard,3);
						}
						$("#birth").text(birth);
						$("#age").text(age);
					}
					if(data.froms!=null){
						$("#froms").text(data.froms);
					}
					if(data.nationName!=null){
						$("#nationName").text(data.nationName);
					}
					if(data.permanentAddress!=null){
						$("#permanentAddress").text(data.permanentAddress);
					}
					if(data.residenceAddress!=null){
						$("#residenceAddress").text(data.residenceAddress);
					}
					if(data.memberPhone!=null){
						$("#memberPhone").text(data.memberPhone);
					}
					if(data.memberEmail!=null){
						$("#memberEmail").text(data.memberEmail);
					}
					if(data.memberQQ!=null){
						$("#memberQQ").text(data.memberQQ);
					}
					if(data.sexName!=null){
						$("#sexName").text(data.sexName);
					}
					if(data.educationName!=null){
						$("#educationName").text(data.educationName);
					}
					if(data.marriageStatuName!=null){
						$("#marriageStatuName").text(data.marriageStatuName);
					}
					if(data.sMonthlyIncome!=null){
						$("#sMonthlyIncome").text(data.sMonthlyIncome);
					}
					$("#area").text(str); //地区
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
	
}

/**
 * 会员第三方基本信息
 */
function  showMemberThirdInfo(memberId){
	$.ajax( {  
		 url:appPath+"/member/getMemberThirdInfo.do",
			data:{
				memberId:memberId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					if(data.thirdPartyAccount!=null){
						$("#thirdPartyAccount").text(data.thirdPartyAccount);//第三方账户编号
					}
					if(data.thirdPartyMark!=null){
						$("#thirdPartyMark").text(data.thirdPartyMark);//第三方账户标识
					}
					if(data.userBalance!=null){
						$("#userBalance").text(data.userBalance); //账户余额
					}
					if(data.frozen!=null){
						$("#frozen").text(data.frozen); //账户冻结金额
					}
					
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
	
}

/**
 * 会员认证项基本信息
 */
function  showMemberIdentyInfo(memberId){
	$.ajax( {  
		 url:appPath+"/member/getMemberIdenty.do",
			data:{
				memberId:memberId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null){
					if(data.length>0){
						$.each(data,function(index,ob){
	  						if((index%7)==0){
	  							$("#identy_types").append("<tr><td class=\"tt\"><a >"+ob.attestName+"</a></td></tr>"); //href='member?Smallsort="+ob.memberId+"&'>
	  						}else{
	  							$("#identy_types tr:last").append("<td class=\"tt\"><a >"+ob.attestName+"</a></td>");
	  						}
	  					});
					}
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}

/**
 * 会员借款统计基本信息
 */
function  showMemberBorrowStatic(memberId){
	$.ajax( {  
		 url:appPath+"/member/getMemberborrowers.do",
			data:{
				memberId:memberId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null && data!=""){
					$("#loanCount").val(data.loanCount);	//成功借款
					$("#repaymentCount").val(data.repaymentCount);//成功还款
					$("#investmentCount").val(data.investmentCount);//成功投资
					$("#overdueRepaymentCount").val(data.overdueRepaymentCount); //逾期还款
					$("#yZOverdueRepaymentCount").val(data.yZOverdueRepaymentCount);//严重逾期
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}


/**
 * 会员投资统计基本信息
 */
function  showMemberInvestStatic(memberId){
	$.ajax( {  
		 url:appPath+"/member/getMemberInvestMess.do",
			data:{
				memberId:memberId
			},
			type:'post',  
			cache:false,  
			dataType:'json',   
			success:function(data) { 
				if(data!=null && data!=""){
					$("#investmentCount").val(data.investmentCount);	//成功投资笔数
					$("#sInvestmentSum").val(data.sInvestmentSum);//成功投资金额
					$("#sRecvPrincipal").val(data.sRecvPrincipal);//累计已还本金
					$("#sRecvInterest").val(data.sRecvInterest); //累计已还利息
					$("#sExpectRecvPrincipal").val(data.sExpectRecvPrincipal); //代收本金
					$("#sIncomeReceived").val(data.sIncomeReceived);//代收利息
				}
			},  
			error : function() {  
				layer.alert("服务器异常",{icon:2});  
			}  
		});
}


/**
 * 通过身份证获取生日和年龄
 * @param UUserCard
 * @param num
 * @returns
 */
function IdCard(UUserCard,num){
	   if(num==1){
	       //获取出生日期
	       birth=UUserCard.substring(6, 10) + "-" + UUserCard.substring(10, 12) + "-" + UUserCard.substring(12, 14);
	    return birth;
	   }
	   if(num==2){
	       //获取性别
	       if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) {
	           //男
	     return "男";
	       } else {
	           //女
	     return "女";
	       }
	   }
	   if(num==3){
	        //获取年龄
	        var myDate = new Date();
	        var month = myDate.getMonth() + 1;
	        var day = myDate.getDate();
	        var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1;
	        if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) {
	            age++;
	        }
	  return age;
	  }
}

