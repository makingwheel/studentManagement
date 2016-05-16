$(function(){
	$('#signOnForm').validate({
		rules: {
			count: {
				required: true
			},
			password: {
				required: true,
			}
		},
		messages: {
			count: {
				required: "请填写账号"
			},
			password: {
				required: "请填写密码",
			}
		}
	});
	
	var type_url = {
		0 : $.rootPath + 'admin/home/index.do',
		1 : $.rootPath + 'teacher/home/index.do',
		2 : $.rootPath + 'student/home/index.do'
	}
	
	$('#signOn').on('click',function(){
		var $signError = $('#signon-error');
		if($signError.length === 0){
			$signError = $('<label id="signon-error" class="error" style="display: none;"></label>');
			$('input[name=count]').before($signError);
		}
		if($('#signOnForm').validate().form()){
			$('#signOnForm').ajaxSubmit({
				success:function(data){
					if(data.success){
						$signError.html('');
						$signError.hide();
						window.location.href = type_url[data.user.type];
					} else {
						$signError.html('账号或密码错误，请重新输入！！！');
						$signError.show();
					}
				}
			});
		}
	});
});