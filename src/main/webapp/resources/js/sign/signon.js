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
});