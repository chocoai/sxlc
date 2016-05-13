<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="bottom">
	<div>
		<div class="bottomTop">
			<div>
				<div class="linkArea">
					<div class="linkAreaLine">
						<div class="linkAreaTh">关于我们</div>
						<div class="linkAreaTd"><a href="aboutUs/platformIntroduction.html">公司简介</a></div>
						<div class="linkAreaTd"><a href="">组织架构</a></div>
						<div class="linkAreaTd"><a href="aboutUs/webBoard.html">网站公告</a></div>
						<div class="linkAreaTd"><a href="">公司证照</a></div>
					</div>				
					<div class="linkAreaLine">
						<div class="linkAreaTh">安全保障</div>
						<div class="linkAreaTd"><a href="">投资安全</a></div>
						<div class="linkAreaTd"><a href="">信息安全</a></div>
						<div class="linkAreaTd"><a href="">资金安全</a></div>
						<div class="linkAreaTd"><a href="aboutUs/legalRegulation.html">政策法规</a></div>
					</div>				
					<div class="linkAreaLine">
						<div class="linkAreaTh">帮助中心</div>
						<div class="linkAreaTd"><a href="aboutUs/newbieGuide.html">新手指引</a></div>
						<div class="linkAreaTd"><a href="aboutUs/investmentZone.html">我要投资</a></div>
						<div class="linkAreaTd"><a href="aboutUs/loan.html">我要借款</a></div>
						<div class="linkAreaTd"><a href="aboutUs/commonProblem.html">常见问题</a></div>
					</div>				
				</div>
				<div class="qrcodeArea">
					<div class="qrcodeTd">
						<div class="qrcodeImg">
							<img src="resource/img/common/qrcode.png">
						</div>
						<div class="qrcodeDiscript">官方微信</div>
					</div>
					<div class="qrcodeTd">
						<div class="qrcodeImg">
							<img src="resource/img/common/qrcode.png">
						</div>
						<div class="qrcodeDiscript">IOS客户端下载</div>
					</div>
					<div class="qrcodeTd">
						<div class="qrcodeImg">
							<img src="resource/img/common/qrcode.png">
						</div>
						<div class="qrcodeDiscript">安卓客户端下载</div>
					</div>
				</div>
				<div class="serviceArea">
					<div class="serviceArea1">400-888-6802</div>
					<div class="serviceArea2">（服务时间：9:00-21:00）</div>
					<div class="serviceArea3">服务邮箱：616489358@163.com</div>
				</div>
			</div>
		</div>
		<div class="bottomBottom">
			<div class="bottomBottomLine1" id="ship">
				<script id="shipList" type="text/html">
					<span>友情链接：</span>
					{{each data as value index}}
						<a href="{{value.url}}" target="_blank">{{value.name}}</a>
					{{/each}}
				</script>
			</div>
			<div class="bottomBottomLine1">
				<span>Copyright(c)蜀ICP备10201230号-1 成都四象联创科技有限公司 .All rights reserved.</span>
				<span class="technicalSupport" onclick="window.location='aboutUs/platformIntroduction.html'">技术支持：成都四象联创科技有限公司</span>
			</div>
			<div class="bottomBottomLine2">
				<div>
					<label class="bottom1Png"></label>
				</div>
				<div>
					<label class="bottom2Png"></label>
				</div>
				<div>
					<label class="bottom3Png"></label>
				</div>
				<div>
					<label class="bottom4Png"></label>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="js/common/footer.js" ></script>