$(function(){
	$('#achievement').bootstrapTable({
		url: $.rootPath + "student/achievement/list.do",
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
		}/*,{
			field: 'modifyDate',
			title: '发布日期',
			formatter:function(value,row,index){
				var date = new Date(value);
					year = null,
					month = null,
					day = null;
				if(value){
					year = date.getFullYear();
					month = (month = date.getMonth() + 1) < 10 ? '0'+month : month;
					day = (day = date.getDate()) < 10 ? '0'+day : day;
					return year + '-' + month + '-' + day;
				}
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


