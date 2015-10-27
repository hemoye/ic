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
		<title>爱智网后台管理 - 系统头像</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/bootstrap-datetimepicker.min.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-user-ban.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script src="<%=basePath%>backstage/js/admin/admin-index.js"></script>
	    <script src="<%=basePath%>backstage/js/head/head.js"></script>
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
					        <a href="javascript:void(0)">
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
					  <li><a href="#"><span class="fa fa-home"></span>&nbsp;系统头像</a></li>
					  <li class="active">头像列表</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;头像列表</div>
							<div class="panel-body">
								<div class="btn-group form-inline" role="group">
									<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选">
									<input type="button" class="button button-small border-yellow" onclick="deleteByIds()" value="批量删除">
									<div class="row" id="data-filter">
										<div class="col-md-3 col-xs-12">
											<div class="panel panel-default">
												<div class="panel-body text-center">
													<img src="${sessionScope.admin.adminHead }" class="img-responsive" style="display: inline;" />
												</div>
												<div class="panel-heading">
													<input type='checkbox' name='id' value='' >
													<div class="pull-right">添加时间: 时间</div>
												</div>
											</div>
										</div>
									</div>
								<div class="row">
							        <div id="data-filter">
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
									<jsp:include page="/frontstage/uploadify/uploadify.jsp"></jsp:include>
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
