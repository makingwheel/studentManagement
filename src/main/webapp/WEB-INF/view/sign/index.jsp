<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>学生教师信息管理系统</title>
<link rel="icon" href="/studentManagement/resources/images/sm.ico" >
<link rel="stylesheet" href="/studentManagement/resources/css/normalize.css">
</head>
<body>
	<div class="login">
		<h1>欢迎您</h1>
		<form id="signOnForm" method="post">
			<input type="text" name="count" placeholder="用户名"/>
			<input type="password" name="password" placeholder="密码"/>
			<div>
			<label class="radio_label"><input type="radio" id="type" name="type" value="" class="radio"/>学生</label>
			<label class="radio_label"><input type="radio" id="type" name="type" value="" class="radio"/>教师</label>
			<label class="radio_label"><input type="radio" id="type" name="type" value="" class="radio"/>管理员</label>
			</div>
			<button type="submit" class="btn btn-primary btn-block btn-large">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
		</form>
	</div>
</body>
<script src="/studentManagement/resources/js/lib/jquery/jquery.min.js"></script>
<script src="/studentManagement/resources/js/lib/jquery-validate/jquery.validate.min.js"></script>
<script src="/studentManagement/resources/js/lib/jquery-validate/additional-methods.min.js"></script>
<script src="/studentManagement/resources/js/lib/jquery-validate/localization/messages_zh.min.js"></script>
<script src="/studentManagement/resources/js/sign/signon.js"></script>
</html>
