$(function(){
	console.log("rootPath : " + $.rootPath);
	$('#achievement').bootstrapTable({
		url: $.rootPath + "teacher/achievement/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			title: '课程名称',
			field: 'name'
		},{
			title: '课程信息',
			field: 'name'
		},{
			title: '授课教师',
			field: 'teacherName'
		},{
			title: '成绩',
			field: 'result'
		},{
			field: 'studentTeacherCourseId',
			title: '操作',
			formatter:function(value,row,index){
				
				return value;
			}
		}],
		queryParams: function(params) {
			return params;
		}
	});
});


