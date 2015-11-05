$(function() {
	pagefind(1);
});

function pagefind(pageNum) {
	init(pageNum, $("#pageSize").val(), $("#begindatetimepicker").val(), $("#enddatetimepicker").val(), $("#searchName").val());
}

function init(pageNum, pageSize, beginTime, endTime, word) {
	var params = "pageNum=" + pageNum + "&pageSize=" + pageSize + "&word="
			+ word;
	if (beginTime != null && beginTime != "") {
		params += "&beginTime=" + beginTime;
	}
	if (endTime != null && endTime != "") {
		params += "&endTime=" + endTime;
	}
	$.ajax({
		url : "manage/keyword/loadData.html",
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
					okValue : '确定',
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
								+ tmp.wordId
								+ "' /></td><td>"
								+ tmp.wordId
								+ "</td><td>"
								+ tmp.word
								+ "</td><td>"
								+ tmp.timeAdd
								+ "</td><td>"
								+ tmp.timeUpdate
								+ "</td><td>"
								+ tmp.sortNumber
								+ "</td><td>"
								+ tmp.isDelete
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'>"
								+ "<li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:update("
								+ tmp.wordId
								+ ")'>1. 修改</a></li>"
								+ "<li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:deleteByIds("
								+ tmp.wordId + ")'>2. 删除</a></li>"
								+ "</ul></div></td></tr>");
	}
	loadPageInfo(data);
}

function selectChange() {
	pagefind(1);
}

function add() {
	var addata = $("<table class='table'></table>");
	var dd = addata.append("<table></table>");
	dd.append('<tr><td width="120" align="right">敏感词：</td><td><input type="text" class="form-control" id="word" placeholder="敏感词" value=""></td></tr>');
	dialog({
		title : '添加敏感词',
		content : addata,
		width : '400px',
		okValue : '确定',
		ok : function() {
			var params = "word=" + $("#word").val() + "&sortNumber=" + $("#sortNumber").val();
			$.ajax({
				url : "manage/keyword/add.html",
				data : params,
				type : "post",
				success : function(data) {
					dialog({
						title : '提示',
						content : data,
						okValue : '确定',
						ok : function() {
							pagefind($("#pagelist .active > a").html());
						},
						statusbar : '<label><input type="checkbox">不再提醒</label>'
					}).show();
				}
			});
		},
		cancelValue : '取消', 
		cancel : function() {
		},
	}).show();
}

function update(wordId) {
	var addata = $("<table class='table'></table>");
	var dd = addata.append("<table></table>");
	$.ajax({
		url : 'manage/keyword/detail/' + wordId + '.html',
		type : "post",
		dataType : 'json',
		success : function(data) {
			dd.append('<tr><td width="120" align="right">敏感词：</td><td><input type="text" class="form-control" id="word" placeholder="敏感词" value="'+data.word+'"></td></tr>');
			dd.append('<tr><td align="right">添加时间：</td><td>'+data.timeAdd+'</td></tr>');
			dd.append('<tr><td align="right">修改时间：</td><td>'+data.timeUpdate+'</td></tr>');
			dd.append('<tr><td align="right">排序值：</td><td><input type="text" class="form-control" name="sortNumber" id="sortNumber" aria-describedby="basic-addon1" value="0"></td></tr>');
		}
	});
	dialog({
		title : '更新敏感词',
		content : dd,
		width : '400px',
		okValue : '确定',
		ok : function() {
			var params = "wordId=" + wordId + "&word=" + $("#word").val() + "&sortNumber=" + $("#sortNumber").val();
			// 更新
			$.ajax({
				url : "manage/keyword/update.html",
				data : params,
				type : "post",
				success : function(data) {
					dialog({
						title : '提示',
						content : data,
						okValue : '确定',
						ok : function() {
							pagefind($("#pagelist .active > a").html());
						},
						statusbar : '<label><input type="checkbox">不再提醒</label>'
					}).show();
				}
			});
		},
		cancelValue : '取消', 
		cancel : function() {
		},
	}).show();
}

function deleteByIds(wordId) {
	var pageNum = $("#pagelist .active > a").html();
	var ids = '';
	if (wordId > 0) {
		ids = wordId;
	}
	else {
		$("[name=id]:checked").each(function(index) {
			ids += $(this).val() + ",";
		});
	}
	$.ajax({
		url : "manage/keyword/deleteByIds.html",
		data : "wordIds=" + ids,
		type : "post",
		success : function(data) {
			dialog({
				title : '提示',
				content : data,
				ok : function() {
					pagefind(pageNum);
				},
				statusbar : '<label><input type="checkbox">不再提醒</label>'
			}).show();
		}
	});
}