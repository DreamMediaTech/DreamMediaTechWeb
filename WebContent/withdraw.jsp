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
										<li><a href="${pageContext.request.contextPath}/articleController/getarticlerequest.action"><i class="icon-inbox"></i>文章审核中心 </a></li>
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
                                        <li><a href="${pageContext.request.contextPath}/function_roleController/queryrole.action"><i class="icon-inbox"></i>角色管理 </a></li> 
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
                             <li><a href="login.jsp"><i class="menu-icon icon-signout"></i>退出</a></li>
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                            	<div class="module message">
							<div class="module-head">
								<h3>提现审核</h3>
							</div>
							<div class="module-option clearfix">
								<div class="pull-left">
									选项 : &nbsp;
									<div class="btn-group">
										<button onclick="javascript:window.location.href='${pageContext.request.contextPath}/otherController/getallwithdrawal.action'" class="btn">所有</button>
										<button class="btn dropdown-toggle" data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${pageContext.request.contextPath}/otherController/getnowithdrawal.action">待审核 <b class="label green pull-right">
                                    11</b></a></li>
											<li><a href="${pageContext.request.contextPath}/otherController/getonwithdrawal.action">通过</a></li>
											<li><a  href="${pageContext.request.contextPath}/otherController/getoffwithdrawal.action">未通过</a></li>
										
										</ul>
									</div>
								</div>
								
							</div>
							<div class="module-body table">								

								<table class="datatable-1 table table-message">
								<thead>
									
										<tr class="heading" >
											
											<td class="cell-title" style="text-align:center;vertical-align:middle;">单号</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">会员ID</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">申请人姓名</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">提现时间</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">提现金额</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">处理时间</td>
											<td class="cell-status hidden-phone hidden-tablet" style="text-align:center;vertical-align:middle;">状态</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">经手人</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">操作</td>
											
										</tr>
										</thead>
										<tbody>
										<c:forEach items="${list}" var="list">
										<tr class="task"  >
											
											<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getBwId()}</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getuId().getmId()}</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getuId().getuName()}</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getBwTime()}</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getMoney()}</td>
											<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getBwtoTime()}</td>
											<td class="cell-status hidden-phone hidden-tablet" style="text-align:center;vertical-align:middle;"><c:if test="${list.getBwState()=='待审核'}"><b class="due"></c:if>${list.getBwState()}</b></td>
												<td class="cell-title" style="text-align:center;vertical-align:middle;">${list.getBwName()}</td>
											
											<td class="cell-title"  style="text-align:center;vertical-align:middle;">
											<c:if test="${list.getBwState()=='待审核'}">
											<input type ="button"  onclick="javascript:window.location.href='${pageContext.request.contextPath}/otherController/updatewithdrawaly.action?BwId=${list.getBwId()}'"  value="通过" class="btn btn-info"> 
											<input type ="button"  onclick="javascript:window.location.href='${pageContext.request.contextPath}/otherController/updatewithdrawaln.action?BwId=${list.getBwId()}'"  value="拒绝" class="btn btn-info">
											</c:if>
											</td>
											
										</tr>
										</c:forEach>
									</tbody>
								</table>


							</div>
							<div class="module-foot">
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
                <b class="copyright">&copy; 2018 TMOD9527 - EGrappler </b>All rights reserved. More Templates 
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