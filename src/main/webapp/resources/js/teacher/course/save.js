$(function(){
	$('#submit').on('click',function(){
		$('#timeTableForm').ajaxSubmit({
			success:function(data){
				if(data.success){
					window.location.href = $.rootPath + "teacher/course/index.do";
				} else {
					
				}
			}
		});
	});
	
	$('#cancle').on('click', function(){
		window.location.href = $.rootPath + 'teacher/course//index.do';
	});
});