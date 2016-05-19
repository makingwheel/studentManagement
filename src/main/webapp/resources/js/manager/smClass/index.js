$(function(){
	$('#smClassTable').bootstrapTable({
		url: $.rootPath + "manager/smClass/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'grade',
			title: '年级',
		},{
			field: 'college',
			title: '学院'
		},{
			field: 'smClass',
			title : '班级'
		},{
			field: 'id',
			title: '操作',
			formatter:function(value,row,index){
				var updatePath = $.rootPath + 'manager/smClass/saveOrUpdate.do?classId=' + value,
					update = '<a href = '+ updatePath +'>修改</a>';
				return update;
			}
		}],
		queryParams: function(params) {
			return params;
		}
	});
	
	
	$('#add').on('click',function(){
		window.location.href = $.rootPath + 'manager/smClass/saveOrUpdate.do';
	});
});


