<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags" %>
<v:layout>
	<h1 class="page-header">成绩管理</h1>
	<div class="so">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="" class="col-xs-1 control-label">学期：</label>
				<div class="col-xs-2">
					<!-- <input type="text" class="form-control" id="termId" /> -->
					<select class="form-control" id="termId">
						<option value="">--请选择--</option>
						<c:forEach var="term" items="${terms}">
							<option value="${term.id}">
								<fmt:formatDate value="${term.year}" pattern="yyyy"/>
								<c:out value="${term.term }"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
				<button type="button" id="search" class="btn btn-primary but-so">搜索</button>
			</div>
		</form>
	</div>
	<table id="achievement"></table>
</v:layout>
<link href="/studentManagement/resources/css/lib/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
<script src="/studentManagement/resources/js/lib/bootstrap3-editable/bootstrap-table-editable.js"></script>
<script src="/studentManagement/resources/js/lib/bootstrap3-editable/bootstrap-editable.min.js"></script>
<script src="/studentManagement/resources/js/teacher/achievement/index.js"></script>
