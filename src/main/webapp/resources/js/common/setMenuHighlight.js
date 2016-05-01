$(function(){
	$('#menuContain li').each(function(index , li){
		var pathName = window.location.pathname,
			$li = $(li);
			
		if(pathName === $li.find('a').attr('href')){
			$li.addClass('active');
			$li.siblings().removeClass('active');
		}
	});
});