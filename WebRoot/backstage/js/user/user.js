$(function() {
	init(1, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val(), $("#searchName").val(), $("#roleId").val());
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
					title : ' ',
					content : '没有更多您要检索的数据了！'
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
								+ tmp.userId + "' /></td><td>" + tmp.userName
								+ "</td><td>" + tmp.userinfoVO.officeName
								+ "</td><td>" + tmp.userEmail + "</td><td>"
								+ tmp.userinfoVO.userSex + "</td><td>" + tmp.userinfoVO.regist
								+ "</td><td>" + tmp.userroleVO.roleName
								+ "</td><td>" + tmp.sortNumber
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'>"
								+ "<li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:detail("
								+ tmp.userId + ")'>1. 查看</a></li>"
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
	init(1, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val(), $("#searchName").val(), $("#roleId").val());
}

function detail(userId) {
	window.location = "manage/user/userdetail.action?userId=" + userId;
}

function deleteType(filterId) {
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/user/userdelete.action",
		data : "filterId=" + filterId,
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("删除成功");
				getData(currentPage, '');
			} else {
				myAlert(data);
			}
		}
	});
}

function deleteByIds() {
	var currentPage = $("#pagelist .active > a").html();
	var filterId = '';
	$("[name=id]:checked").each(function(index) {
		filterId += $(this).val() + ",";
	});
	$.ajax({
		url : "manage/filter/filterdeleteByIds.action",
		data : "filterIds=" + filterId,
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("删除成功");
				getData(currentPage, $("#searchName").val());
			} else {
				myAlert(data);
			}
		}
	});
}

function update(filterId) {
	$("#addType").modal('hide');
	var filterName = $("#rootName").val();
	var filterDesc = $("#filterDesc").val();
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/user/userupdate.action",
		data : "filterId=" + filterId + "&filterContext=" + filterName
				+ "&replaceTo=" + filterDesc,
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("修改成功");
				getData(currentPage, $("#searchName").val());
			} else {
				myAlert(data);
			}
		}
	});
}