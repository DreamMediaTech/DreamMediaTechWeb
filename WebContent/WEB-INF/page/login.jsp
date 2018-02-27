<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/googleapis.css"
            rel="stylesheet">
<title>圆梦中心后台登陆</title>
</head>
<body>
<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
					<i class="icon-reorder shaded"></i>
				</a>

			  	<a class="brand" href="index.html">
			  		圆梦传媒
			  	</a>

				<div class="nav-collapse collapse navbar-inverse-collapse">
				
					<ul class="nav pull-right">

						<li><a href="#">
							登陆
						</a></li>
					<li><a href="#">
							忘记密码？
						</a></li>
					</ul>
				</div><!-- /.nav-collapse -->
			</div>
		</div><!-- /navbar-inner -->
	</div><!-- /navbar -->



	<div class="wrapper">
		<div class="container">
			<div class="row">
				<div class="module module-login span4 offset4">
					<form class="form-vertical"   action="${pageContext.request.contextPath}/loginController/weblogin.action"  method="post">
						<div class="module-head">
							<h3>登陆</h3>
						</div>
						<div class="module-body">
							<div class="control-group">
								<div class="controls row-fluid">
									<input class="span12" type="text" name="ymId" id="ymId" placeholder="账号">
								</div>
							</div>
							<div class="control-group">
								<div class="controls row-fluid">
									<input class="span12" type="password" id="uPassword" name="uPassword" placeholder="密码">
								</div>
							</div>
						</div>
						<div class="module-foot">
							<div class="control-group">
								<div class="controls clearfix">
									<button type="submit" class="btn btn-primary pull-right">登陆</button>
									<label class="checkbox">
										<input type="checkbox"> 记住密码
									</label>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div><!--/.wrapper-->

	<div class="footer">
		 <div class="container">
                <b class="copyright">&copy; 2018 TMOD9527 - EGrappler </b>All rights reserved. More Templates 
            </div>
	</div>
	<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>