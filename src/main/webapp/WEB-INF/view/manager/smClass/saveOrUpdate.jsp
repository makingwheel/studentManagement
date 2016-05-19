<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">学期信息管理</h1>
	<form id="smClassForm" class="form-horizontal" action="<c:url value="/manager/smClass/saveOrUpdate.do" />" 
		method="post">
		<input type="hidden" name="id" value="${smClass.id }" >
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">年级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="grade" name="grade" value="${smClass.grade}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">学院：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="college" name="college" value="${smClass.college}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="smClass" name="smClass" value="${smClass.smClass}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
			<button type="button" id="submit" class="btn btn-primary">提交</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" id="cancle" class="btn btn-default">取消</button>
			</div>
		</div>
	</form>
</v:layout>
<script src="/studentManagement/resources/js/manager/smClass/saveOrUpdate.js"></script>
