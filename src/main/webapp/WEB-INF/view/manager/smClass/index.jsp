<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">班级管理</h1>
	<div class="btn-add">
		<button type="button" id="add" class="btn btn-primary ">添加</button>
	</div>
	<!-- <div class="so">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="" class="col-xs-1 control-label">学号：</label>
				<div class="col-xs-2">
					<input type="text" class="form-control" id="count" />
				</div>
				<label for="" class="col-xs-1 control-label">姓名：</label>
				<div class="col-xs-2">
					<input type="text" class="form-control" id="name" />
				</div>
				<button type="button" id="search" class="btn btn-primary but-so">搜索</button>
			</div>
		</form>
	</div> -->
	<table id="smClassTable" class=""></table>
</v:layout>
<script src="/studentManagement/resources/js/manager/smClass/index.js"></script>
