<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱智网 后台登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">       
    <script src="<%=basePath%>backstage/js/jquery-1.10.2.min.js"></script>
    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>

  </head>
  
  <body>
    <body>
		<div id="login-page" style="width: 40%; margin-top: 8%;" class="container">
			<form id="frmUserLogin" action="manage/admin/adminlogin.action" method="POST" class="form-horizontal">
	          <div class="modal-header">
	            <h4 class="modal-title">
	              <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;爱智网后台登录
	            </h4>
	          </div>
	          <div class="modal-body">
	            <div class="form-group">
	              <label for="adminName" class="col-md-2 control-label">用户名</label>
	              <div class="col-md-10">
	                <input type="text" name="adminName" class="form-control" id="adminName" placeholder="用户名" >
	                  <span class="icon-remove"></span>
	              </div>
	            </div>
	            <div class="form-group">
	              <label for="adminPwd" class="col-md-2 control-label">密码</label>
	              <div class="col-md-10">
	                <input type="password" name="adminPwd" class="form-control" id="adminPwd" placeholder="密码" >
	                  <span class="icon-remove"></span>
	              </div>
	            </div>
	            <div id="msg" class="container" style="color: #660000">${result }</div>
	          </div>
	          <div class="modal-footer">
	            <div class="form-group">
	              <button type="submit" class="btn btn-primary" name="login">登录</button>
	            </div>
	          </div>
	        </form>
		</div>
	</body>
  </body>
</html>
