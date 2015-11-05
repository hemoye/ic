$(function() {
	pagefind(1);
});

function init(pageNum, pageSize, beginTime, endTime, userName, roleId) {
	var params = "pageNum=" + pageNum + "&pageSize=" + pageSize + "&userName="
			+ userName + "&roleId=" + roleId;
	if (beginTime != null && beginTime != "") {
		params += "&beginTime=" + beginTime;
	}
	if (endTime != null && endTime != "") {
		params += "&endTime=" + endTime;
	}
	$.ajax({
		url : "manage/user/loadData.html",
		data : params,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.recordList.length > 0) {
				addData(data);
			} else {
				dialog({
					title : '提示',
					content : '没有更多您要检索的数据了',
					ok : function() {
					},
					statusbar : '<label><input type="checkbox">不再提醒</label>'
				}).show();
			}
		}
	});
}

function addData(data) {
	$("#data-filter").html("");
	for ( var i = 0; i < data.recordList.length; i++) {
		var tmp = data.recordList[i];
		$("#data-filter")
				.append(
						"<tr><td><input type='checkbox' name='id' value='"
								+ tmp.userId
								+ "' /></td><td>"
								+ tmp.userName
								+ "</td><td>"
								+ tmp.userinfoVO.officeName
								+ "</td><td>"
								+ tmp.userEmail
								+ "</td><td>"
								+ tmp.userinfoVO.userSex
								+ "</td><td>"
								+ tmp.userinfoVO.regist
								+ "</td><td>"
								+ tmp.userroleVO.roleName
								+ "</td><td>"
								+ tmp.sortNumber
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'>"
								+ "<li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:detail("
								+ tmp.userId
								+ ")'>1. 查看</a></li>"
								+ "<li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:power("
								+ tmp.userId + ")'>2. 权限</a></li>"
								+ "</ul></div></td></tr>");
	}
	loadPageInfo(data);
}

function pagefind(pageNum) {
	init(pageNum, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val(), $("#searchName").val(), $("#roleId").val());
}

function selectChange() {
	pagefind(1);
}

function detail(userId) {
	dialog({
		title : '用户详细信息',
		url : 'manage/user/detail/' + userId + '.html',
		width : '400px',
		okValue : '确定',
		ok : function() {
		},
	}).show();
}

function power(userId) {
	var data = $('<div class="form-group"><label class="col-md-3 control-label">权限列表：</label><select class="col-md-6" id="newRoleId" class="form-control pull-right"><option value="2">院校管理员</option><option value="3">系别管理员</option><option value="4">班级管理员</option></select></div>');
	dialog({
		title : '分配角色',
		content: data,
		width : '400px',
		okValue : '确定',
		ok : function() {
			$.ajax({
				url : "manage/user/role.html",
				data : "userId=" + userId + "&param=" + $("#newRoleId").val(),
				type : "post",
				success : function(data) {
					dialog({
						title : '提示',
						content : data,
						width : '200px',
						okValue : '确定',
						ok : function() {
							init($("#pagelist .active > a").val(), $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val(), $("#searchName").val(), $("#roleId").val());
						},
					}).show();
					
				}
			});
		},
		cancelValue: '取消',
	    cancel: function () {}
	}).show();
}