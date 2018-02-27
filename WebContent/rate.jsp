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
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/upload.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/googleapis.css"
            rel="stylesheet">
            <style type="text/css">
     #image,
     .img,
     img {
     width: 210px;
     height: 90px;
     }
     #image {
     border: 1px solid #000;
     }
  </style>
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
                     
                  <c:forEach items="${rule}" var="rule">
                  
                         <form class="form-inline" action="${pageContext.request.contextPath}/packageController/updaterule.action?ruId=${rule.getRuId()}" method="post">
                                   <div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">            
				<h4 class="modal-title" id="myModalLabel">
				${rule.getRuType()}  
				<input type="number" min="0" name="RuParameter"  ><span class="add-on">%</span>
				<input type ="submit" class="btn btn-info" >
				&nbsp;&nbsp;&nbsp;当前比例 &nbsp;${rule.getRuParameter()}&nbsp;<span class="add-on">%</span>
				</h4>
				</div>
				</div>
				</div>
				</div>
                                  </form>
                  </c:forEach>
                     
                   
                         
                                  <div class="form-inline">
                                  
                                   <div class="span9">
                        <div class="content">
                       
                            <div class="module message"  >
                                <div class="module-head">   
                                 <div class="input-append pull-right">
                                    <input value="新增礼包" type="button" name="new_btn" id="new_btn" class="btn btn-info" data-toggle="modal" data-target="#myModal">
                                </div>         
				<h4 class="modal-title" id="myModalLabel">
				礼包调整
				</h4>
				
				<c:forEach items="${list}" var="list">
				
				<table  >
		
  <tr>
  <td>
				  <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#${list.getpId()}">${list.getpName()}</button>
  <form action="${pageContext.request.contextPath}/packageController/updatepackage.action?pId=${list.getpId()}" method="post" class="form-inline">
  <div id="${list.getpId()}"  class="collapse">

   礼包名字：<input type="text" name="pName" value="${list.getpName()}" style="width:100px;">
     赠送会员天数：<input type="number" name="vipQuota" value="${list.getvipQuota()}" min="0"  style="width:60px;">天
<div class="inline">
   奖励积分：<input type="number" name="bonusIntegral" value="${list.getBonusIntegral()}" min="0" style="width:60px;">分
   消费积分：<input type="number" name="consumptionIntegral" value="${list.getConsumptionIntegral()}" min="0" style="width:60px;">分
</div>
<div class="inline">
   分享积分：<input type="number" name="sharingIntegral" value="${list.getSharingIntegral()}" min="0" style="width:60px;">分
     礼包价格：<input type="number" name="price" value="${list.getPrice()}" min="0" style="width:60px;">元
 </div>
<div class="pull-left">
   <input class="btn btn-info"   id="update" type="submit"  value="修改" >
     <input class="btn btn-info" type="reset" value="重置" >
       <input class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/packageController/deletepackage.action?pid=${list.getpId()}'" id="delete" type="button" value="删除" >
</div>


  </div>
  </form>
  </td>
  </tr>
  </table>

  </c:forEach>


				</div>
				</div>
				</div>
				</div>
                                  </div>
                                <!-- 模态框 -->
                                 <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/packageController/addpackage.action" method="post">
  <div class="modal fade"  id="myModal" style="display: none" data-backdrop="static">
    <div class="modal-dialog modal-sm">
      <div class="modal-content" >
   
        <!-- 模态框头部 -->
        <div class="modal-header">
          <h4 class="modal-title">新增礼包</h4>
        </div>
   
        <!-- 模态框主体 -->
        <div class="modal-body" >
     
         礼包名字：<input type="text" name="pName" placeholder="请输入礼包名称" ><br/>
   奖励积分：<input   type="number"  name="bonusIntegral" value="0" min="0" >分<br/>
   消费积分：<input  type="number" name="consumptionIntegral" value="0" min="0" >分<br/>
   分享积分：<input  type="number" name="sharingIntegral"  value="0" min="0">分<br/>
     礼包价格：<input  type="number" name="price" value="0" min="0" >元<br/>
 赠送会员天数：<input type="number" name="vipQuota"  value="0" min="0" >天
 
      <label for="fileToUpload">选择礼包封面</label><br />
      <input type="file" name="fileToUpload" id="fileToUpload" onchange="fileSelected();"/>
 <div id="image"></div>
        </div>
   
        <!-- 模态框底部 -->
        <div class="modal-footer" >
           <input class="btn btn-info" type="submit"   >
          <button type="button" class="btn btn-secondary" data-dismiss="modal"  >关闭</button>
        </div>
  
      </div>
    </div>
  </div>
  </form>
                            </div>
                            <!--/.module-->
                        </div>
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
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