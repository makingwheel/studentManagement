$(function(){
	console.log("rootPath : " + $.rootPath);
	$('#notice').bootstrapTable({
		url: $.rootPath + "student/timetable/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			title: '课程名称',
			field: 'name'
		},{
			title: '课程信息',
			field: 'name'
		},{
			title: '授课教师',
			field: 'teacher'
		},{
			title: '上课时间',
			field: '',
			formatter:function(value,row,index){
				var time = "第 " + row.beginWeek + " 周 至 第" + row.endWeek + "周 ";
				time += "周 " + row.week + " 第 " + row.node + "节 ";
				return time;
			}
		},{
			title: '上课地点',
			field: 'place'
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


