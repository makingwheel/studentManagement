<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">课程信息管理</h1>
	<form id="courseForm" class="form-horizontal" action="<c:url value="/manager/course/saveOrUpdate.do" />" 
		method="post">
		<input type="hidden" name="id" value="${course.id }" >
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">名称：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="name" value="${course.name}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">课程信息：</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="" name="message" value="${course.message}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-5"></div>
			<button type="button" id="submit" class="btn btn-primary">提交</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" id="cancle" class="btn btn-default">取消</button>
		</div>
	</form>
</v:layout>
<script src="/studentManagement/resources/js/manager/course/saveOrUpdate.js"></script>
