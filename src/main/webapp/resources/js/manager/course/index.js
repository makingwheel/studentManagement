$(function(){
	$('#courseTable').bootstrapTable({
		url: $.rootPath + "manager/course/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'name',
			title: '课程名称'
		},{
			field: 'message',
			title: '课程信息'
		},{
			field: 'id',
			title: '操作',
			formatter:function(value,row,index){
				var updatePath = $.rootPath + 'manager/course/saveOrUpdate.do?studentId=' + value,
					update = '<a href = '+ updatePath +'>修改</a>';
				return update;
			}
		}],
		queryParams: function(params) {
			return params;
		}
	});
	
	
	$('#add').on('click',function(){
		window.location.href = $.rootPath + 'manager/course/saveOrUpdate.do';
	});
	
});


