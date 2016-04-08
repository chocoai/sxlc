<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
  <head>
  	<base href="<%=basePath%>">
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
    <title>后台登录</title>
  </head>
<body style="background:#F7F7F7;">
    <div class="">
        <a class="hiddenanchor" id="toregister"></a>
        <a class="hiddenanchor" id="tologin"></a>

        <div id="wrapper">
            <div id="login" class="animate form">
                <section class="login_content">
                    <form>
                        <h1>登&nbsp;&nbsp;&nbsp;&nbsp;录</h1>
                        <div>
                            <input type="text" name="adminName" id="adminName" class="form-control" placeholder="用户名" required="" />
                        </div>
                        <div>
                            <input type="password" class="form-control" name="adminPwd" id="adminPwd" placeholder="密码" required="" />
                        </div>
                        <div>
                        	<img class="icode" src="resoures/img/indentifyicode.jpg" ></img>
                            <input type="text" class="form-control" placeholder="验证码" required="" />
                        </div>
                        <div>
                            <a class="btn btn-default submit" id="loginBtn" href="javascript:void(0)">登  录</a>
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">

                            <p class="change_link">忘记密码?
                                <a href="web/index/index_lg.jsp#toregister" class="to_register"> 找回 </a>
                            </p>
                            <div class="clearfix"></div>
                            <br />
                            <jsp:include page="../common/cm-bottom.jsp"></jsp:include>
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
            <div id="register" class="animate form">
                <section class="login_content">
                    <form>
                        <h1>找回密码</h1>
                        <div>
                            <input type="text" class="form-control" placeholder="手机号" required="" />
                        </div>
                        <div class="identifyingcode">
                        	<input type="text" class="form-control" placeholder="" required="" />
                            <a class="btn btn-default submit" href="web/index/index_lg.jsp#tologin">获取手机验证码</a>
                        </div>
                        <div>
                            <input type="password" class="form-control" placeholder="输入新密码" required="" />
                        </div>
                        <div>
                            <input type="password" class="form-control" placeholder="确认新密码" required="" />
                        </div>
                        <div>
                            <a class="btn btn-default submit" href="web/index/index_lg.jsp#tologin">确认并重新登陆</a>
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">
                            <!-- <p class="change_link">修改完成？
                                <a href="web/index/index_lg.jsp#tologin" class="to_register"> 登录 </a>
                            </p> -->
                            <div class="clearfix"></div>
                            <br />
                            <jsp:include page="../common/cm-bottom.jsp"></jsp:include>
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
        </div>
    </div>
</body>  
</html>
