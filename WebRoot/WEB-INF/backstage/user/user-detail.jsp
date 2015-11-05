<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<table class="table">
	<tbody>
		<tr>
			<td width="120" align="right">用户名：</td>
			<td>${model.userName }</td>
		</tr>
		<tr>
			<td width="120" align="right">用户角色：</td>
			<td>${model.userrole.roleName }</td>
		</tr>
		<tr>
			<td align="right">邮箱：</td>
			<td>${empty model.userEmail ? "未填写" : model.userEmail }</td>
		</tr>
		<tr>
			<td align="right">手机：</td>
			<td>${empty model.userTel ? "未填写" : model.userTle }</td>
		</tr>
		<tr>
			<td align="right">职位：</td>
			<td>${empty model.userinfo.useroffice ? "未选择" : model.userinfo.useroffice.officeName }</td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<td>${model.userinfo.userSex }</td>
		</tr>
		<tr>
			<td align="right">生日：</td>
			<td>${model.userinfo.birthday }</td>
		</tr>
		<tr>
			<td align="right">注册时间：</td>
			<td>${model.userinfo.registTime }</td>
		</tr>
		<tr>
			<td align="right">是否删除：</td>
			<td>${model.isDelete ? "是" : "否" }</td>
		</tr>
		<tr>
			<td align="right">排序值：</td>
			<td>${model.sortNumber }</td>
		</tr>
	</tbody>
</table>