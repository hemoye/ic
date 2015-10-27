<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<base href="<%=basePath%>">
		<title>爱智网后台管理 - 上传视频</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">   
		<link rel="stylesheet" href="<%=basePath%>backstage/css/bootstrap-datetimepicker.min.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-video.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/moment.min.js" ></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/zh-cn.js" ></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/bootstrap-datetimepicker.min.js" ></script>
	    <script src="<%=basePath%>backstage/js/admin/admin-video.js"></script>	    
	    <script src="<%=basePath%>backstage/js/voide/voide.js"></script>	    
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
					    <div id="collapseThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingThree">
					      <div class="panel-body">
					        <ul class="nav navbar-default nav-stacked">
							  <li role="presentation"><a href="manage/course/courseindex.action"><span class="fa fa-bell-o"></span>&nbsp;开设课程</a></li>
							  <li role="presentation"><a href="javascript:void(0)"><span class="fa fa-upload"></span>&nbsp;上传课程</a></li>
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
					  <li><a href="javascript:void(0)"><span class="fa fa-home"></span>&nbsp;视频管理</a></li>
					  <li class="active">&nbsp;上传视频</a></li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;课程信息</div>
							<div class="panel-body">								
								<div class="row nopadding">									
									<form id="course" action="manage/voide/voideaddVoide.action" enctype="multipart/form-data" method="post" class="form-horizontal" >
									   <div class="form-group">
									     <label class="col-sm-2 control-label" for="pwd">开课教师</label>
									     <div class="col-sm-10">
										    <select name="teacherId" id="teacherId" class="form-control" onchange="selectCourse()">
										    	<c:forEach items="${teachers }" var="teacher">
										    		<option value="${teacher.teacherId }">${teacher.teacherName }</option>
										    	</c:forEach>
											</select>
										</div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courseId">课程名</label>
									    <div class="col-sm-10">
									    	<select name="courseId" id="courseId" class="form-control" onchange="selectSection()">
										    	<option value="0">请选择课程</option>
											</select>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="section">请选择章节</label>
									    <div class="col-sm-10">
									    	<select name="sectionId" id="sectionId" class="form-control" >
										    	<option value="0">请选择章节</option>
											</select>
											<div class="input-group page">
										    	<input type="text" class="form-control" name="sectionDesc" placeholder="章节简介">
									    		<span class="input-group-addon page-add-btn"></span>									    		
									    	</div>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courceBack">视频</label>
									    <div class="col-sm-10">
										    <input id="courceBack" name="myFile" type="file">
										    <p class="help-block">点击按钮选择视频(flv格式)</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="resource">视频资源</label>
									    <div class="col-sm-10">
										    <input id="resource" name="resource" type="file">
										    <p class="help-block">点击按钮上传视频资源(rar、zip格式)</p>
									    </div>
									  </div>
									  <div class="col-sm-12 text-center">
									  	<button type="submit" id="videoAddBtn" class="btn btn-success">添加</button>
									  </div>
									  <c:if test="${result != null }">
										  <script type="text/javascript">
										  	alert("上传成功");
										  </script>
									  </c:if>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>
</html>
