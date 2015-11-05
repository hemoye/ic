$(function() {
	init(1, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val());
});

function init(pageNum, pageSize, beginTime, endTime, userName, roleId) {
	var params = "pageNum=" + pageNum + "&pageSize=" + pageSize;
	if (beginTime != null && beginTime != "") {
		params += "&beginTime=" + beginTime;
	}
	if (endTime != null && endTime != "") {
		params += "&endTime=" + endTime;
	}
	$.ajax({
		url : "manage/head/loadData.html",
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
				"<div class='col-md-3 col-xs-12'><div class='panel panel-default'><div class='panel-body text-center'><img width='180px;' heigth='60px;' src='"
						+ tmp.headUrl
						+ "' class='img-responsive' style='display: inline;' /></div><div class='panel-heading'><input type='checkbox' name='id' value='"
						+ tmp.headId
						+ "' ><div class='pull-right'>添加时间: "
						+ tmp.timeAdd
						+ "</div></div></div></div>");
	}
	loadPageInfo(data);
}

function pagefind(pageNum) {
	init(pageNum, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val());
}

function selectChange() {
	init(1, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val());
}

function deleteByIds() {
	var pageNum = $("#pagelist .active > a").html();
	var headId = '';
	$("[name=id]:checked").each(function(index) {
		headId += $(this).val() + ",";
	});
	$.ajax({
		url : "manage/head/deleteByIds.html",
		data : "headIds=" + headId,
		type : "post",
		success : function(data) {
			if (data == "1") {
				dialog({
					title : '提示',
					content : '删除成功！',
					ok : function() {
					},
					statusbar : '<label><input type="checkbox">不再提醒</label>'
				}).show();
				init(pageNum, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val());
			} else {
				dialog({
					title : '提示',
					content : data,
					ok : function() {
					},
					statusbar : '<label><input type="checkbox">不再提醒</label>'
				}).show();
			}
		}
	});
}