<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags" %>
<v:layout>
	<h1 class="page-header">课表查询</h1>
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
	<table id="timeTable" class=""></table>
</v:layout>
<script src="/studentManagement/resources/js/student/timetable/index.js"></script>
