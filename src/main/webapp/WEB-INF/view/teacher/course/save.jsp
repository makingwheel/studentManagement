<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">课程申报</h1>
	<form id="timeTableForm" class="form-horizontal" action="<c:url value="/teacher/course/save.do" />" 
		method="post">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">学期：</label>
			<div class="col-sm-3">
				<select class="form-control" id="" name="termId">
					<c:forEach var="tem" items="${terms}">
						<option value="${tem.id }">
							<fmt:formatDate value="${tem.year}" pattern="yyyy"/>年
							<c:out value="${tem.term }" />
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">课程名称：</label>
			<div class="col-sm-3">
				<select class="form-control" id="" name="courseId">
					<c:forEach var="tem" items="${courses}">
						<option value="${tem.id }">
							<c:out value="${tem.name}"/>
						</option>
					</c:forEach>
				</select>
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
<script src="/studentManagement/resources/js/teacher/course/save.js"></script>
