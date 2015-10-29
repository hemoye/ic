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
		<title>旧城微语后台 - 用户管理</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/bootstrap-datetimepicker.min.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-user-ban.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script src="<%=basePath%>backstage/js/back.js"></script>
	    <script src="<%=basePath%>backstage/js/user/user.js"></script>
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
					  <li><a href="manage/user/userUI.action"><span class="fa fa-home"></span>&nbsp;用户管理</a></li>
					  <li class="active">用户列表</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;用户列表</div>
							<div class="panel-body">
								<div class="btn-group form-inline" role="group">
									<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选">
									<div class="input-group pull-right">
									  <select name="roleId" id="roleId" onchange="javascript:selectChange()" class="form-control pull-right">
							    		<option value="0">所有用户</option>
							    		<option value="1">超级管理员</option>
							    		<option value="2">院级管理员</option>
							    		<option value="3">校级管理员</option>
							    		<option value="4">班级管理员</option>
							    		<option value="5">班级管理员</option>
									  </select>
									  <span class="input-group-addon">
				                      </span>
									  <select name="pageSize" id="pageSize" onchange="javascript:selectChange()" class="form-control pull-right">
							    		<option value="10">每页10条</option>
							    		<option value="5">每页5条</option>
							    		<option value="20">每页20条</option>
							    		<option value="500">每页50条</option>
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
				                      <form action="javascript:selectChange()">
										<div class="input-group pull-right">
										  <input type="text" class="form-control" id="searchName" placeholder="输入您要搜索的过滤字" aria-describedby="basic-addon1">
										  <span class="input-group-addon" id="searchLabel" onclick="javascript:selectChange()">搜索</span>
										</div>
									</form>
								</div>
								<div class="row">
									<table class="table table-hover" id="user-ban-tab">
							        	<thead>
							        		<tr>
							        			<th>选择</th>
							        			<th>用户名</th>
							        			<th>职业</th>
							        			<th>邮箱</th>
							        			<th>性别</th>
							        			<th>注册时间</th>
							        			<th>用户角色</th>
							        			<th>排序值</th>
							        			<th>操作</th>
							        		</tr>
							        	</thead>
							        	<tbody id="data-filter">
<!-- 							        		<tr> -->
<!-- 							        		  <td><input type="checkbox" name="id" value="1" /></td> -->
<!-- 									          <td>jwk</td> -->
<!-- 									          <td class="user-reason">真实姓名</td> -->
<!-- 									          <td class="user-reason">职业</td> -->
<!-- 									          <td>邮箱</span></td> -->
<!-- 									          <td>男</td> -->
<!-- 									          <td><span class="fa fa-rect badge-success">2012-04-05 12:03:36</span></td> -->
<!-- 									          <td>已激活</td> -->
<!-- 									          <td> -->
<!-- 									          	<div class="dropdown"> -->
<!-- 												  <button class="button button-small dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true"> -->
<!-- 												  	<span class="fa fa-cog"></span> -->
<!-- 												    <span class="caret"></span> -->
<!-- 												  </button> -->
<!-- 												  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1"> -->
<!-- 												    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1. 查看</a></li> -->
<!-- 												    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">2. 修改</a></li> -->
<!-- 												    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">3. 删除</a></li> -->
<!-- 												  </ul> -->
<!-- 												</div> -->
<!-- 									          </td> -->
<!-- 									        </tr> -->
							        	</tbody>
									</table>
									<!--page divide start-->
								        <div class="text-center" id="pageCount">
										  <ul class="pagination" id="pagelist">
										    <li class="disabled">
										      <a href="#" aria-label="Previous">
										        <span aria-hidden="true">上一页</span>
										      </a>
										    </li>
										    <li class="active"><a href="#">1</a></li>
										    <li>
										      <a id="nextBtn" href="javascript:void(0)" aria-label="Next">
										        <span aria-hidden="true">下一页</span>
										      </a>
										    </li>
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
