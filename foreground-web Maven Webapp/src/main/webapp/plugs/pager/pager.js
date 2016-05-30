/**
 * 同步、异步分页
 * @type
 */
/*我的账户-资金管理-收支明细-交易记录*/
var pager = {
		pagerid 			: 'pager', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager_gopage_wrap',
		gopageButtonId		: 'pager_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText				: '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText			: '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,true);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
$(function() {
//	var totalPage = 160;//总页数
//	var totalRecords = 390;//总记录条数
//	var pageNo = getParameter('pno');//当前页
//	if (!pageNo) {
//		pageNo = 1;
//	}
//	//生成分页
//	//有些参数是可选的，比如lang，若不传有默认值
//	pager.generPageHtml({
//		pno : pageNo,
//		//总页码
//		total : totalPage,
//		//总数据条数
//		totalRecords : totalRecords,
//		//链接前部
//		hrefFormer : 'pager_test',
//		//链接尾部
//		hrefLatter : '.html',
//		getLink : function(n) {
//			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
//		}
//		
//		//lang参数,选择设置，见js
//		
//		//click模式
//		,
//		mode : 'click',//默认值是link，可选link或者click
//		click : function(n) {
//			this.selectPage(n);
//			return false;
//		}
//	});
});
/*李丽梅 pager1部分开始*/
/*2016-4-11*/
/*我的账户-资金管理-收支明细-充值记录*/
var pager1 = {
		pagerid 			: 'pager1', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager1_gopage_wrap',
		gopageButtonId		: 'pager1_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager1_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText			    : '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText		    : '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager1.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,true);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager1.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager1.focus_gopage()"  onkeypress="return pager1.keypress_gopage(event);"   onblur="pager1.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager1._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
//$(function() {
//	var totalPage = 160;//总页数
//	var totalRecords = 390;//总记录条数
//	var pageNo = getParameter('pno');//当前页
//	if (!pageNo) {
//		pageNo = 1;
//	}
//	//生成分页
//	//有些参数是可选的，比如lang，若不传有默认值
//	pager1.generPageHtml({
//		pno : pageNo,
//		//总页码
//		total : totalPage,
//		//总数据条数
//		totalRecords : totalRecords,
//		//链接前部
//		hrefFormer : 'pager_test',
//		//链接尾部
//		hrefLatter : '.html',
//		getLink : function(n) {
//			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
//		}
//		
//		//lang参数,选择设置，见js
//		
//		//click模式
//		,
//		mode : 'click',//默认值是link，可选link或者click
//		click : function(n) {
//			this.selectPage(n);
//			return false;
//		}
//	});
//});
/*李丽梅 pager1部分结束*/
/*李丽梅 pager2部分开始*/
/*2016-4-11*/
/*我的账户-资金管理-收支明细-提现记录*/
var pager2 = {
		pagerid 			: 'pager2', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager2_gopage_wrap',
		gopageButtonId		: 'pager2_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager2_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText			    : '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText		: '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager2.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,true);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText2 || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager2.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager2.focus_gopage()"  onkeypress="return pager2.keypress_gopage(event);"   onblur="pager2.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager2._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
/*$(function() {
	var totalPage = 160;//总页数
	var totalRecords = 390;//总记录条数
	var pageNo = getParameter('pno');//当前页
	if (!pageNo) {
		pageNo = 1;
	}
	//生成分页
	//有些参数是可选的，比如lang，若不传有默认值
	pager2.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : 'pager_test',
		//链接尾部
		hrefLatter : '.html',
		getLink : function(n) {
			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
		}
		
		//lang参数,选择设置，见js
		
		//click模式
		,
		mode : 'click',//默认值是link，可选link或者click
		click : function(n) {
			this.selectPage(n);
			return false;
		}
	});
});*/
/*李丽梅 pager2部分结束*/
/*王延君 pager3部分开始*/
/*2016-4-11*/
/*我的账户-资金管理-收支明细-提现记录*/
var pager3 = {
		pagerid 			: 'pager3', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager3_gopage_wrap',
		gopageButtonId		: 'pager3_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager3_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText			    : '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText		: '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager3.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,true);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText2 || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager3.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager3.focus_gopage()"  onkeypress="return pager3.keypress_gopage(event);"   onblur="pager3.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager3._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
/*$(function() {
	var totalPage = 160;//总页数
	var totalRecords = 390;//总记录条数
	var pageNo = getParameter('pno');//当前页
	if (!pageNo) {
		pageNo = 1;
	}
	//生成分页
	//有些参数是可选的，比如lang，若不传有默认值
	pager3.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : 'pager_test',
		//链接尾部
		hrefLatter : '.html',
		getLink : function(n) {
			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
		}
		
		//lang参数,选择设置，见js
		
		//click模式
		,
		mode : 'click',//默认值是link，可选link或者click
		click : function(n) {
			this.selectPage(n);
			return false;
		}
	});
});*/
/*王延君 pager3部分结束*/
/*王延君 pager4部分开始*/
/*2016-4-11*/
/*我的账户-资金管理-收支明细-提现记录*/
var pager4 = {
		pagerid 			: 'pager4', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager4_gopage_wrap',
		gopageButtonId		: 'pager4_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager4_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText			    : '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText		: '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager4.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,true);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText2 || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager4.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager4.focus_gopage()"  onkeypress="return pager4.keypress_gopage(event);"   onblur="pager4.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager4._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
/*$(function() {
	var totalPage = 160;//总页数
	var totalRecords = 390;//总记录条数
	var pageNo = getParameter('pno');//当前页
	if (!pageNo) {
		pageNo = 1;
	}
	//生成分页
	//有些参数是可选的，比如lang，若不传有默认值
	pager4.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : 'pager_test',
		//链接尾部
		hrefLatter : '.html',
		getLink : function(n) {
			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
		}
		
		//lang参数,选择设置，见js
		
		//click模式
		,
		mode : 'click',//默认值是link，可选link或者click
		click : function(n) {
			this.selectPage(n);
			return false;
		}
	});
});*/
/*王延君 pager4部分结束*/
/*王延君 pager5部分开始*/
/*2016-4-11*/
/*我的账户-资金管理-收支明细-提现记录*/
var pager5 = {
		pagerid 			: 'pager5', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager5_gopage_wrap',
		gopageButtonId		: 'pager5_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager5_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText			    : '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText		: '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager5.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,true);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			this.init(config);
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText2 || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager5.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager5.focus_gopage()"  onkeypress="return pager5.keypress_gopage(event);"   onblur="pager5.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager5._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
//$(function() {
//	var totalPage = 160;//总页数
//	var totalRecords = 390;//总记录条数
//	var pageNo = getParameter('pno');//当前页
//	if (!pageNo) {
//		pageNo = 1;
//	}
//	//生成分页
//	//有些参数是可选的，比如lang，若不传有默认值
//	pager5.generPageHtml({
//		pno : pageNo,
//		//总页码
//		total : totalPage,
//		//总数据条数
//		totalRecords : totalRecords,
//		//链接前部
//		hrefFormer : 'pager_test',
//		//链接尾部
//		hrefLatter : '.html',
//		getLink : function(n) {
//			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
//		}
//		
//		//lang参数,选择设置，见js
//		
//		//click模式
//		,
//		mode : 'click',//默认值是link，可选link或者click
//		click : function(n) {
//			this.selectPage(n);
//			return false;
//		}
//	});
//});
/*王延君 pager5部分结束*/

/*王延君 pager6部分开始*/
/*2016-4-11*/
/*我的账户-资金管理-收支明细-提现记录*/
var pager6 = {
		pagerid 			: 'pager6', //divID
		mode				: 'link', //模式(link 或者 click)
		pno					: 1, //当前页码
		total				: 1, //总页码
		totalRecords		: 0, //总数据条数
		isShowFirstPageBtn	: false,//是否显示首页按钮
		isShowLastPageBtn	: false,//是否显示尾页按钮
		isShowPrePageBtn	: true, //是否显示上一页按钮
		isShowNextPageBtn	: true, //是否显示下一页按钮
		isShowTotalPage 	: true, //是否显示总页数
		isShowCurrPage		: false,//是否显示当前页
		isShowTotalRecords 	: false, //是否显示总记录数
		isGoPage 			: true,	//是否显示页码跳转输入框
		isGoPage 			: true,
		isWrapedPageBtns	: false,	//是否用span包裹住页码按钮
		isWrapedInfoTextAndGoPageBtn : false, //是否用span包裹住分页信息和跳转按钮
		hrefFormer			: '', //链接前部
		hrefLatter			: '', //链接尾部
		gopageWrapId		: 'pager6_gopage_wrap',
		gopageButtonId		: 'pager6_btn_go',
		isgopageButtonId    : true,
		gopageTextboxId		: 'pager6_btn_go_input',
		lang				: {
			/*firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',*/
			prePageText			    : '<',
			prePageTipText			: '<',
			nextPageText			: '>',
			nextPageTipText		: '>',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			/*currPageBeforeText		: '当前第',
			currPageAfterText		: '页',*/
			/*totalInfoSplitStr		: '/',*/
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;跳到第&nbsp;',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '&nbsp;页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		},
		//链接算法（当处于link模式）,参数n为页码
		getLink	: function(n){
			//这里的算法适用于比如：
			//hrefFormer=http://www.xx.com/news/20131212
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		},
		//页码单击事件处理函数（当处于mode模式）,参数n为页码
		click	: function(n){
			//这里自己实现
			//这里可以用this或者pager访问pager对象
			return false;
		},
		//获取href的值（当处于mode模式）,参数n为页码
		getHref	: function(n){
			//默认返回'#'
			return '#';
		},
		//跳转框得到输入焦点时
		focus_gopage : function (){
			var btnGo = $('#'+this.gopageButtonId);
			$('#'+this.gopageTextboxId).attr('hideFocus',true);
			btnGo.show();
			btnGo.css('left','10px');
			$('#'+this.gopageTextboxId).addClass('focus');
			btnGo.animate({left: '+=28'}, 160);
		},
		//跳转框失去输入焦点时
		blur_gopage : function(){
			var _this = this;
			setTimeout(function(){
				var btnGo = $('#'+_this.gopageButtonId);
				btnGo.animate({
				    left: '-=30'
				  }, 160, function(){
					  btnGo.hide();
					  $('#'+_this.gopageTextboxId).removeClass('focus');
				  });
			},200);
		},
		//跳转输入框按键操作
		keypress_gopage : function(){
			var event = arguments[0] || window.event;
			var code = event.keyCode || event.charCode;
			//delete key
			if(code == 8) return true;
			//enter key
			if(code == 13){
				pager6.gopage();
				return false;
			}
			//copy and paste
			if(event.ctrlKey && (code == 99 || code == 118)) return true;
			//only number key
			if(code<48 || code>57)return false;
			return true;
		},
		//跳转框页面跳转
		gopage : function(){
			var str_page = $('#'+this.gopageTextboxId).val();
			if(isNaN(str_page)){
				$('#'+this.gopageTextboxId).val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1) n = 1;
			if(n > this.total) n = this.total;
			if(this.mode == 'click'){
				this._clickHandler(n);
			}else{
				window.location = this.getLink(n);
			}
		},
		//不刷新页面直接手动调用选中某一页码
		selectPage : function(n){
			this._config['pno'] = n;
			this.generPageHtml(this._config,false);
		},
		//生成控件代码
		generPageHtml : function(config,enforceInit){
			if(enforceInit || !this.inited){
				this.init(config);
			}
			
			var str_first='',str_prv='',str_next='',str_last='';
			if(this.isShowFirstPageBtn){
				if(this.hasPrv){
					str_first = '<a '+this._getHandlerStr(1)+' title="'
						+(this.lang.firstPageTipText || this.lang.firstPageText)+'">'+this.lang.firstPageText+'</a>';
				}else{
					str_first = '<span class="disabled">'+this.lang.firstPageText+'</span>';
				}
			}
			if(this.isShowPrePageBtn){
				if(this.hasPrv){
					str_prv = '<a '+this._getHandlerStr(this.prv)+' title="'
						+(this.lang.prePageTipText2 || this.lang.prePageText)+'">'+this.lang.prePageText+'</a>';
				}else{
					str_prv = '<span class="disabled">'+this.lang.prePageText+'</span>';
				}
			}
			if(this.isShowNextPageBtn){
				if(this.hasNext){
					str_next = '<a '+this._getHandlerStr(this.next)+' title="'
						+(this.lang.nextPageTipText || this.lang.nextPageText)+'">'+this.lang.nextPageText+'</a>';
				}else{
					str_next = '<span class="disabled">'+this.lang.nextPageText+'</span>';
				}
			}
			if(this.isShowLastPageBtn){
				if(this.hasNext){
					str_last = '<a '+this._getHandlerStr(this.total)+' title="'
						+(this.lang.lastPageTipText || this.lang.lastPageText)+'">'+this.lang.lastPageText+'</a>';
				}else{
					str_last = '<span class="disabled">'+this.lang.lastPageText+'</span>';
				}
			}
			var str = '';
			var dot = '<span class="spanDot">...</span>';
			var total_info='<span class="totalText">';
			var total_info_splitstr = '<span class="totalInfoSplitStr">'+this.lang.totalInfoSplitStr+'</span>';
			if(this.isShowCurrPage){
				total_info += this.lang.currPageBeforeText + '<span class="currPageNum">' + this.pno + '</span>' + this.lang.currPageAfterText;
				if(this.isShowTotalPage){
					total_info += total_info_splitstr;
					total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;
				}else if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalPage){
				total_info += this.lang.totalPageBeforeText + '<span class="totalPageNum">'+this.total + '</span>' + this.lang.totalPageAfterText;;
				if(this.isShowTotalRecords){
					total_info += total_info_splitstr;
					total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
				}
			}else if(this.isShowTotalRecords){
				total_info += this.lang.totalRecordsBeforeText + '<span class="totalRecordNum">'+this.totalRecords + '</span>' + this.lang.totalRecordsAfterText;
			}
			total_info += '</span>';
			
			var gopage_info = '';
			/*if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager.focus_gopage()"  onkeypress="return pager.keypress_gopage(event);"   onblur="pager.blur_gopage()" value="'+this.next+'" /></span>'+this.lang.gopageAfterText+'</span>';
			}*/
			if(this.isGoPage){
				gopage_info = '<span class="goPageBox">'+this.lang.gopageBeforeText+'<span id="'+this.gopageWrapId+'">'+
					'<input type="button" id="'+this.gopageButtonId+'" onclick="pager6.gopage()" value="'
						+this.lang.gopageButtonOkText+'" />'+
					'<input type="text" id="'+this.gopageTextboxId+'" onfocus="pager6.focus_gopage()"  onkeypress="return pager6.keypress_gopage(event);"   onblur="pager6.blur_gopage()" /></span>'+this.lang.gopageAfterText+'</span>';
			}
			
			//分页处理
			if(this.total <= 8){
				for(var i=1;i<=this.total;i++){
					if(this.pno == i){
						str += '<span class="curr">'+i+'</span>';
					}else{
						str += '<a '+this._getHandlerStr(i)+' title="'
							+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
					}
				}
			}else{
				if(this.pno <= 5){
					for(var i=1;i<=7;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'+
								this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					str += dot;
				}else{
					str += '<a '+this._getHandlerStr(1)+' title="'
						+this.lang.buttonTipBeforeText + '1' + this.lang.buttonTipAfterText+'">1</a>';
					str += '<a '+this._getHandlerStr(2)+' title="'
						+this.lang.buttonTipBeforeText + '2' + this.lang.buttonTipAfterText +'">2</a>';
					str += dot;
					
					var begin = this.pno - 2;
					var end = this.pno + 2;
					if(end > this.total){
						end = this.total;
						begin = end - 4;
						if(this.pno - begin < 2){
							begin = begin-1;
						}
					}else if(end + 1 == this.total){
						end = this.total;
					}
					for(var i=begin;i<=end;i++){
						if(this.pno == i){
							str += '<span class="curr">'+i+'</span>';
						}else{
							str += '<a '+this._getHandlerStr(i)+' title="'
								+this.lang.buttonTipBeforeText + i + this.lang.buttonTipAfterText+'">'+i+'</a>';
						}
					}
					if(end != this.total){
						str += dot;
					}
				}
			}
			var pagerHtml = '<div class="pager-con">';
			if(this.isWrapedPageBtns){
				pagerHtml += '<span class="pageBtnWrap">' + str_first + str_prv + str + str_next + str_last + '</span>';
			}else{
				pagerHtml += str_first + str_prv + str + str_next + str_last;
			}
			if(this.isWrapedInfoTextAndGoPageBtn){
				pagerHtml += '<span class="infoTextAndGoPageBtnWrap">' + total_info + gopage_info + '</span>';
			}else{
				pagerHtml += total_info + gopage_info;
			}
			pagerHtml += '<div class="cc"></div></div>';
			$("#"+this.pagerid).html(pagerHtml);
		},
		//分页按钮控件初始化
		init : function(config){
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.total = isNaN(config.total) ? 1 : parseInt(config.total);
			this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
			if(config.pagerid){this.pagerid = config.pagerid;}
			if(config.mode){this.mode = config.mode;}
			if(config.gopageWrapId){this.gopageWrapId = config.gopageWrapId;}
			if(config.gopageButtonId){this.gopageButtonId = config.gopageButtonId;}
			if(config.gopageTextboxId){this.gopageTextboxId = config.gopageTextboxId;}
			if(config.isShowFirstPageBtn != undefined){this.isShowFirstPageBtn=config.isShowFirstPageBtn;}
			if(config.isShowLastPageBtn != undefined){this.isShowLastPageBtn=config.isShowLastPageBtn;}
			if(config.isShowPrePageBtn != undefined){this.isShowPrePageBtn=config.isShowPrePageBtn;}
			if(config.isShowNextPageBtn != undefined){this.isShowNextPageBtn=config.isShowNextPageBtn;}
			if(config.isShowTotalPage != undefined){this.isShowTotalPage=config.isShowTotalPage;}
			if(config.isShowCurrPage != undefined){this.isShowCurrPage=config.isShowCurrPage;}
			if(config.isShowTotalRecords != undefined){this.isShowTotalRecords=config.isShowTotalRecords;}
			if(config.isWrapedPageBtns){this.isWrapedPageBtns=config.isWrapedPageBtns;}
			if(config.isWrapedInfoTextAndGoPageBtn){this.isWrapedInfoTextAndGoPageBtn=config.isWrapedInfoTextAndGoPageBtn;}
			if(config.isGoPage != undefined){this.isGoPage=config.isGoPage;}
			if(config.lang){
				for(var key in config.lang){
					this.lang[key] = config.lang[key];
				}
			}
			this.hrefFormer = config.hrefFormer || '';
			this.hrefLatter = config.hrefLatter || '';
			if(config.getLink && typeof(config.getLink) == 'function'){this.getLink = config.getLink;}
			if(config.click && typeof(config.click) == 'function'){this.click = config.click;}
			if(config.getHref && typeof(config.getHref) == 'function'){this.getHref = config.getHref;}
			if(!this._config){
				this._config = config;
			}
			//validate
			if(this.pno < 1) this.pno = 1;
			this.total = (this.total <= 1) ? 1: this.total;
			if(this.pno > this.total) this.pno = this.total;
			this.prv = (this.pno<=2) ? 1 : (this.pno-1);
			this.next = (this.pno >= this.total-1) ? this.total : (this.pno + 1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.total);
			this.inited = true;
		},
		_getHandlerStr : function(n){
			if(this.mode == 'click'){
				return 'href="'+this.getHref(n)+'" onclick="return pager6._clickHandler('+n+')"';
			}
			//link模式，也是默认的
			return 'href="'+this.getLink(n)+'"';
		},
		_clickHandler	: function(n){
			var res = false;
			if(this.click && typeof this.click == 'function'){
				res = this.click.call(this,n) || false;
			}
			return res;
		}
};
/*分页*/
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//init初始化
//$(function() {
//	var totalPage = 160;//总页数
//	var totalRecords = 390;//总记录条数
//	var pageNo = getParameter('pno');//当前页
//	if (!pageNo) {
//		pageNo = 1;
//	}
	//生成分页
	//有些参数是可选的，比如lang，若不传有默认值
//	pager6.generPageHtml({
//		pno : pageNo,
//		//总页码
//		total : totalPage,
//		//总数据条数
//		totalRecords : totalRecords,
//		//链接前部
//		hrefFormer : 'pager_test',
//		//链接尾部
//		hrefLatter : '.html',
//		getLink : function(n) {
//			return this.hrefFormer + this.hrefLatter + "?pno=" + n;//自定义格式
//		}
//		
//		//lang参数,选择设置，见js
//		
//		//click模式
//		,
//		mode : 'click',//默认值是link，可选link或者click
//		click : function(n) {
//			this.selectPage(n);
//			return false;
//		}
//	});
//});
/*王延君 pager6部分结束*/