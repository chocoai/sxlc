<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="postLoanSupervision">
	<img class="line_top" src="resource/img/invest/dhjg_b.jpg">
	<ul class="time-line" id="time-line">

	</ul>	
	<script type="text/html" id="postLoanList">
		{{each json as value index}}
			<li class="clearfix">
				<div class="info-top">
					<div class="info-top-time">{{$timeFixed value.recordDate}}</div>
					<img class="dot" src="resource/img/invest/dhjg_zk_04.png">
					<div class="info-top-middle">
						<div class="info-top-content">
						</div>
					</div>
				</div>
				<div class="info-bottom">
					<div class="info-bottom-time">{{$timeFixed value.recordDate}}</div>
					<img class="dot" src="resource/img/invest/dhjg_zk_04.png">
					<div class="info-bottom-middle">
						<div class="info-bottom-content"  data-id={{value.id}}>{{value.abstracts}}</div>
					</div>
				</div>
			</li>
		{{/each}}
	</script>
	<img class="line_bottom" src="resource/img/invest/dhjg_b2.jpg">
</div>