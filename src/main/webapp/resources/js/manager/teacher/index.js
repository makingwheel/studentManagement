$(function(){
	$('#teacherTable').bootstrapTable({
		url: $.rootPath + "manager/teacher/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'count',
			title: '教师号'
		},{
			field: 'name',
			title: '姓名'
		},{
			field: 'sex',
			title: '性别'
		},{
			field: 'tel',
			title: '联系方式'
		},{
			field: 'email',
			title: '邮箱'
		},{
			field: 'level',
			title: '等级'
		},/*{
			field: 'status',
			title: '状态'
		},*/{
			field: 'id',
			title: '操作',
			formatter:function(value,row,index){
				var updatePath = $.rootPath + 'manager/teacher/saveOrUpdate.do?teacherId=' + value,
					update = '<a href = '+ updatePath +'>修改</a>';
				return update;
			}
		}],
		queryParams: function(params) {
			params.count = $('#count').val();
			params.name = $('#name').val();
			return params;
		}
	});
	
	$('#search').on('click',function(){
		$('#teacherTable').bootstrapTable('refresh');
	});
	
	$('#add').on('click',function(){
		window.location.href = $.rootPath + 'manager/teacher/saveOrUpdate.do';
	});
	
});


