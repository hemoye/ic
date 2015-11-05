$(function() {
	pagefind(1);
});

function init(pageNum, pageSize, beginTime, endTime, userName, isSuccess) {
	var params = "pageNum=" + pageNum + "&pageSize=" + pageSize + "&userName="
			+ userName + "&success=" + isSuccess;
	if (beginTime != null && beginTime != "") {
		params += "&beginTime=" + beginTime;
	}
	if (endTime != null && endTime != "") {
		params += "&endTime=" + endTime;
	}
	$.ajax({
		url : "manage/log/loadData.html",
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
		if (!tmp.isSuccess) {
			$("#data-filter").append("<tr style='background: #CC6666;'><td>"+ tmp.logId+ "</td><td>"+ tmp.userName+ "</td><td>"+ tmp.logIp+ "</td><td>"
					+ tmp.sysLogTime+ "</td><td>"+ tmp.logName+ "</td><td>"+ "<a href='javascript:detail("+tmp.logId+")'>查看</a></td></tr>");			
		}
		else {
			$("#data-filter").append("<tr style='background: #CCFFFF;'><td>"+ tmp.logId+ "</td><td>"+ tmp.userName+ "</td><td>"+ tmp.logIp+ "</td><td>"
					+ tmp.sysLogTime+ "</td><td>"+ tmp.logName+ "</td><td>"+ "<a href='javascript:void(0)'>查看</a></td></tr>");
		}
	}
	loadPageInfo(data);
}

function pagefind(pageNum) {
	init(pageNum, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val(), $("#searchName").val(), $("#isSuccess").val());
}

function selectChange() {
	pagefind(1);
}

function detail(logId) {
	dialog({
		title : '日志信息',
		url : 'manage/log/detail/' + logId + '.html',
		width : '1040px', 
		height : '400px',
		okValue : '确定',
		ok : function() {
		},
	}).show();
}

