$(function(){
	$('#teacherForm').validate({
		rules: {
			name: {
				required: true
			},
			count: {
				required: true
			},
			sex: {
				required: true
			},
			nation: {
				required: true
			},
			birthday: {
				required: true
			},
			placeOfOrigin: {
				required: true
			}
		}/*,
		messages: {
			count: {
				required: "请填写账号"
			},
			password: {
				required: "请填写密码",
			}
		}*/
	});
	
	$('#submit').on('click',function(){
		console.log("click");
		if($('#teacherForm').validate().form()){
			$('#teacherForm').ajaxSubmit({
				success:function(data){
					if(data.success){
						//window.location.href = $.rootPath + "teacher/info/index.do";
						bootstrapQ.msg({
						    msg  : '修改成功！（3秒消失）',
						    type : 'success',
						    time : 3000
						});
					} else {
						bootstrapQ.msg({
						    msg  : '系统错误请联系管理员！（3秒消失）',
						    type : 'danger',
						    time : 3000
						});
					}
				}
			});
		}
	});
	
	$('#cancle').on('click', function(){
		window.location.href = $.rootPath + "teacher/info/index.do";
	});
	
	/*$('#birthday').datetimepicker({
		format : 'yyyy-mm-dd ',
		startView : 2,
		maxView : 2,
		minView : 2,
		todayBtn : true,
		autoclose: true
	});*/
});