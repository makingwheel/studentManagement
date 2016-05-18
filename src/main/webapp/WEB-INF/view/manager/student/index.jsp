<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">学生管理</h1>
	<div class="btn-add">
		<button type="submit" class="btn btn-primary but-so">搜索</button>
	</div>
	<div class="so">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="inputEmail3" class="col-xs-1 control-label">学号：</label>
				<div class="col-xs-2">
					<input type="text" class="form-control" id="" />
				</div>
				<label for="inputEmail3" class="col-xs-1 control-label">姓名：</label>
				<div class="col-xs-2">
					<input type="text" class="form-control" id="" />
				</div>
				<button type="submit" class="btn btn-primary but-so">搜索</button>
			</div>
		</form>
	</div>
	<table id="studentTable" class=""></table>
</v:layout>
<script src="/studentManagement/resources/js/manager/student/index.js"></script>
