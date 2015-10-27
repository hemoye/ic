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
		<title>爱智网后台管理 - 开设课程</title>
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
	    <script src="<%=basePath%>backstage/js/course/course.js"></script>	    
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
							  <li role="presentation"><a href="javascript:void(0)"><span class="fa fa-bell-o"></span>&nbsp;开设课程</a></li>
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
					  <li><a href="javascript:void(0)"><span class="fa fa-home"></span>&nbsp;视频管理</a></li>
					  <li class="active">&nbsp;开设课程</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;课程信息</div>
							<div class="panel-body">								
								<div class="row nopadding">									
									<form id="course" action="manage/course/courseaddCourse.action" enctype="multipart/form-data" method="post" class="form-horizontal" >
									   <div class="form-group">
									     <label class="col-sm-2 control-label" for="pwd">开课教师</label>
									     <div class="col-sm-10">
										    <select name="teacherId" class="form-control">
										    	<c:forEach items="${teachers }" var="teacher">
										    		<option value="${teacher.teacherId }">${teacher.teacherName }</option>
										    	</c:forEach>
											</select>
										</div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courseName">课程名</label>
									    <div class="col-sm-10">
									    	<input type="text" class="form-control" id="courseName" name="courseName" placeholder="请输入课程名">
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="pwd">课程类别</label>
									     <div class="col-sm-10">
										    <select name="typeId" class="form-control">
											  	<c:forEach items="${coursetypes }" var="coursetype">
										    		<option value="${coursetype.typeId }">${coursetype.typeName }</option>
										    	</c:forEach>
											</select>
										</div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="pwd">课程难度</label>
									     <div class="col-sm-10">
										    <select name="courseLevel" class="form-control">
									    		<option value="初级">初级</option>
									    		<option value="中级">中级</option>
									    		<option value="高级">高级</option>
											</select>
										</div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courceBack">课程封面</label>
									    <div class="col-sm-10">
										    <input id="courceBack" name="myFile" type="file">
										    <p class="help-block">点击按钮选择封面</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="page">章节</label>
									    <div class="col-sm-10 page-list">									    										    	
											<div class="input-group">
										    	<input type="text" class="form-control" value="第一章 " name="page" placeholder="请输入章节名称">
									    		<span class="input-group-addon page-reduce-btn"><span class="fa fa-minus-circle"></span></span>									    		
									    	</div>
											<div class="input-group page">
										    	<input type="text" class="form-control" name="page" placeholder="请输入章节名称">
									    		<span class="input-group-addon page-add-btn"><span class="fa fa-plus-circle"></span></span>									    		
									    	</div>
									    </div>
									  </div>
									  <div class="form-group">
									  	<label class="col-sm-2 control-label" for="sTime">开课时间</label>
									  	<div class="col-sm-10">
							                <div class='input-group date' id='datetimepicker'>
							                    <input type='text' name="courseDate" class="form-control" readonly />
							                    <span class="input-group-addon">
							                        <span class="glyphicon glyphicon-time"></span>
							                    </span>
							                </div>
								            <script type="text/javascript">
									            $(function () {
									                $('#datetimepicker').datetimepicker({
									                    format: 'YYYY-MM-DD HH:mm:ss',		
									                    ignoreReadonly: true,
									                    //maxDate: new Date(),
									                    minDate: new Date(1800,1,1),
									                });
									            });
									        </script>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courseTime">课程时长</label>
									    <div class="col-sm-10">
									    	<input id="courseTime" name="courseTime" class="form-control"/>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courseAd">课程宣语</label>
									    <div class="col-sm-10">
									    	<input id="courseAd" name="courseAd" class="form-control"/>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courseDec">课程简介</label>
									    <div class="col-sm-10">
										    <textarea id="courseDec" name="courseInfo" class="form-control" rows="5"></textarea>
									    </div>
									  </div>
									  <!-- 
									  <div class="form-group">
									    <label class="col-sm-2 control-label" for="courseDec">添加视频</label>
									    <div class="col-sm-10">
										    <a href="javascript:submitCourse();" class="form-control" >点击进去视频添加页面</a>
									    </div>
									  </div>
									   -->
									  <div class="col-sm-12 text-center">
									  	<button type="submit" id="videoAddBtn" class="btn btn-success">添加</button>
									  </div>
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
