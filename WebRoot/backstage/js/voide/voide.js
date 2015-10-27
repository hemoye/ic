$(function() {
	selectCourse();
})

function selectCourse() {
	$.ajax({
		url : "manage/voide/voideselectCourse.action",
		data : "teacherId=" + $("#teacherId").val(),
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data != null) {
				$("#courseId").html("<option value='0'>请选择课程</option>");
				for ( var i = 0; i < data.length; i++) {
					$("#courseId").append(
							"<option value='" + data[i].courseId + "'>"
									+ data[i].courseName + "</option>");
				}
			}
		}
	});
}

function selectSection() {
	$.ajax({
		url : "manage/voide/voideselectSection.action",
		data : "courseId=" + $("#courseId").val(),
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data != null) {
				$("#sectionId").html("<option value='0'>请选择章节</option>");
				for ( var i = 0; i < data.length; i++) {
					$("#sectionId").append(
							"<option value='" + data[i].sectionId + "'>"
									+ data[i].sectionName + "</option>");
				}
			}
		}
	});
}