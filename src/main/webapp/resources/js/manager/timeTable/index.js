$(function(){
	$('#timeTable').bootstrapTable({
		url: $.rootPath + "manager/timeTable/list.do",
		pagination: true,
		sidePagination: "server",
		columns: [{
			field: 'courseName',
			title: '课程名称'
		},{
			field: 'teacherName',
			title: '教师名称'
		},{
			field: '',
			title: '上课时间',
			formatter : function(value,row,index){
				var time = "第 " + row.beginWeek + " 周 至 第" + row.endWeek + "周 ";
				time += "周 " + row.week + " 第 " + row.node + "节 ";
				return time;
			}
		},{
			field: 'place',
			title: '上课地点'
		},{
			field: '',
			title: '班级',
			formatter : function(value,row,index){
				return row.grade + "级" + row.college + row.smClass;
			}
		},/*{
			field: 'status',
			title: '状态'
		},*/{
			field: 'timeTeacherCourseId',
			title: '操作',
			formatter:function(value,row,index){
				var updatePath = $.rootPath + 'manager/timeTable/saveOrUpdate.do?timeTeacherCourseId=' + value,
					update = '<a href = '+ updatePath +'>修改</a>';
				return update;
			}
		}],
		queryParams: function(params) {
			return params;
		}
	});
});


