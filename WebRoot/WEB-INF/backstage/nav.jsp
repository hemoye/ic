<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>爱智网后台管理</title>
	    
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
	<link rel="stylesheet" href="<%=basePath %>frontstage/myAlert/myAlert.css" />
	<script src="<%=basePath %>frontstage/myAlert/myAlert.js"></script>

  </head>
  
  <body>
	<nav class="navbar navbar-default header" role="navigation">
    	<div class="container">  
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
            	<!--响应时控制图标-->
            	<span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                
            </button>    
            
        	<div class="navbar-header">
            	<a class="navbar-brand" href="manage/admin/adminindex.action"><strong>爱智网</strong> <span class="hidden-xs">后台管理</span></a>
            </div>
            <div class="collapse navbar-collapse pull-right" id="navbar-main">	            	
                <ul class="nav navbar-nav">
<!--                     <li role="presentation">	                    	 -->
<!--                     	<a href="index.html"> -->
<!--                     		<span class="fa fa-envelope-o"></span> 用户反馈 -->
<!--                     		<span class="label label-warning">${sessionScope.admin.feedNumber }</span> -->
<!--                     	</a> -->
<!--                     </li> -->
                    <li>
                        <a id="wordPress" href="#" data-toggle="dropdown" class="dropdown-toggle" itemprop="url">
                        	<span class="fa fa-group"></span> ${sessionScope.admin.adminName }
                        	<span class="caret"></span>
                        </a>                        
                        <!--向下箭头-->                          
                        <ul class="dropdown-menu" id="word-list" role="menu">	                        	
<!--                             <li><a href="#" itemprop="url"><span class="fa fa-user"></span> 资料</a></li> -->
<!--                             <li><a href="#" itemprop="url"><span class="fa fa-cog"></span> 设置</a></li> -->
                            <li><a href="manage/admin/adminlogout.action" itemprop="url"><span class="fa fa-power-off"></span> 退出</a></li>
                        </ul>
                    </li>                    
                   	<li><a href="javascript:void();" onclick="requestFullScreen()" itemprop="url"><span class="fa fa-arrows-alt"></span> 开启全屏</a></li>
                </ul>
            </div>
        </div>
    </nav>
  </body>
</html>
