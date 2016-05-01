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
						window.location.href = $.rootPath + "student/home/index.do";
					} else {
						$signError.html('账号或密码错误，请重新输入！！！');
						$signError.show();
					}
				}
			});
		}
	});
});