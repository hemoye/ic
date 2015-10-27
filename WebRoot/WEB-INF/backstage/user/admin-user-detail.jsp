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
		<title>爱智网后台管理 - 用户管理</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-user-ban.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script src="<%=basePath%>backstage/js/admin/admin-index.js"></script>
	</head>
	<body>
		<jsp:include page="../nav.jsp"></jsp:include>		
		<div class="container" id="main">
			<div class="row">
				<div id="sidebar" class="col-lg-2 col-md-2">
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="noHeadingOne">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#noOne" aria-expanded="true" aria-controls="noOne">
					          	<a href="manage/admin/adminindex.action"><span class="fa fa-home"></span>&nbsp;首页</a>
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
					    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
					      <div class="panel-body">
					        <ul class="nav navbar-default nav-stacked">
							  <li role="presentation"><a href="javascript:void(0)"><span class="fa fa-check"></span>&nbsp;检索用户<span class="fa fa-star pull-right" style="color: #ffbe40;margin-top: 2px;"></span></a></li>
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
				</div>										
			</div>
				<div id="content" class="col-lg-10 col-md-10">
					<!-- nav breadcrumb start -->
					<ol class="breadcrumb">
					  <li><a href="manage/user/userUI.action"><span class="fa fa-home"></span>&nbsp;用户管理</a></li>
					  <li><a href="manage/user/userUI.action"><span class="fa fa-user"></span>&nbsp;所有用户</a></li>
					  <li class="active">${model.userName } 的详细信息</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;${model.userName }的详细信息</div>
							<div class="panel-body nopadding">								
								<div class="row nopadding">									
									<ul class="list-group">
										<table class="table">
											<tbody>
												<!--
													如果一行里只有一个内容那么如下写法
													<td align="right">冻结原因：</td>
							                    	<td colspan="3">内容</td>
                                                -->
							                    <tr><td width="120" align="right">用户名：</td><td>${model.userName }</td></tr>
							                    <tr><td align="right">邮箱：</td><td>${model.userEmail }</td></tr>
							                    <tr><td align="right">状态：</td><td>
							                    	<c:if test="${model.status == 0}">未激活</c:if>
							                    	<c:if test="${model.status == 1}">已激活</c:if>
							                    	<c:if test="${model.status > 1}">被冻结</c:if>
							                    </td></tr>
							                    <tr><td align="right">手机：</td><td>${model.userTel }</td></tr>
							                    <tr><td align="right">职位：</td><td>${model.userinfo.useroffice.officeName }</td></tr>
							                    <tr><td align="right">地址：</td><td>
							                    	<c:if test="${model.userinfo.county != null }">
							                    		${model.userinfo.county.city.province.provinceName }省${model.userinfo.county.city.cityName }${model.userinfo.county.countyName }
							                    	</c:if>
							                    	</td>
							                    </tr>
							                    <tr><td align="right">标签：</td><td>
							                    	<c:if test="${model.userinfo.userlabel != null }">
							                    		<c:forEach items="${model.userinfo.userlabel }" var="userlabel">
							                    			 ${userlabel.labelName } 
							                    		</c:forEach>
							                    	</c:if>
							                    	<c:if test="${model.userinfo.userlabel == null }">
							                    		无
							                    	</c:if>
							                    	</td>
							                    </tr>
							                    <tr><td align="right">经验/等级：</td><td>${model.userinfo.userExp }/${model.userinfo.userLevel }</td></tr>
							                    <tr><td align="right">称号：</td><td>
							                    	<c:if test="${model.userinfo.title != null }">
							                    		${model.userinfo.title.titleName }  
							                    	</c:if>
							                    	<c:if test="${model.userinfo.title == null }">
							                    		无
							                    	</c:if>
							                    	</td>
							                    </tr>
							                    <tr><td align="right">性别：</td><td>${model.userinfo.userSex }</td></tr>
							                    <tr><td align="right">生日：</td><td>${model.userinfo.birthday }</td></tr>
							                    <tr><td align="right">注册时间：</td><td>${model.userinfo.registTime }</td></tr>
							                    <tr><td align="right">上次登录时间：</td><td>${model.userinfo.loginTime }</td></tr>
							                    <tr><td align="right">连续登陆天数：</td><td>${model.userinfo.loginNumber }</td></tr>
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
