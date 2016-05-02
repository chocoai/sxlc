
/**
 * 
 */
function addBorrow(){
	/*直接意向借款弹出框*/
	layer.open({
	    type: 1,
	    area: ['60%', '90%'], //高宽
	    title: '添加意向借款',
	    maxmin: true,
	    content: $('.borrowingCull'),//DOM或内容
	    btn:['确定', '取消']
	});

}
