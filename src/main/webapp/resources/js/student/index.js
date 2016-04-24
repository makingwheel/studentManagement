
	$('#notice').bootstrapTable({
		url: "/studentManagement/student/home/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'title',
			title: '标题'
		},{
			field: 'message',
			title: '内容'
		},{
			field: 'modifyDate',
			title: '发布日期'
		}],
		queryParams: function(params) {
			return params;
		}
	});
