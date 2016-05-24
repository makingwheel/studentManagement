<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">教师信息管理</h1>
	<form id="teacherForm" class="form-horizontal" action="<c:url value="/manager/teacher/saveOrUpdate.do" />" 
		method="post">
		<input type="hidden" name="id" value="${teacher.id }" >
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="name" value="${teacher.name}">
			</div>
			<label for="" class="col-sm-2 control-label">教师号：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="count" value="${teacher.count}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="sex" value="${teacher.sex}">
			</div>
			<label for="" class="col-sm-2 control-label">民族：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="nation" value="${teacher.nation}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">出生日期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="birthday" name="birthday" 
				value="<fmt:formatDate value="${teacher.birthday}" pattern="yyyy-MM-dd"/>" readonly="readonly">
			</div>
			<label for="" class="col-sm-2 control-label">籍贯：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="placeOfOrigin" value="${teacher.placeOfOrigin}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">qq：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="qq" value="${teacher.qq}">
			</div>
			<label for="" class="col-sm-2 control-label">手机：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="tel" value="${teacher.tel}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="email" value="${teacher.email}">
			</div>
		<label for="" class="col-sm-2 control-label">等级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="level" value="${teacher.level}">
			</div>
		</div>
		<div class="form-group">
			<%-- <label for="" class="col-sm-2 control-label">学位：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="degree" value="${teacher.degree}">
			</div> --%>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">家庭住址：</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="" name="address" value="${teacher.address}">
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
<script src="/studentManagement/resources/js/manager/teacher/saveOrUpdate.js"></script>
