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