/*���㱾ҳ��ĸ߶�*/
function tabelFixWindow(){
	var big = $('.right_col').height();
	var small = $('.memberselect_a').outerHeight(true);
	var aimHeight =  big - small;
	$(".tScroll").css("height",aimHeight + "px");    
}
window.onresize = function(){tabelFixWindow();};
$(function(){
    //tabelFixWindow();
 /*   $(".li_level_one").click(function(){
    	$(".child_menu").show();
    });*/
 /*   $(".individualMember").click(function(){
    	$(".memberDetails").toggle();
    });*/
    $(".memberRest").click(function(){
    	$(".memberPwd").toggle();
    });
});
$(function () {
	/** ******  /left menu  *********************** **/
//	һ������
    $('#sidebar-menu .side-menu>li>a').on('click touchstart', function() {
        /* var link = $('a', this).attr('href');

       if(link) { 
            window.location.href = link;
        } else {*/
            if ($(this).parent("li").is('.active')) {
                $(this).parent("li").removeClass('active');
                $('ul', $(this).parent("li")).slideUp();
            } else {
                $('#sidebar-menu li').removeClass('active');
                $('#sidebar-menu li ul').slideUp();
                
                $(this).parent("li").addClass('active');
                $('ul', $(this).parent("li")).slideDown();
            }
        
    });
    /**  ************��������***************** **/
    	/*$(function () {
    	    var url = window.location;
    	    $('#sidebar-menu a[href="' + url + '"]').parent('li').addClass('current-page');
    	    $('#sidebar-menu a').filter(function () {
    	        return this.href == url;
    	    }).parent('li').addClass('current-page').parent('ul').slideDown().parent().addClass('active');
    	});*/
    	$(".li_level_one li").click(function(){
    		if ($(this).is('.child_menu')) {
                $(this).removeClass('.child_menu');
            } else {
                $('.li_level_one li').removeClass('.child_menu');
                $(this).addClass('.child_menu');
            }
    	});
    	$(".individualMember").click(function(){
    		if ($(this).is('.memberDetails')) { 
                $(this).removeClass('.memberDetails');
            } else {
                $('.individualMember').removeClass('.memberDetails');
                $(this).addClass('.memberDetails');
            }
    	});
});  

$(function(){
	/*�鿴��Ա����*/
	$(".viewMembershipDetails").click(function(){
		layer.open({
			area: ['80%', '80%'],
			/*skin: 'layui-layer-rim', //���ϱ߿�       */	
			title: '�鿴��Ա����', 
			/*maxmin: true,  //�����ķŴ���С*/
		    type:1,
		    content: $(".membershipDetails")//DOM;
		   /* style:'position:fiex;left:0;top:1000px;width:100%;height:100%;border:none;background-color:#F05133; text-align:center;'*/
		});
	});
	
	/*�����Ŀ��ѯ*/
	$(".loanItemQueryCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '�����Ŀ��ѯ', 
		    type:1,
		    content: $(".loanItemQuery")//DOM;
		});
	});
	
	/*Ͷ����Ŀ��ѯ*/
	$(".nvestmentProjectInquiryCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: 'Ͷ����Ŀ��ѯ', 
		    type:1,
		    content: $(".nvestmentProjectInquiry")//DOM;
		});
	});
	
	/*���׼�¼*/
	$(".transactionRecordCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '���׼�¼', 
		    type:1,
		    content: $(".transactionRecord")//DOM;
		});
	});
	
	/*���п���ѯ*/
	$(".transactionRecordCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '���п���ѯ', 
		    type:1,
		    content: $(".bankCardInquiry")//DOM;
		});
	});
	
	/*�鿴�����Ա��¼*/
	$(".inviteMembersCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '�鿴�����Ա��¼', 
		    type:1,
		    content: $(".inviteMembers")//DOM;
		});
	});
	
	/*����*/
	$(".pullTheBlackCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '����', 
		    type:1,
		    content: $(".pullTheBlack")//DOM;
		});
	});
	
	/*��Ա��������*/
	$(".memberPasswordResetCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '��Ա��������', 
		    type:1,
		    content: $(".memberPasswordReset")//DOM;
		});
	});
	
	/*�޸������Ա*/
	$(".modifyInviteMemberCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '�޸������Ա', 
		    type:1,
		    content: $(".modifyInviteMember")//DOM;
		});
	});
	
	/*������Ϣ*/
	$(".sendMessageCunt").click(function(){
		layer.open({
			area: ['80%', '80%'],
			title: '������Ϣ', 
		    type:1,
		    content: $(".sendMessage")//DOM;
		});
	});
});

$(document).ready(function() {
    /*$('#memberSelect').dataTable();
    $('#membershipDetails').dataTable();
    $('#loanItemQuery').dataTable();
    $("#nvestmentProjectInquiry").dataTable();
    $("#transactionRecord").dataTable();
    $('#bankCardInquiry').dataTable();
    $("#inviteMembers").dataTable();
    $("#pullTheBlack").dataTable();
    $('#memberPasswordReset').dataTable();
    $("#modifyInviteMember").dataTable();
    $("#sendMessage").dataTable();*/
});