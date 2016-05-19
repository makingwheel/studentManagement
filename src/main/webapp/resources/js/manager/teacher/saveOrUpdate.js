$(function(){
	$('#teacherForm').validate({
		rules: {
			count: {
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
						window.location.href = $.rootPath + "manager/teacher/index.do";
					} else {
						
					}
				}
			});
		}
	});
	
	$('#cancle').on('click', function(){
		window.location.href = $.rootPath + 'manager/teacher/index.do';
	});
});