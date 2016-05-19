$(function(){
	$('#termTable').bootstrapTable({
		url: $.rootPath + "manager/term/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'year',
			title: '年份',
			formatter: function(value,row,index){
				return (new Date(value)).getFullYear();
			}
		},{
			field: 'term',
			title: '学期'
		},{
			field: 'id',
			title: '操作',
			formatter:function(value,row,index){
				var updatePath = $.rootPath + 'manager/term/saveOrUpdate.do?termId=' + value,
					update = '<a href = '+ updatePath +'>修改</a>';
				return update;
			}
		}],
		queryParams: function(params) {
			return params;
		}
	});
	
	
	$('#add').on('click',function(){
		window.location.href = $.rootPath + 'manager/term/saveOrUpdate.do';
	});
});


