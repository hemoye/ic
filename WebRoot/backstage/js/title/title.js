$(function() {
	getData(1, '');
});

function getData(currentPage, titleName) {
	$.ajax({
		url : "manage/title/titlegetData.action",
		data : "currentPage=" + currentPage + "&titleName=" + titleName,
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
	$("#data-title").html("");
	for ( var i = 0; i < data.recordList.length; i++) {
		$("#data-title")
				.append(
						"<tr><td><input type='checkbox' name='id' value='"+data.recordList[i].titleId+"' /></td><td>"
								+ data.recordList[i].titleId
								+ "</td><td>"
								+ data.recordList[i].titleName
								+ "</td><td>"
								+ data.recordList[i].titleDesc
								+ "</td><td>"
								+ data.recordList[i].times
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:get("
								+ data.recordList[i].titleId
								+ ")'>1. 修改</a></li><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:deleteType("
								+ data.recordList[i].titleId
								+ ")' onclick=\"return confirm('确定删除?')\">2. 删除</a></li></ul></div></td></tr>");
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

function searchByTitleName() {
	var titleName = $("#searchName").val();
	getData(1, titleName);
}

function addType() {
	var currentPage = $("#pagelist .active > a").html();
	$("#addType").modal('hide');
	$.ajax({
		url : "manage/title/titleaddType.action",
		data : "titleName=" + $("#rootName").val() + "&titleDesc=" + $("#titleDesc").val(),
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("添加成功");
				getData(currentPage, '');
			} else {
				myAlert(data);
			}
		}
	});
}

function openaddModal() {
	$("#addType").modal('show');
	$("#rootName").val("");
	$("#titleDesc").val("");
	$("#btnrootName").html("添加");
	$("#_addfatherType").attr("action", "javascript:addType()");
	$("#_addfatherTypeName").html(
			"<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;添加称号");
}

function get(titleId) {
	$.ajax({
			url : "manage/title/titleget.action",
			data : "titleId=" + titleId,
			type : "post",
			dataType : "json",
			success : function(data) {
				$("#addType").modal('show');
				$("#rootName").val(data.titleName);
				$("#titleDesc").val(data.titleDesc);
				$("#btnrootName").html("修改");
				$("#_addfatherType").attr("action", "javascript:update("+data.titleId+")");
				$("#_addfatherTypeName").html(
						"<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;修改称号");
			}
	});
}

function deleteType(titleId) {
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/title/titledelete.action",
		data : "titleId=" + titleId,
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
	var titleId = '';
	$("[name=id]:checked").each(function(index) {
		titleId += $(this).val() + ",";
	});
	$.ajax({
		url : "manage/title/titledeleteByIds.action",
		data : "titleIds=" + titleId,
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

function update(titleId) {
	$("#addType").modal('hide');
	var titleName = $("#rootName").val();
	var titleDesc = $("#titleDesc").val();
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/title/titleupdate.action",
		data : "titleId=" + titleId + "&titleName=" + titleName + "&titleDesc="
				+ titleDesc,
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