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
    
    <title>旧城微语后台 - 首页</title>
    
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
    <script src="<%=basePath%>backstage/js/back.js"></script>
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/frontstage/img/1.ico" />
  </head>
  
  <body>
  	<jsp:include page="nav.jsp"></jsp:include>
    <div class="container" id="main">
    	<div class="row">
    		<div id="sidebar" class="col-lg-2 col-md-2">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<c:forEach items="${msg.powers }" var="power">
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="noHeadingThree">
					      <h4 class="panel-title">
					      	<c:if test="${empty power.powers }">
								<a href="${power.powerUrl }">
						          	<span class="${power.icon }"></span>&nbsp;${power.powerName }
						        </a>					      	
					      	</c:if>
					      	<c:if test="${not empty power.powers }">
						      	<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapsePower" aria-expanded="false" aria-controls="collapsePower">
						          	<span class="${power.icon }"></span>&nbsp;${power.powerName }<span class="fa fa-angle-right pull-right"></span>
						        </a>
						        <div id="collapsePower" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							      <div class="panel-body">
							        <ul class="nav navbar-default nav-stacked">
									  <li role="presentation"><a href="${power.powerUrl }"><span class="${power.icon }"></span>&nbsp;${power.powerName }</a></li>
									  <c:forEach items="${power.powers }" var="child">
									  	<li role="presentation"><a href="${child.powerUrl }"><span class="${child.icon }"></span>&nbsp;${child.powerName }</a></li>
									  </c:forEach>
									</ul>
							      </div>
							    </div>
					      	</c:if>
					      </h4>
					    </div>					    
					  </div>
				  	</c:forEach>
				</div>											
			</div>
			<div id="content" class="col-lg-10 col-md-10">
				<!-- nav breadcrumb start -->
				<ol class="breadcrumb">
				  <li><a href="javascript:void(0)"><span class="fa fa-home"></span>&nbsp;开始</a></li>
				  <li class="active">系统设置</li>
				</ol>
				<!-- nav breadcrumb end -->
				<div class="row list-info">
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-users fa-2x"></span>
						<a href="javascript:void(0)" class="text-success">
							<br>新增用户<br>${msg.userNumber }
						</a>
					</div>
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-home fa-2x"></span>
						<a href="javascript:void(0)" class="text-warning" style="color: #f37b1d;">
							<br>新增学校<br>${msg.schoolNumber }
						</a>
					</div>
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-recycle fa-2x"></span>
						<a href="javascript:void(0)" class="text-danger">
							<br>昨日访问<br>${msg.visitNumber }
						</a>
					</div>
					<div class="col-lg-3 col-sm-3 col-xs-12 text-center">
						<span class="fa fa-user-md fa-2x"></span>
						<a href="javascript:void(0)" class="text-primary">
							<br>在线用户<br>${msg.onlineNumber }
						</a>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<img src="${model.userHead }" class="img-responsive" style="display: inline;" />
							</div>
							<div class="panel-heading">
								您好，${model.userName } <!-- 这是您第8次登录，上次登录为&nbsp;<time>2014-10-1</time>。 -->
							</div>
						</div>
					</div>
					<div class="col-md-9 col-xs-12">
						<div class="alert alert-yellow">
							<span class="fa fa-close pull-right" onclick="this.parentNode.style.display='none';"></span>
							<strong>注意：</strong>您有1条未读信息，<a href="manage/feedback/feedbackUI.action">点击查看</a>。
						</div>
					</div>
				</div>
				
				<div class="row" id="cnter">
					<div class="col-md-3 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">站点统计</div>
							<div class="panel-body">
								<ul class="list-group">
				                	<li class="list-group-item"><span class="pull-right badge progress-bar-danger">${msg.users }</span><span class="fa fa-user"></span> 会员</li>
				                	<li class="list-group-item"><span class="pull-right badge btn-white">${msg.schools }</span><span class="fa fa-user-secret"></span> 院校</li>
				                    <li class="list-group-item"><span class="pull-right badge btn-white">${msg.posts }</span><span class="fa-file"></span> 帖子</li>
				                    <li class="list-group-item"><span class="pull-right badge btn-white">${msg.resources }</span><span class="fa fa-cloud"></span> 资源</li>
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
						                    <tr><td width="110" align="right">操作系统：</td><td>centos 6.5</td><td width="100" align="right">系统开发：</td><td><a href="javascript:void(0)" >旧城微雨</a></td></tr>
						                    <tr><td align="right">Web服务器：</td><td>Tomcat + Apache</td><td align="right">主页：</td><td><a href="manage/index.html" target="_blank">点击这里</a></td></tr>
						                    <tr><td align="right">程序语言：</td><td>Java</td><td align="right">邮箱：</td><td><a href="javascript:void(0)" >a491158129@163.com</a></td></tr>
						                    <tr><td align="right">数据库：</td><td>MySQL</td><td align="right">qq：</td><td>123456789<a href="javascript:void(0)" >(点击加入)</a> </td></tr>
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
