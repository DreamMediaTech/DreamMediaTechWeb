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
		<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/scripts/common.js" type="text/javascript"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/googleapis.css"
            rel="stylesheet">

           </head>
 
<body>
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
                                        <li><a href="video-upload.jsp"><i class="icon-inbox"></i>视频上传 </a></li>
                                        <li><a href="video-list.jsp"><i class="icon-inbox"></i>视频列表 </a></li>
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
                           
                            <div class="module message">
                                <div class="module-head">
                                    <h3>
                                      角色管理</h3>
                                </div>
                                <div class="module-option clearfix">
                                 
                                      </div>
                                <div class="module-body table">
                                <form action="" method="post" >
                                    <table align="center" >  
                                    <tr>
                                    <td width="10%" >
                                       	当前角色：
                                    </td>                                  
                                    <td >                                  
                                    <input type="text" name="rDescribe" value="${role.getrName()}">                               
                                    </td>
                                    
                                    </tr>
                                      <tr>
                                    <td width="10%">
                           			   角色描述：
                                    </td>
                                    <td >
                                <input type="text" name="rDescribe" value="${role.getrDescribe()}">
                                    </td>
                                    </tr>
                                    <tr>
                                    <td width="10%">
                                     	现有权限：
                                    </td> 
                                    <td >
                                  
                                    <c:forEach items="${list}"  var="list">
                                   
                                     <i class="icon-star">
                                <input    type="checkbox" id="fId" name="fId" value="${list.getfId()}">
                                   &nbsp;${list.getfName()}&nbsp;</i><br>
                                     
                                      </c:forEach>
                                      <div class="a">
                                      <input type="button"   class="btn btn-info" name="delete" id="delete" value="删除" onclick="">
                                      <button class="btn btn-info" data-toggle="modal" data-target="#myModal">
	新增权限
</button>
                                    </div>
                                    </td>  
                                    
                                    </tr>
                                    <tr>
                                    <td></td>
                                    <td >
                   					<input class="btn btn-info " type="submit" value="提交更改" name="">                 
                                    </td>
                                    </tr></table></form>
                                </div>
                            </div>
                        </div>
                        <!--/.content-->
                    </div></div>
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
        
        <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<form action="${pageContext.request.contextPath}/function_roleController/insertFunction.action?rids=${role.getrId()}" method="post">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					当前角色没有的权限
				</h4>
			</div>
			<div class="modal-body">
			
				<c:forEach items="${unfunction}" var="unfunction">
				 <input    type="checkbox" id="fids" name="fids" value="${unfunction.getfId()}">
				 ${unfunction.getfName()}<br/>
				</c:forEach>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit"    class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal --></form>
</div>
    
    </body>

</html>