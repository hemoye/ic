<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<table class="table">
	<tbody>
		<tr>
			<td width="120" align="right">敏感词：</td>
			<td>
				<input type="text" class="form-control" name="${model.wordId }" id="word"
				placeholder="敏感词" value="${model.word }">
			</td>
		</tr>
		<tr>
			<td align="right">添加时间：</td>
			<td>${model.addTime }</td>
		</tr>
		<tr>
			<td align="right">修改时间：</td>
			<td>${model.updateTime }</td>
		</tr>
		<tr>
			<td align="right">是否删除：</td>
			<td>${model.isDelete ? "是" : "否" }</td>
		</tr>
		<tr>
			<td align="right">排序值：</td>
			<td><input type="text" class="form-control" name="sortNumber" id="sortNumber" aria-describedby="basic-addon1" value="${model.sortNumber > 0 ? model.sortNumber : 0 }"></td>
		</tr>
	</tbody>
</table>