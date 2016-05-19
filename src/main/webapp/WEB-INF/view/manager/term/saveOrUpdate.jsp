<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">学期信息管理</h1>
	<form id="termForm" class="form-horizontal" action="<c:url value="/manager/term/saveOrUpdate.do" />" 
		method="post">
		<input type="hidden" name="id" value="${term.id }" >
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">年份：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="year" name="year" value="<fmt:formatDate value="${term.year}" pattern="yyyy"/>" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">课程信息：</label>
			<div class="col-sm-3">
				<select class="form-control" id="" name="term">
					<option value="下学期" <c:if test="${term.term eq '下学期'}">selected="selected"</c:if>>下学期</option>
					<option value="上学期" <c:if test="${term.term eq '上学期'}">selected="selected"</c:if>>上学期</option>
				</select>
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
<script src="/studentManagement/resources/js/manager/term/saveOrUpdate.js"></script>
