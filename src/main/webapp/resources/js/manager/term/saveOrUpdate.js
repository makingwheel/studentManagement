$(function(){
	$('#termForm').validate({
		rules: {
			name: {
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
		if($('#termForm').validate().form()){
			$('#termForm').ajaxSubmit({
				success:function(data){
					if(data.success){
						window.location.href = $.rootPath + "manager/term/index.do";
					} else {
						
					}
				}
			});
		}
	});
	
	$('#cancle').on('click', function(){
		window.location.href = $.rootPath + 'manager/term/index.do';
	});
	
	$('#year').datetimepicker({
		format : 'yyyy ',
		startView : 4,
		maxView : 4,
		minView : 4,
		todayBtn : true,
		autoclose: true
	});
});