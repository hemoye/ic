<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8">
		<title>爱智网后台管理 - 问答管理</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/bootstrap-datetimepicker.min.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-user-ban.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script src="<%=basePath%>backstage/js/admin/admin-index.js"></script>
	    <script src="<%=basePath%>backstage/js/report/report.js"></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/moment.min.js" ></script>
	    <script type="text/javascript" src="<%=basePath%>backstage/js/bootstrap-datetimepicker.min.js" ></script>
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
						        <a href="javascript:void(0)">
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
					  <li><a href="manage/report/reportUI.action"><span class="fa fa-home"></span>&nbsp;问答管理</a></li>
					  <li class="active">问答列表</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;问答列表</div>
							<div class="panel-body">
								<div class="btn-group form-inline" role="group">
									<div class="input-group pull-right">
									
				                      <form action="javascript:searchByReportReason()">
										<div class="input-group pull-right">
										  <input type="text" class="form-control" id="searchName" placeholder="输入您要搜索的举报原因" aria-describedby="basic-addon1">
										  <span class="input-group-addon" onclick="javascript:searchByReportReason()" id="searchLabel">搜索</span>
										</div>
									</form>
								</div>
								<div class="row">
									<table class="table table-hover" id="user-ban-tab" style="table-layout:fixed;" >
							        	<thead>
							        		<tr>
							        			<th width="17%">举报编号</th>
							        			<th width="17%">回复编号</th>
							        			<th width="17%">帖子编号</th>
							        			<th width="17%">用户编号</th>
							        			<th width="25%" >举报原因</th>
							        			<th >操作</th>
							        		</tr>
							        	</thead>
							        
							        		
							      <tbody id = "data-report">
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
