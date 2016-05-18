$(function(){
	console.log("rootPath : " + $.rootPath);
		$('#studentTable').bootstrapTable({
			url: $.rootPath + "manager/student/list.do",
			pagination: true,
			sidePagination: "server",
			columns: [{
				field: 'count',
				title: '学号'
			},{
				field: 'name',
				title: '姓名'
			},{
				field: 'sex',
				title: '性别'
			},{
				field: 'grade',
				title: '年级'
			},{
				field: 'college',
				title: '学院'
			},{
				field: 'smClass',
				title: '班级'
			},/*{
				field: 'status',
				title: '状态'
			},*/{
				field: 'id',
				title: '操作',
				formatter:function(value,row,index){
					var updatePath = $.rootPath + "manager/student/saveOrUpdate.do?studentId=" + value,
						update = '<a href = '+ updatePath +'>修改</a>';
					return update;
				}
			}],
			queryParams: function(params) {
				return params;
			}
		});
	
	
});


