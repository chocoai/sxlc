//����
$(function () {
	var appPath = getRootPath();
	$(".fahuo").on("click touchstart",function(){
		
		layer.confirm('ȷ��������', {
		  btn: ['ȷ��', 'ȡ��']
		});
	});
});
//��������
$(function () {
	var appPath = getRootPath();
	$(".chexiao").on("click touchstart",function(){
		
		layer.confirm('ȷ������������', {
		  btn: ['ȷ��', 'ȡ��']
		});
	});
});