$(function(){
	$('#noticeForm').validate({
		rules: {
			title: {
				required: true
			},
			message: {
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
		if($('#noticeForm').validate().form()){
			$('#noticeForm').ajaxSubmit({
				success:function(data){
					if(data.success){
						window.location.href = $.rootPath + "home/index.do";
					} else {
						
					}
				}
			});
		}
	});
	
	$('#cancle').on('click', function(){
		window.location.href = $.rootPath + 'home/index.do';
	});
});