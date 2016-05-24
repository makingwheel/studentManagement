$(function(){
	console.log("rootPath : " + $.rootPath);
	$('#achievement').bootstrapTable({
		url: $.rootPath + "teacher/achievement/list.do",
		pagination: true,
		sidePagination: "server",
		rowAttributes : function(row,index) {
			return row;
		},
		columns: [{
			title: '课程名称',
			field: 'name'
		},{
			title: '课程信息',
			field: 'name'
		},{
			title: '学生姓名',
			field: 'studentName'
		},{
			title: '成绩',
			field: 'result',
			editable : {
				type: 'text',
				title: '成绩',
				ajaxOptions: {
					type: 'post',
					dataType: 'json'
				},
				url: $.rootPath + "teacher/achievement/updateResult.do",
				params: function(params){
					params.studentTeacherCourseId = $(this).closest('tr').attr('studentteachercourseid');
					params.result = params.value;
					return params;
				},
				error: function(){}
			},
		}/*,{
			field: 'studentTeacherCourseId',
			title: '操作',
			formatter:function(value,row,index){
				
				return value;
			}
		}*/],
		queryParams: function(params) {
			params.termId = $('#termId').val();
			return params;
		}
	});
	
	$('#search').on('click', function(){
		$('#achievement').bootstrapTable('refresh');
	});
});


