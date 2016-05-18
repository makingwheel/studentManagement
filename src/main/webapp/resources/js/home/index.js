$(function(){
	console.log("rootPath : " + $.rootPath);
	var userType = $('#userType').val();
	if(userType != 0){
		$('#notice').bootstrapTable({
			url: $.rootPath + "home/list.do",
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
	}else{
		$('#notice').bootstrapTable({
			url: $.rootPath + "home/list.do",
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
			},{
				field: 'id',
				title: '操作',
				formatter:function(value,row,index){
					var del = '<a href >删除</a>';
					var update = '<a href >修改</a>';
					return del + update;
				}
			}],
			queryParams: function(params) {
				return params;
			}
		});
	}
	
});


