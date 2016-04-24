$(function(){
	var currentPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var post = currentPath.indexOf(pathName);
	var losthostPath = currentPath.substring(0,post);
	var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	
	
	
	console.log('currentPath ' , currentPath);
	console.log('pathName ' , pathName);
	console.log('post ' , post);
	console.log('losthostPath ' , losthostPath);
	console.log('projectName ' , projectName);
	
	$.rootPath = projectName + '/';
});