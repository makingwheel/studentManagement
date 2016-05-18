<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">基本信息</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.name}">
			</div>
			<label for="" class="col-sm-2 control-label">教师号：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.count}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.sex}">
			</div>
			<label for="" class="col-sm-2 control-label">民族：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.nation}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">出生日期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.birthday}">
			</div>
			<label for="" class="col-sm-2 control-label">籍贯：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.placeOfOrigin}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">qq：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.qq}">
			</div>
			<label for="" class="col-sm-2 control-label">手机：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.tel}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.email}">
			</div>
			<label for="" class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.classId}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">学位：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${teacher.degree}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">家庭住址：</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="" value="${teacher.address}">
			</div>
		</div>
	</form>
</v:layout>
<!-- <script src="/teacherManagement/resources/js/teacher/index.js"></script> -->
