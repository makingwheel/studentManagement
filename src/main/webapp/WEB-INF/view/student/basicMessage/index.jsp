<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">基本信息</h1>
	<form id="studentForm" class="form-horizontal" method="post" action="<c:url value="/student/basicMessage/update.do"/>">
		<input type="hidden" name="id" value="${student.id}" />
		<input type="hidden" name="classId" value="${student.classId}">
		<input type="hidden" name="classId" value="${student.status}">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="name" value="${student.name}" readonly="readonly" />
			</div>
			<label for="" class="col-sm-2 control-label">学号：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="count" value="${student.count}" readonly="readonly" />
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="sex" value="${student.sex}" readonly="readonly" />
			</div>
			<label for="" class="col-sm-2 control-label">民族：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="nation" value="${student.nation}" readonly="readonly" />
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">出生日期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="birthday" 
				value="<fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/>" readonly="readonly" />
			</div>
			<label for="" class="col-sm-2 control-label">籍贯：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="placeOfOrigin" value="${student.placeOfOrigin}" readonly="readonly" />
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">qq：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="qq" value="${student.qq}">
			</div>
			<label for="" class="col-sm-2 control-label">手机：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="tel" value="${student.tel}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="email" value="${student.email}">
			</div>
			<label for="" class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" value="${smClass.grade}级${smClass.college}${smClass.smClass}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">学位：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="degree" value="${student.degree}" readonly="readonly" />
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
<script src="/studentManagement/resources/js/lib/bootstrapQ/bootstrapQ.min.js"></script>
<script src="/studentManagement/resources/js/student/basicMessage/info.js"></script>
