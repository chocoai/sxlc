<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="projectCourse" id="projectCourse"> 
	
</div>
<script type="text/html" id="project_course">
	{{if recordDate!=null}}
	<div class="submit-application pro-state clearfix">
		<div class="pro-ing submit-application">
			<div>提交申请</div>
			<span>{{$toDelete recordDate}}</span>
		</div>
	</div>
	<img src="resource/img/invest/xmlc_08.jpg" class="pro-line-icon">
	{{/if}}
	{{if releaseDate!=null}}
	<div class="pass pro-state clearfix">
		<div class="pro-ing pro-pass">
			<div>审核通过</div>
			<span>{{$toDelete releaseDate}}</span>
		</div>
	</div>
	<img src="resource/img/invest/xmlc_08.jpg" class="pro-line-icon">
	{{/if}}
	{{if startDate!=null}}
	<div class="start-raise pro-state clearfix">
		<div class="pro-ing start-raising">
			<div>开始筹集</div>
			<span>{{$toDelete startDate}}</span>
		</div>
	</div>
	<img src="resource/img/invest/xmlc_08.jpg" class="pro-line-icon">
	{{/if}}
	{{if holdDate!=null}}
	<div class="pro-loan pro-state clearfix">
		<div class="pro-ing pro-loan">
			<div>项目放款</div>
			<span>{{$toDelete holdDate}}</span>
		</div>
	</div>
	<img src="resource/img/invest/xmlc_08.jpg" class="pro-line-icon">
	{{/if}}
	
	<div class="pro-repay pro-state clearfix">
		<div class="pro-ing pro-repay">
			<div>项目还款</div>
			<span>{{$toDelete repayTime}}</span>
		</div>
		<!--弹出层  -->
			<div class="proLi clearfix">
			<img src="resource/img/invest/xmlc_jj_03.png">
			<ul class="table proli-table">
			   <li>
			      <div>还款期数</div>
			      <div>还款总金额</div>
			      <div>还款时间</div>		             
			   </li>
				{{each info as value index}}
			   		<li>
			      		<div>第{{index+1}}期</div>
			      		<div>{{$toFixed value.sdPrincipalInterests}}</div>
			      		<div>{{$timeFixed value.repayMaxTime}}</div>
			   		</li>
				{{/each}}
			</ul>
		</div>
	</div>
	<img src="resource/img/invest/xmlc_08.jpg" class="pro-line-icon">
	{{if settleDate!=null}}
	<div class="pro-settle pro-state clearfix">
		<div class="pro-ing pro-end">
			<div>项目结清</div>
			<span>{{$toDelete settleDate}}</span>
		</div>
	</div>
	{{/if}}
</script>