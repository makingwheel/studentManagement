<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">基本信息</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.name}">
			</div>
			<label for="" class="col-sm-2 control-label">教工号：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.count}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.sex}">
			</div>
			<label for="" class="col-sm-2 control-label">出生日期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.birthday}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">qq：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.qq}">
			</div>
			<label for="" class="col-sm-2 control-label">手机：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.tel}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.email}">
			</div>
			<%-- <label for="" class="col-sm-2 control-label">：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" value="${manager.classId}">
			</div> --%>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">家庭住址：</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="" value="${manager.address}">
			</div>
		</div>
	</form>
</v:layout>
<!-- <script src="/managerManagement/resources/js/manager/index.js"></script> -->
