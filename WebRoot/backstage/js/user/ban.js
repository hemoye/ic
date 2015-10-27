$(function() {
	$('#begindatetimepicker').datetimepicker({
		format : 'YYYY-MM-DD HH:mm:ss',
		ignoreReadonly : true,
		maxDate : new Date(),
		minDate : new Date(1800, 1, 1),
	});
	getData(1, $('#begindatetimepicker').val(), $("#searchName").val(), 2);
});

function pagefind(currentPage) {
	getData(currentPage, $('#begindatetimepicker').val(), $("#searchName")
			.val(), 2);
}

function getData(currentPage, beginTime, userName, status) {
	$.ajax({
		url : "manage/frost/frostgetData.action",
		data : "currentPage=" + currentPage + "&begin=" + beginTime
				+ "&userName=" + userName + "&status=" + status,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.recordList.length > 0) {
				addData(data);
			} else {
				myAlert("没有您检索的数据");
			}
		}
	});
}

function addData(data) {
	$("#data-filter").html("");
	for ( var i = 0; i < data.recordList.length; i++) {
		$("#data-filter")
				.append(
						"<tr><td>"
								+ data.recordList[i].userName
								+ "</td><td>"
								+ data.recordList[i].userinfoVO.realName
								+ "</td><td>"
								+ data.recordList[i].userinfoVO.officeName
								+ "</td><td>"
								+ data.recordList[i].userEmail
								+ "</td><td>"
								+ data.recordList[i].userinfoVO.userSex
								+ "</td><td>"
								+ data.recordList[i].frost
								+ "</td><td>"
								+ data.recordList[i].userStatus
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:deletefrost("
								+ data.recordList[i].userId
								+ ")'>1. 解冻</a></li></ul></div></td></tr>");
	}
	$("#pagelist").html("");
	var begin = data.currentPage - 3;
	var end = data.currentPage + 1;
	var pre = data.currentPage - 1;
	var next = data.currentPage + 1;
	if (begin >= 0) {
		begin++;
	} else {
		begin = 1;
	}
	if (end < 4) {
		end = 4;
	}
	if (end < data.pageCount) {
		end++;
	} else {
		end = data.pageCount;
	}
	if (begin > 1) {
		$("#pagelist").append(
				"<li><a href='javascript:pagefind(1)'>首页</a></li>");
	}
	if (begin == data.currentPage) {
		$("#pagelist")
				.append(
						"<li class='disabled'><a href='javascript:void(0)' aria-label='Previous'><span aria-hidden='true'>上一页</span></a></li>");
	} else {
		$("#pagelist")
				.append(
						"<li><a href='javascript:pagefind("
								+ pre
								+ ")' aria-label='Previous'><span aria-hidden='true'>上一页</span></a></li>");
	}
	for ( var i = begin; i <= end; i++) {
		if (i == data.currentPage) {
			$("#pagelist").append(
					"<li class='active'><a href='javascript:void(0)'>" + i
							+ "</a></li>");
		} else {
			$("#pagelist").append(
					"<li><a href='javascript:pagefind(" + i + ")'>" + i
							+ "</a></li>");
		}
	}
	if (data.endPageIndex == data.currentPage) {
		$("#pagelist")
				.append(
						"<li class='disabled'><a href='javascript:void(0)' aria-label='Next'><span aria-hidden='true'>下一页</span></a></li>");
	} else {
		$("#pagelist")
				.append(
						"<li><a href='javascript:pagefind("
								+ next
								+ ")' aria-label='Next'><span aria-hidden='true'>下一页</span></a></li>");
	}
	if (end < data.endPageIndex) {
		$("#pagelist").append(
				"<li><a href='javascript:pagefind(" + data.pageCount
						+ ")'>尾页</a></li>");
	}
	if ($(".exits-pagecount").html() == undefined) {
		$("#pageCount").append(
				"<div class='exits-pagecount pull-right'><strong>"
						+ data.recordCount + "条记录 共" + data.pageCount
						+ "页</strong></div>");
	} else {
		$(".exits-pagecount").html(
				"<strong>" + data.recordCount + "条记录 共" + data.pageCount
						+ "页</strong>")
	}
}

function changeSelect() {
	getData(1, $('#begindatetimepicker').val(), $("#searchName").val(), 2);
}

function openaddModal() {
	$("#addType").modal('show');
	$("#rootName").val("");
	$("#filterDesc").val("");
	$("#btnrootName").html("添加");
	$("#_addfatherType").attr("action", "javascript:addFilter()");
	$("#_addfatherTypeName").html(
			"<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;添加过滤字");
}

function deletefrost(userId) {
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/frost/frostdelete.action",
		data : "userId=" + userId,
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("解冻成功");
				getData(1, $('#begindatetimepicker').val(), $("#searchName").val(), 2);
			} else {
				myAlert(data);
			}
		}
	});
}
