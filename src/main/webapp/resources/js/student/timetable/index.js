$(function(){
	console.log("rootPath : " + $.rootPath);
	$('#notice').bootstrapTable({
		url: $.rootPath + "student/timetable/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'id',
			title: 'id'
		},{
			field: 'name',
			title: 'name'
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
			return params;
		}
	});
});


