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
		}],
		queryParams: function(params) {
			return params;
		}
	});
});


