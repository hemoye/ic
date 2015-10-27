<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱智网后台 - 首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>backstage/js/admin/admin-index.js"></script>

  </head>
  
  <body>
  	<jsp:include page="nav.jsp"></jsp:include>
    <div class="container" id="main">
    	<div class="row">
    		<div id="sidebar" class="col-lg-2 col-md-2">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="noHeadingOne">
				      <h4 class="panel-title">
				        <a data-toggle="collapse" data-parent="#accordion" href="#noOne" aria-expanded="true" aria-controls="noOne">
				          	<a href="javascript:void(0)"><span class="fa fa-home"></span>&nbsp;首页</a>
				        </a>
				      </h4>
				    </div>					    
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingTwo">
				      <h4 class="panel-title">
				        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				          	<span class="fa fa-user"></span>&nbsp;用户管理<span class="fa fa-angle-right pull-right"></span>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
				      <div class="panel-body">
				        <ul class="nav navbar-default nav-stacked">
						  <li role="presentation"><a href="manage/user/userUI.action"><span class="fa fa-check"></span>&nbsp;检索用户<span class="fa fa-star pull-right" style="color: #ffbe40;margin-top: 2px;"></span></a></li>
						  <li role="presentation"><a href="manage/frost/frostUI.action"><span class="fa fa-user-times"></span>&nbsp;冻结用户</a></li>
						</ul>
				      </div>
				    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingThree">
				      <h4 class="panel-title">
				        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				          	<span class="fa fa-video-camera"></span>&nbsp;视频管理<span class="fa fa-angle-right pull-right"></span>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
				      <div class="panel-body">
				        <ul class="nav navbar-default nav-stacked">
						  <li role="presentation"><a href="manage/course/courseindex.action"><span class="fa fa-bell-o"></span>&nbsp;开设课程</a></li>
						  <li role="presentation"><a href="manage/voide/voidevoide.action"><span class="fa fa-upload"></span>&nbsp;上传课程</a></li>
						</ul>
				      </div>
				    </div>
				  </div>
				  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="noHeadingThree">
					      <h4 class="panel-title">
					        <a href="manage/report/reportUI.action">
					          	<span class="fa fa-comment-o"></span>&nbsp;问答管理
					        </a>
					      </h4>
					    </div>					    
				  </div>
				  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="noHeadingFour">
					      <h4 class="panel-title">
					        <a href="manage/filter/filterUI.action">
					          	<span class="fa fa-filter"></span>&nbsp;脏话管理
					        </a>
					      </h4>
					    </div>					    
				  </div>
				  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="noHeadingFive">
					      <h4 class="panel-title">
					        <a href="manage/title/titleUI.action">
					          	<span class="fa fa-child" style="color: #00A0E9;"></span>&nbsp;称号管理
					        </a>
					      </h4>
					    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="noHeadingSix">
				      <h4 class="panel-title">
				        <a href="manage/head/headUI.action">
				          	<span class="fa fa-file-image-o "></span>&nbsp;系统头像
				        </a>
				      </h4>
				    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="noHeadingSix">
				      <h4 class="panel-title">
				        <a href="manage/feedback/feedbackUI.action">
				          	<span class="fa fa-bomb" style="color: red;"></span>&nbsp;意见反馈
				        </a>
				      </h4>
				    </div>
				  </div>
				 <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="noHeadingSix">
				      <h4 class="panel-title">
				        <a href="manage/coursetype/typeUI.action">
				          	<span class="fa fa-bars"></span>&nbsp;课程类型管理
				        </a>
				      </h4>
				    </div>					    
				  </div>
				 <!-- <div class="list-group">
					  <a href="#" class="list-group-item">
					    <h4 class="list-group-item-heading"><span class="fa fa-bookmark"></span>&nbsp;公告</h4>
					    <p class="list-group-item-text">时光静好，与君语；细水流年，与君同。—— More Dream</p>
					  </a>
					  <a href="#" class="list-group-item">
					    <h4 class="list-group-item-heading"><span class="fa fa-tag"></span>&nbsp;Tag</h4>
					    <p class="list-group-item-text">Welcome to the More Dream!</p>
					  </a>
					</div> -->
				</div>											
			</div>
			<div id="content" class="col-lg-10 col-md-10">
				<!-- nav breadcrumb start -->
				<ol class="breadcrumb">
				  <li><a href="javascript:void(0)"><span class="fa fa-home"></span>&nbsp;开始</a></li>
				  <li class="active">后台首页</li>
				</ol>
				<!-- nav breadcrumb end -->
				<!-- 
				<div class="row list-info">
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-file-text fa-2x"></span>
						<a href="#" class="text-success">
							<br>新增页面<br>2300
						</a>
					</div>
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-briefcase fa-2x"></span>
						<a href="#" class="text-warning" style="color: #f37b1d;">
							<br>成交订单<br>308
						</a>
					</div>
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-recycle fa-2x"></span>
						<a href="#" class="text-danger">
							<br>昨日访问<br>80082
						</a>
					</div>
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-user-md fa-2x"></span>
						<a href="#" class="text-primary">
							<br>在线用户<br>3000
						</a>
					</div>
				</div>
				 -->
				
				<div class="row">
					<div class="col-md-3 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<img src="${model.adminHead }" class="img-responsive" style="display: inline;" />
							</div>
							<div class="panel-heading">
								您好，${model.adminName } <!-- 这是您第8次登录，上次登录为&nbsp;<time>2014-10-1</time>。 -->
							</div>
						</div>
					</div>
					<div class="col-md-9 col-xs-12">
						<c:if test="${model.feedNumber > 0 }">
							<div class="alert alert-yellow">
								<span class="fa fa-close pull-right" onclick="this.parentNode.style.display='none';"></span>
								<strong>注意：</strong>您有${model.feedNumber }条未读信息，<a href="manage/feedback/feedbackUI.action">点击查看</a>。
							</div>
						</c:if>
						<!-- 
						<div class="panel panel-default">
							<div class="panel-heading">多梦网络主题介绍</div>
							<div class="panel-body">
								<p>多梦网络提供了各种灵活模块</p>
								<a class="btn btn-yellow"><span class="fa fa-code"></span>&nbsp;下载使用教程</a>
								<a class="btn btn-white"><span class="fa fa-file"></span>&nbsp;查看使用教程</a>
							</div>
						</div>
						 -->
					</div>
				</div>
				
				<div class="row" id="cnter">
					<div class="col-md-3 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">站点统计</div>
							<div class="panel-body">
								<ul class="list-group">
				                	<li class="list-group-item"><span class="pull-right badge progress-bar-danger">${userNumber }</span><span class="fa fa-user"></span> 会员</li>
				                	<li class="list-group-item"><span class="pull-right badge btn-white">${teacherNumber }</span><span class="fa fa-user-secret"></span> 教师</li>
				                    <li class="list-group-item"><span class="pull-right badge btn-white">${courseNumber }</span><span class="fa fa-cloud"></span> 课程</li>
				                    <li class="list-group-item"><span class="pull-right badge btn-white">${voideNumber }</span><span class="fa fa-video-camera"></span> 视频</li>
				                    <li class="list-group-item"><span class="pull-right badge btn-white">${resourceNumber }</span><span class="fa fa-file-zip-o"></span> 资源</li>
				                </ul>
							</div>
						</div>
					</div>
					<div class="col-md-9 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">系统信息</div>
							<div class="panel-body">
								<ul class="list-group">
									<table class="table">
										<tbody>
											<tr><th colspan="2">服务器信息</th><th colspan="2">系统信息</th></tr>
						                    <tr><td width="110" align="right">操作系统：</td><td>centos 6.5</td><td width="90" align="right">系统开发：</td><td><a href="javascript:void(0)" >爱智网</a></td></tr>
						                    <tr><td align="right">Web服务器：</td><td>Tomcat + Apache</td><td align="right">主页：</td><td><a href="index.action" target="_blank">点击这里</a></td></tr>
						                    <tr><td align="right">程序语言：</td><td>Java</td><td align="right">邮箱：</td><td><a href="javascript:void(0)" >a491158129@163.com</a></td></tr>
						                    <tr><td align="right">数据库：</td><td>MySQL</td><td align="right">qq：</td><td>380560757<a href="javascript:void(0)" >(点击加入)</a> </td></tr>
						                </tbody>
									</table>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</div>	
  </body>
</html>
