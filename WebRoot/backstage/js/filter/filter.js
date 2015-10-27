$(function() {
	getData(1, '');
});

function getData(currentPage, filterContext) {
	$
			.ajax({
				url : "manage/filter/filtergetData.action",
				data : "currentPage=" + currentPage + "&filterContext="
						+ filterContext,
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
						"<tr><td><input type='checkbox' name='id' value='"
								+ data.recordList[i].filterId
								+ "' /></td><td>"
								+ data.recordList[i].filterId
								+ "</td><td>"
								+ data.recordList[i].filterContext
								+ "</td><td>"
								+ data.recordList[i].replaceTo
								+ "</td><td>"
								+ data.recordList[i].addTime
								+ "</td><td>"
								+ data.recordList[i].adminVO.adminName
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:get("
								+ data.recordList[i].filterId
								+ ")'>1. 修改</a></li><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:deleteType("
								+ data.recordList[i].filterId
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
				"<li><a href='javascript:getData(1, \"\")'>首页</a></li>");
	}
	if (begin == data.currentPage) {
		$("#pagelist")
				.append(
						"<li class='disabled'><a href='javascript:void(0)' aria-label='Previous'><span aria-hidden='true'>上一页</span></a></li>");
	} else {
		$("#pagelist")
				.append(
						"<li><a href='javascript:getData("
								+ pre
								+ ", \"\")' aria-label='Previous'><span aria-hidden='true'>上一页</span></a></li>");
	}
	for ( var i = begin; i <= end; i++) {
		if (i == data.currentPage) {
			$("#pagelist").append(
					"<li class='active'><a href='javascript:void(0)'>" + i
							+ "</a></li>");
		} else {
			$("#pagelist").append(
					"<li><a href='javascript:getData(" + i + ", \"\")'>" + i
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
						"<li><a href='javascript:getData("
								+ next
								+ ", \"\")' aria-label='Next'><span aria-hidden='true'>下一页</span></a></li>");
	}
	if (end < data.endPageIndex) {
		$("#pagelist").append(
			"<li><a href='javascript:getData(" + data.pageCount
						+ ", \"\")'>尾页</a></li>");
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

function searchByfilterName() {
	var filterName = $("#searchName").val();
	getData(1, filterName);
}

function addFilter() {
	var currentPage = $("#pagelist .active > a").html();
	$("#addType").modal('hide');
	$.ajax({
		url : "manage/filter/filteraddFilter.action",
		data : "filterContext=" + $("#rootName").val() + "&replaceTo="
				+ $("#filterDesc").val(),
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
	$("#filterDesc").val("");
	$("#btnrootName").html("添加");
	$("#_addfatherType").attr("action", "javascript:addFilter()");
	$("#_addfatherTypeName").html(
			"<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;添加过滤字");
}

function get(filterId) {
	$
			.ajax({
				url : "manage/filter/filterget.action",
				data : "filterId=" + filterId,
				type : "post",
				dataType : "json",
				success : function(data) {
					$("#addType").modal('show');
					$("#rootName").val(data.filterContext);
					$("#filterDesc").val(data.replaceTo);
					$("#btnrootName").html("修改");
					$("#_addfatherType").attr("action",
							"javascript:update(" + data.filterId + ")");
					$("#_addfatherTypeName")
							.html(
									"<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;修改过滤字");
				}
			});
}

function deleteType(filterId) {
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/filter/filterdelete.action",
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
		url : "manage/filter/filterupdate.action",
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