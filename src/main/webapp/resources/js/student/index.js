$(function(){
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
			title: '发布日期',
			formatter:function(value,row,index){
				var date = new Date(value);
				if(value){
					return date.getFullYear();
				}
				return value;
			}
		}],
		queryParams: function(params) {
			return params;
		}
	});
});


