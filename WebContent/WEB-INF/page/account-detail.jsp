<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>圆梦中心</title>
        <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/images/icons/css/font-awesome.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/googleapis.css"
            rel="stylesheet">
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i></a><a class="brand" href="#">圆梦中心 </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                        <ul class="nav pull-right">
                         
                            <li><a href="#">欢迎你：${sessionScope.uname}</a></li>
                           	<li><a href="${pageContext.request.contextPath}/login.jsp">退出</a></li>
                        </ul>
                    </div>
                    <!-- /.nav-collapse -->
                </div>
            </div>
            <!-- /navbar-inner -->
        </div>
        <!-- /navbar -->
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <div class="sidebar">
                            <ul class="widget widget-menu unstyled">
                                    <li><a class="collapsed" data-toggle="collapse" href="#account"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>人员中心 <b class="label green pull-right">
                                    11</b>  </a>
                                    <ul id="account" class="collapse unstyled">
                                        <li><a href="${pageContext.request.contextPath}/accountController/getaccount.action"><i class="icon-inbox"></i>会员列表 <b class="label green pull-right">
                                    11</b>  </a></li>
                                        <li><a href="${pageContext.request.contextPath}/agencyController/getagents.action"><i class="icon-inbox"></i>代理商列表 </a></li>
                                    </ul>
                                </li>
                            
                            </ul>
                            <!--/.widget-nav-->
                            <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#article"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>文章中心 <b class="label green pull-right">
                                    11</b>  </a>
                                    <ul id="article" class="collapse unstyled">
                                        <li><a href="${pageContext.request.contextPath}/articleController/skiparticle.action"><i class="icon-inbox"></i>发布文章 <b class="label green pull-right">
                                    11</b>  </a></li>
                                        <li><a href="${pageContext.request.contextPath}/articleController/getarticle.action"><i class="icon-inbox"></i>文章列表 </a></li>
                                        <li><a href="${pageContext.request.contextPath}/articleController/queryarticlebyid.action?uId=${sessionScope.uid}"><i class="icon-inbox"></i>我的文章 </a></li>
                                    </ul>
                                </li>
                            
                            </ul>
                            <!--/.widget-nav-->
                            <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#video"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>视频中心 </a>
                                    <ul id="video" class="collapse unstyled">
                                        <li><a href="${pageContext.request.contextPath}/videoController/getUploadPage.action"><i class="icon-inbox"></i>视频上传 </a></li>
                                        <li><a href="${pageContext.request.contextPath}/videoController/getAllVideoToWeb.action"><i class="icon-inbox"></i>视频列表 </a></li>
                                        <li><a href="${pageContext.request.contextPath}/videoController/getAllCommentToWeb.action"><i class="icon-inbox"></i>评论管理 </a></li>
                                        <li><a href="#"><i class="icon-inbox"></i>申请记录 </a></li>
                                    </ul>
                                </li> 
                            </ul>
                                <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#agency"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>管理中心 </a>
                                    <ul id="agency" class="collapse unstyled">
                                        <li><a href="edit-admin.jsp"><i class="icon-inbox"></i>运营用户信息 </a></li> 
                                         <li><a href="${pageContext.request.contextPath}/otherController/getallwithdrawal.action"><i class="icon-inbox"></i>提现审核 </a></li> 
                                          <li><a href="${pageContext.request.contextPath}/agencyController/getapply.action"><i class="icon-inbox"></i>代理商审核 </a></li> 
                                          <li><a href="${pageContext.request.contextPath}/videoController/getapply.action"><i class="icon-inbox"></i>视频创作者审核 </a></li> 
                                        <li><a href="${pageContext.request.contextPath}/packageController/getallpackage.action"><i class="icon-inbox"></i>礼包及比例调整 </a></li>
                                        	<li><a href="service.jsp"><i class="icon-inbox"></i>自助客服修改 </a></li>  
                                    </ul>
                                </li>
                            </ul>    
                               <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#store"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>商城中心 </a>
                                    <ul id="store" class="collapse unstyled">
                                    <li><a href="#"><i class="icon-inbox"></i>我的商品</a></li> 
                                     <li><a href="#"><i class="icon-inbox"></i>上传商品</a></li> 
                                      <li><a href="#"><i class="icon-inbox"></i>订单管理</a></li> 
                                    </ul>
                                </li>
                            </ul>   
                               <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#live"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>直播中心 </a>
                                    <ul id="live" class="collapse unstyled">
                                     <li><a href="#"><i class="icon-inbox"></i>所有房间</a></li> 
                                      <li><a href="#"><i class="icon-inbox"></i>房间管理</a></li> 
                                    </ul>
                                </li>
                            </ul>    
                               <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#statistics"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>统计中心 </a>
                                    <ul id="statistics" class="collapse unstyled">
                                     <li><a href="#"><i class="icon-inbox"></i>会员统计</a></li> 
                                      <li><a href="#"><i class="icon-inbox"></i>代理商统计</a></li> 
                                       <li><a href="#"><i class="icon-inbox"></i>文章统计</a></li> 
                                        <li><a href="#"><i class="icon-inbox"></i>视频统计</a></li> 
                                    </ul>
                                </li>
                            </ul>                        
                             <ul class="widget widget-menu unstyled">
                             <li><a href="login.jsp"><i class="menu-icon icon-signout"></i>退出</a></li>
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                       <div class="module">
							<div class="module-head">
								<h3>会员信息</h3>
							</div> <br>
							<div class="module-body">
                                      <form class="form-horizontal row-fluid"  action="${pageContext.request.contextPath}/accountController/updateaccount.action?mId=${member.getmId()}" method="post">
				
										<div class="control-group">
											<label class="control-label" for="basicinput">会员编号：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="uId" class="span8" disabled value="${member.getmId()}">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">真实名字：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="uName" class="span8" disabled  value="${member.getUser().getuName()}">
											</div>
										</div>
                                    
                                    <div class="control-group">
											<label class="control-label" for="basicinput">性别：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="uSex" class="span8" disabled  value="${member.getUser().getuSex()}">
											</div>
										</div>
										
										  <div class="control-group">
											<label class="control-label" for="basicinput">联系电话：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="uPhone" class="span8" disabled  value="${member.getUser().getuPhone()}">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">会员生日：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="birthday" class="span8" disabled  value="${member.getBirthday()}">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">会员邮箱：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="mail" class="span8" disabled  value="${member.getMail()}">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">支付宝账号：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="alipay" class="span8" disabled  value="${member.getAlipay()}">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">微信号：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="wechat" class="span8" disabled value="${member.getWechat()}">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">上属一级代理商：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="firstSuperior"  class="span8" disabled value="${member.getFirstSuperior()}">
											<span class="help-inline">该编号为用户编号</span>
											</div>
										</div>
										
											<div class="control-group">
											<label class="control-label" for="basicinput">上属二级代理商：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;" name="secondSuperior"  class="span8" disabled value="${member.getSecondSuperior()}">
												<span class="help-inline">该编号为用户编号</span>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">会员介绍人：</label>
											<div class="controls" >
												<input type="text" style="text-align:center;"  name="introducer"   class="span8" disabled value="${member.getIntroducer()}">
												<span class="help-inline">该编号为用户编号</span>
											</div>
										</div>
																		
										<div class="control-group">
											<label class="control-label" for="basicinput">返利比例：</label>
											<div class="controls">
												<div class="input-append">
													<input type="number"  name="Bate"  min="0" max="100" value="${member.getBate()}" class="span8"><span class="add-on">%</span>
												</div>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">奖励积分：</label>
											<div class="controls">
												<div class="input-append">
													<input type="number"  name="bonusIntegral"  min="0" value="${member.getBonusIntegral()}" class="span8"><span class="add-on">分</span>
												</div>
											</div>
										</div>
										
											<div class="control-group">
											<label class="control-label" for="basicinput">消费积分：</label>
											<div class="controls">
												<div class="input-append">
													<input type="number"  name="consumptionIntegral"  min="0" value="${member.getConsumptionIntegral()}" class="span8"><span class="add-on">分</span>
												</div>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">分享积分：</label>
											<div class="controls">
												<div class="input-append">
													<input type="number"  name="sharingIntegral"  min="0" value="${member.getSharingIntegral()}" class="span8"><span class="add-on">分</span>
												</div>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">提现限额：</label>
											<div class="controls">
												<div class="input-append">
													<input type="number"  name="drwaralQuota"  min="0" value="${member.getDrwaralQuota()}" class="span8"><span class="add-on">分</span>
												</div>
											</div>
										</div>
										
										<div class="control-group">
											<div class="controls">
												<button type="submit" class="btn btn-info">提交</button>
											</div>
										</div>
										
                                    </form>
                                </div>
                                </div>
                            </div>
                            <!--/.module-->
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
       
        <!--/.wrapper-->
        <div class="footer">
            <div class="container">
                <b class="copyright">&copy; 2014 Edmin - EGrappler </b>All rights reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/common.js" type="text/javascript"></script>
      
    </body>
</html>