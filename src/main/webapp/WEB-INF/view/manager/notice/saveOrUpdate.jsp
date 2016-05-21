<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">通知信息管理</h1>
	<form id="noticeForm" class="form-horizontal" action="<c:url value="/manager/notice/saveOrUpdate.do" />" method="post">
		<input type="hidden" name="id" value="${notice.id }">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">通知标题：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="title" value="${notice.title}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">通知内容：</label>
			<div class="col-xs-5">
				<textarea rows="4" class="form-control" id="" name="message">
					<c:out value="${notice.message}"></c:out>
				</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-3"></div>
			<button type="button" id="submit" class="btn btn-primary">提交</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" id="cancle" class="btn btn-default">取消</button>
		</div>
	</form>
</v:layout>
<script src="/studentManagement/resources/js/manager/notice/saveOrUpdate.js"></script>
