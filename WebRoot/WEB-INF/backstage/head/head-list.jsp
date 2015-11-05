<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8">
		<title>旧城微语后台 - 日志管理</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/bootstrap-datetimepicker.min.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-user-ban.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script src="<%=basePath%>backstage/js/back.js"></script>
	    <script src="<%=basePath%>backstage/js/head/head.js"></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/moment.min.js" ></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/bootstrap-datetimepicker.min.js" ></script>
	    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/frontstage/img/1.ico" />
	</head>
	<body>
		<jsp:include page="../nav.jsp"></jsp:include>		
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
					  <li><a href="manage/head/index.html"><span class="fa fa-file-text"></span>&nbsp;系统头像</a></li>
					  <li class="active">头像列表</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-file-image-o"></span>&nbsp;日志列表</div>
							<div class="panel-body">
								<div class="btn-group form-inline" role="group">
									<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选">
									<input type="button" class="button button-small border-yellow" onclick="deleteByIds()" value="批量删除">
									<div class="input-group pull-right">
									  <select name="pageSize" id="pageSize" onchange="javascript:selectChange()" class="form-control pull-right">
							    		<option value="8">每页8条</option>
							    		<option value="4">每页4条</option>
							    		<option value="16">每页16条</option>
							    		<option value="32">每页32条</option>
									  </select>
									  <span class="input-group-addon">
				                      </span>
				                      <input type='text' id='begindatetimepicker' class="form-control" readonly placeholder="起始时间" />
				                      <span class="input-group-addon">
				                          <span class="glyphicon glyphicon-time"></span>
				                      </span>
				                      <input type='text' id='enddatetimepicker' class="form-control" readonly placeholder="结束时间" />
				                      <span class="input-group-addon">
				                          <span class="glyphicon glyphicon-time"></span>
				                      </span>
								</div>
								<div class="row">
									<table class="table table-hover" id="user-ban-tab">
							        	<div class="row" id="data-filter">
										</div>
									</table>
									<!--page divide start-->
								        <div class="text-center" id="pageCount">
										  <ul class="pagination" id="pagelist">
										  </ul>
										</div>
								        <!-- page divide end -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>
</html>
