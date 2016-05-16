<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">基本信息</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.name}">
			</div>
			<label for="" class="col-sm-2 control-label">学号：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.count}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.sex}">
			</div>
			<label for="" class="col-sm-2 control-label">民族：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.nation}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">出生日期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.birthday}">
			</div>
			<label for="" class="col-sm-2 control-label">籍贯：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.placeOfOrigin}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">qq：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.qq}">
			</div>
			<label for="" class="col-sm-2 control-label">手机：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.tel}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.email}">
			</div>
			<label for="" class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.classId}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">学位：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${student.degree}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">家庭住址：</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="" value="${student.address}">
			</div>
		</div>
	</form>
</v:layout>
<!-- <script src="/studentManagement/resources/js/student/index.js"></script> -->
