<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">学生信息管理</h1>
	<form id="studentForm" class="form-horizontal" action="<c:url value="/manager/student/saveOrUpdate.do" />" 
		method="post">
		<input type="hidden" name="id" value="${student.id }" >
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="name" value="${student.name}">
			</div>
			<label for="" class="col-sm-2 control-label">学号：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="count" value="${student.count}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="sex" value="${student.sex}">
			</div>
			<label for="" class="col-sm-2 control-label">民族：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="nation" value="${student.nation}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">出生日期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="birthday" value="${student.birthday}">
			</div>
			<label for="" class="col-sm-2 control-label">籍贯：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="placeOfOrigin" value="${student.placeOfOrigin}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">qq：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="qq" value="${student.qq}">
			</div>
			<label for="" class="col-sm-2 control-label">手机：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="tel" value="${student.tel}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="email" value="${student.email}">
			</div>
			<label for="" class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="classId" value="${student.classId}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">学位：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="degree" value="${student.degree}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">家庭住址：</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="" name="address" value="${student.address}">
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
<script src="/studentManagement/resources/js/manager/student/saveOrUpdate.js"></script>
