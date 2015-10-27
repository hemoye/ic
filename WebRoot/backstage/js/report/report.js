$(function() {
	getData(1, '');
});

function getData(currentPage, reportReason ) {
	$.ajax({
		url : "manage/report/reportgetData.action",
		data : "currentPage=" + currentPage + "&reportReason=" + reportReason,
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
	$("#data-report").html("");
	for ( var i = 0; i < data.recordList.length; i++) {
		var userpostVO = null;
		var replyVO = null;
		var userpostVO1 = null
		var replyVO1 = null;
		if(data.recordList[i].userpostVO != null){
			userpostVO1 = userpostVO = data.recordList[i].userpostVO.postId;
		}else{
			userpostVO = "无";
			userpostVO1 = null;
		}
		if(data.recordList[i].replyVO != null){
			replyVO1 = replyVO  = data.recordList[i].replyVO.replyId
		}else {
			replyVO = "无";
			replyVO1 = null;
		}
		$("#data-report")
				.append(
						"<tr><td> "
								+ data.recordList[i].reportId 
								+ "</td><td> "
								+ replyVO
								+ "</td><td>"
								+ userpostVO
								+ "</td><td>"
								+ data.recordList[i].userVO.userId
								+ "</td><td style=' white-space:nowrap; overflow:hidden; text-overflow:ellipsis; ' >"
								+ data.recordList[i].reportReason
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:detail("
								+ replyVO1 
								+ ","
								+ userpostVO1
								+ ","
								+  data.recordList[i].reportId 
								+ ")'>1. 查看</a></li></ul></div></td></tr>");
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
function searchByReportReason() {
	var filterName = $("#searchName").val();
	getData(1, filterName);
	 $("#searchName").val("");
}

function detail(replyId, postId,  reportId ) {
	window.location = "manage/report/reportdetail.action?replyId=" + replyId + "&postId=" + postId + "&reportId=" + reportId;
}


