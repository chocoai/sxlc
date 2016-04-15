$(function(){
	$(".choose9").attr("selected","selected");//Ĭ��ѡ����ʽ ���� 20160327
	/*折叠显示部分开始 王延君2016-03-29*/
	$(".problem_plat_btn").addClass("plat_btn_left");
	$(function(){
		$(".problem_plat_cont").hide();
		$(".problem_plat h5").click(function(){
			$(this).next().slideToggle();
		});
		var i=1;
		$(".problem_plat h5").click(function(){
			i++;
			if(i%2==0){
				$(this).children("span").removeClass("plat_btn_left").addClass("plat_btn_down");
			}else{
				$(this).children("span").removeClass("plat_btn_down").addClass("plat_btn_left");
			}
		});
	});
	/*折叠显示部分结束 王延君2016-03-29*/
});




/*  20160410  胥福星    */
$(function(){
	$(".aboutUsNav input").val($(".choose9").html());
});