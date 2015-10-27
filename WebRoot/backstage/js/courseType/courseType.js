$(function() {
	getData(1);
});

function getDataByTypeId(currentPage, typeId) {
	$.ajax({
		url : "manage/coursetype/typegetData.action",
		data : "currentPage=" + currentPage + "&typeId=" + typeId,
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

function getData(currentPage) {
	$.ajax({
		url : "manage/coursetype/typegetData.action",
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
	var msg = "return confirm('确定删除?')";
	$("#data-courseType").html("");
	for ( var i = 0; i < data.recordList.length; i++) {
		$("#data-courseType")
				.append(
						"<tr><td>"
								+ data.recordList[i].typeId
								+ "</td><td>"
								+ data.recordList[i].typeName
								+ "</td><td>"
								+ data.recordList[i].coursetypeVO.typeName
								+ "</td><td><div class='dropdown'><button class='button button-small dropdown-toggle' type='button' id='dropdownMenu1' data-toggle='dropdown' aria-expanded='true'><span class='fa fa-cog'></span><span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:get("
								+ data.recordList[i].typeId
								+ ")'>1. 修改</a></li><li role='presentation'><a role='menuitem' tabindex='-1' href='javascript:deleteType("
								+ data.recordList[i].typeId
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

function searchByTypeId() {
	var fathertypeId = $("#fathertypeId").val();
	if (fathertypeId == 0) {
		fathertypeId = '';
	}
	getDataByTypeId(1, fathertypeId);
}

function addfatherType() {
	$("#addfatherType").modal('hide');
	$.ajax({
		url : "manage/coursetype/typeaddRoot.action",
		data : "typeName=" + $("#rootName").val(),
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("添加成功");
				getData(1);
			} else {
				myAlert(data);
			}
		}
	});
}

function addchildType() {
	$("#addchildType").modal('hide');
	if ($("#addfathertypeId").val() == 0) {
		myAlert("添加失败、请选择根类型");
	}
	$.ajax({
		url : "manage/coursetype/typeaddChild.action",
		data : "typeName=" + $("#childTypeName").val() + "&typeId="
				+ $("#addfathertypeId").val(),
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("添加成功");
				getData(1);
			} else {
				myAlert(data);
			}
		}
	});
}

function openaddfatherType() {
	$("#addfatherType").modal('show');
	$("#rootName").val("");
	$("#btnrootName").html("添加");
	$("#addfatherType").attr("action", "javascript:addfatherType()");
	$("#_addfatherTypeName").html("<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;添加根类型");
}
function openaddchildType() {
	$("#addchildType").modal('show');
	$("#selecttypeName").html("请选择根类型");
	$("#selecttypeName").val(0);
	$("#childTypeName").val("")
	$("#btnchildTypeName").html("添加");
	$("#_addchildType").attr("action", "javascript:addchildType()");
	$("#_addfatherTypeName").html("<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;添加子类型");
}

function get(typeId) {
	$.ajax({
		url : "manage/coursetype/typeget.action",
		data : "typeId=" + typeId,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.coursetypeVO.typeName == '无') {
				$("#addfatherType").modal('show');
				$("#rootName").val(data.typeName);
				$("#btnrootName").html("修改");
				$("#_addfatherType").attr(
						"action",
						"javascript:update(" + data.typeId + ", 0, 0)");
				$("#_addfatherTypeName").html("<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;修改根类型");
			} else {
				$("#addchildType").modal('show');
				$("#selecttypeName").html(data.coursetypeVO.typeName);
				$("#selecttypeName").val(data.coursetypeVO.typeId);
				$("#childTypeName").val(data.typeName)
				$("#btnchildTypeName").html("修改");
				$("#_addchildType").attr(
						"action",
						"javascript:update(" + data.typeId + ", 1,"
								+ data.coursetypeVO.typeId + ")");
				$("#_addfatherTypeName").html("<span class='glyphicon glyphicon-book'></span>&nbsp;&nbsp;修改子类型");
			}
		}
	});
}

function deleteType(typeId) {
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/coursetype/typedelete.action",
		data : "typeId=" + typeId,
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

function update(typeId, typeName, fatherId) {
	$("#addfatherType").modal('hide');
	$("#addchildType").modal('hide');
	if (typeName == 0) {
		typeName = $("#rootName").val();
	}
	else {
		fatherId = $("#addfathertypeId").val();
		typeName = $("#childTypeName").val();		
	}
	var currentPage = $("#pagelist .active > a").html();
	$.ajax({
		url : "manage/coursetype/typeupdate.action",
		data : "typeId=" + typeId + "&typeName=" + typeName + "&fatherId="
				+ fatherId,
		type : "post",
		success : function(data) {
			if (data == "1") {
				myAlert("修改成功");
				getData(currentPage);
			} else {
				myAlert(data);
			}
		}
	});
}