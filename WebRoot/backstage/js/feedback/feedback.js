$(function() {
	getData(1);
});

function getData(currentPage) {
	$.ajax({
		url : "manage/feedback/feedbackgetData.action",
		data : "currentPage=" + currentPage,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.recordList.length > 0) {
				addData(data);
			}
			else {
				myAlert("没有您检索的数据");
			}
		}
	});
}

function addData(data) {
	$("#data-feedback").html("");
	for (var i = 0; i < data.recordList.length; i++) {
		$("#data-feedback").append("<tr><td>"+data.recordList[i].userVO.userName
				+"</td><td class='user-reason-list'><strong>"+data.recordList[i].feedContext
				+"</strong></td><td><span class='fa fa-rect badge-success'>"+data.recordList[i].times
				+"</span></td><td>"+data.recordList[i].status
				+"</td><td><a href='manage/feedback/feedbackdetail.action?feedId="
				+data.recordList[i].feedId+"'>查看</a></td></tr>");				
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
				"<li><a href='javascript:getData(1)'>首页</a></li>");
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
								+ ")' aria-label='Previous'><span aria-hidden='true'>上一页</span></a></li>");
	}
	for ( var i = begin; i <= end; i++) {
		if (i == data.currentPage) {
			$("#pagelist").append(
					"<li class='active'><a href='javascript:void(0)'>" + i
							+ "</a></li>");
		} else {
			$("#pagelist").append(
					"<li><a href='javascript:getData(" + i + ")'>" + i
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
								+ ")' aria-label='Next'><span aria-hidden='true'>下一页</span></a></li>");
	}
	if (end < data.endPageIndex) {
		$("#pagelist").append(
			"<li><a href='javascript:getData(" + data.pageCount
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

function searchByuserName() {
//	var currentPage = $("#pagelist .active > a").html();
	var currentPage = 1;
	$.ajax({
		url : "manage/feedback/feedbackgetData.action",
		data : "currentPage=" + currentPage + "&userName=" + $("#searchuserName").val(),
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.recordList.length > 0) {
				addData(data);
			}
			else {
				myAlert("没有您检索的数据");
			}
		}
	});
}