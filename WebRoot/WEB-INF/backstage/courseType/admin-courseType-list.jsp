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
		<title>爱智网后台管理 - 课程类型管理</title>
		<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/font-awesome.min.css">
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/my.css" />
	    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin/admin-user-ban.css" />
	    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
	    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>
	    <script src="<%=basePath%>backstage/js/courseType/courseType.js"></script>
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
							<a href="javascript:void(0)">
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
					  <li><a href="javascript:void(0)"><span class="fa fa-home"></span>&nbsp;课程类型</a></li>
					  <li class="active">所有类型</li>
					</ol>
					<!-- nav breadcrumb end -->		
					<div class="row" style="padding-top: 0;">
						<div class="panel panel-default">
							<div class="panel-heading"><span class="fa fa-list"></span>&nbsp;意见反馈列表</div>
							<div class="panel-body">
								<div class="btn-group form-inline" role="group">
<!-- 									<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选"> -->
<!-- 									<input type="button" class="button button-small border-yellow" id="delAllBtn" value="批量删除"> -->
									<select name="typeId" id="fathertypeId" class="form-control" onchange="searchByTypeId()">
										<option value="0">所有类型</option>
								    	<c:forEach items="${fatherType }" var="coursetype">
								    		<option value="${coursetype.typeId }">${coursetype.typeName }</option>
								    	</c:forEach>
									</select>
									<input type="button" onclick="openaddfatherType()" class="button button-small border-green" value="添加根类型">
									<input type="button" onclick="openaddchildType()" class="button button-small border-blue" value="添加子类型">									
								</div>
								<div class="row">
									<table class="table table-hover" id="user-ban-tab">
							        	<thead>
							        		<tr>
							        			<th>类型编号</th>
							        			<th>类型名称</th>
							        			<th>根类型名称</th>
							        			<th>操作</th>
							        		</tr>
							        	</thead>
							        	<tbody id="data-courseType">
							        		<tr>
									          <td>1</td>
									          <td>1</td>
									          <td>1</td>
									          <td>
									          	<div class="dropdown">
												  <button class="button button-small dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
												  	<span class="fa fa-cog"></span>
												    <span class="caret"></span>
												  </button>
												  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
												    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1. 修改</a></li>
												    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">2. 删除</a></li>
												  </ul>
												</div>
									          </td>
									        </tr>
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
	<div class="modal fade" id="addfatherType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-body">
	        <form id="_addfatherType" action="javascript:addfatherType()" method="POST" class="form-horizontal">
	          <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h4 class="modal-title" id="_addfatherTypeName">
	              <span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;添加根类型
	            </h4>
	          </div>
	          <div class="modal-body">
	            <div class="form-group">
	              <div class="col-md-12">
	                <input type="text" name="rootName" class="form-control" id="rootName" placeholder="类型名" >
	              </div>
	            </div>
	          </div>
	          <div class="modal-footer">
	            <div class="form-group">
	              <button type="submit" id="btnrootName" class="btn btn-primary" name="addfatherType">添加</button>
	            </div>
	          </div>
	        </form>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<div class="modal fade" id="addchildType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-body">
	        <form id="_addchildType" action="javascript:addchildType()" method="POST" class="form-horizontal">
	          <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h4 class="modal-title" id="_addchildTitleName" >
	              <span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;添加子类型
	            </h4>
	          </div>
	          <div class="modal-body">
	         	 <div class="form-group">
	              <div class="col-md-12">
	                <select name="typeId" id="addfathertypeId" class="form-control" onchange="searchByTypeId()">
						<option value="0" id="selecttypeName">请选择根类型</option>
				    	<c:forEach items="${fatherType }" var="coursetype">
				    		<option value="${coursetype.typeId }">${coursetype.typeName }</option>
				    	</c:forEach>
					</select>
	              </div>
	            </div>
	          	<div class="form-group">
	              <div class="col-md-12">
	                <input type="text" name="childTypeName" class="form-control" id="childTypeName" placeholder="类型名" >
	                  <span class="icon-remove"></span>
	              </div>
	            </div>
	          </div>
	          <div class="modal-footer">
	            <div class="form-group">
	              <button type="submit" id="btnchildTypeName" class="btn btn-primary" name="addfatherType">添加</button>
	            </div>
	          </div>
	        </form>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</html>
