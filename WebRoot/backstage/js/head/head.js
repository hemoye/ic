$(function() {
	getData(1);
});

function getData(currentPage) {
	$.ajax({
		url : "manage/head/headgetData.action",
		data : "currentPage=" + currentPage,
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
						"<div class='col-md-3 col-xs-12'><div class='panel panel-default'><div class='panel-body text-center'><img width='180px;' heigth='60px;' src='"
								+ data.recordList[i].headUrl
								+ "' class='img-responsive' style='display: inline;' /></div><div class='panel-heading'><input type='checkbox' name='id' value='"
								+ data.recordList[i].headId
								+ "' ><div class='pull-right'>添加时间: "
								+ data.recordList[i].times
								+ "</div></div></div></div>");
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

function pagefind(currentPage) {
	getData(currentPage);
}

function deleteByIds() {
	var currentPage = $("#pagelist .active > a").html();
	var headId = '';
	$("[name=id]:checked").each(function(index) {
		headId += $(this).val() + ",";
	});
	$.ajax({
		url : "manage/head/headdeleteByIds.action",
		data : "headIds=" + headId,
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("删除成功");
				getData(currentPage);
			} else {
				myAlert(data);
			}
		}
	});
}
