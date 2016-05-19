<%@tag pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>学生教师信息管理系统</title>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">学生教师信息管理系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="">您好: <em><c:out value="${user.name}" /></em></a></li>
					<li><a href="">退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul id="menuContain" class="nav nav-sidebar">
				<li><a href="<c:url value="/home/index.do" />">首页</a></li>
					<c:if test="${user.type eq 0 }">
						<li><a href="<c:url value="/manager/info/index.do" />">基本信息</a></li>
						<li><a href="<c:url value="/manager/student/index.do" />">学生管理</a></li> 
						<li><a href="<c:url value="/manager/teacher/index.do" />">教师管理</a></li> 
						<li><a href="<c:url value="/manager/timeTable/index.do" />">课表管理</a></li>
						<li><a href="<c:url value="/manager/course/index.do" />">课程管理</a></li>
						<li><a href="<c:url value="/manager/term/index.do" />">学期管理</a></li>
						<li><a href="<c:url value="/manager/smClass/index.do" />">班级管理</a></li>
						
					</c:if>
					<c:if test="${user.type eq 1 }">
						<li><a href="<c:url value="" />">基本信息</a></li> 
						<li><a href="<c:url value="" />">课程管理</a></li> 
						<li><a href="<c:url value="" />">成绩公布</a></li>
					</c:if>
					<c:if test="${user.type eq 2 }">
						<li><a href="<c:url value="/student/basicMessage/index.do" />">基本信息</a></li> 
						<li><a href="<c:url value="/student/timetable/index.do" />">课表查询</a></li> 
						<li><a href="<c:url value="/student/achievement/index.do" />">成绩查询</a></li>
					</c:if>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="sm_contain">
					<jsp:doBody></jsp:doBody>
				</div>
			</div>
		</div>
	</div>
</body>
</html>