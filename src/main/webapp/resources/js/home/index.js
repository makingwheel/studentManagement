$(function(){
	var noticeStatus= {
		0 : '失效',
		1 : '正常'
	}
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
				field: 'status',
				title: '状态',
				formatter : function(value, row, index){
					return noticeStatus[value];
				}
			},{
				field: 'id',
				title: '操作',
				formatter:function(value,row,index){
					var upudatePath = $.rootPath + 'manager/notice/saveOrUpdate.do?noticeId=' + row.id,
						del = '<a href="javascript:void(0);" id="delNotice" data-id='+ row.id +'>失效</a>',
						update = '<a href='+upudatePath+'>修改</a>';
					return del + '&nbsp;&nbsp;&nbsp;&nbsp;' +update;
				}
			}],
			queryParams: function(params) {
				return params;
			}
		});
	}
	
	
	$('#add').on('click',function(){
		window.location.href = $.rootPath + "/manager/notice/saveOrUpdate.do"
	});
	
	$(document).on('click' , '#delNotice', function(){
		var url = $.rootPath + 'manager/notice/updateStatus.do',
			id = $(this).data('id');;
		$.post(url,{
			noticeId : id,
			status : 0
		},function(data){
			$('#notice').bootstrapTable('refresh');
		});
	});
});


