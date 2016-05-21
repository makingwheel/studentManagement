<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<h1 class="page-header">课表信息管理</h1>
	<form id="timeTableForm" class="form-horizontal" action="<c:url value="/manager/timeTable/saveOrUpdate.do" />" 
		method="post">
		<input type="hidden" name="id" value="${timeTable.timeTeacherCourseId }" >
		<input type="hidden" name="teacherCourseId" value="${timeTable.teacherCourseId }" />
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">课程名称：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="" value="${timeTable.courseName}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">教师名称：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="" value="${timeTable.teacherName}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">起始周：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="beginWeek" value="${timeTable.beginWeek}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">结束周：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="endWeek" value="${timeTable.endWeek}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">星期：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="week" value="${timeTable.week}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">节：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="node" value="${timeTable.node}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">地点：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="" name="place" value="${timeTable.place}">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-5">
				<!-- <input type="text" class="form-control" id="" name="email" value=""> -->
				<c:choose>
					<c:when test="${! empty timeTable.classId}">
						<input type="text" class="form-control" id="" name="place" 
						value="${timeTable.grade}级${timeTable.college }${timeTable.smClass }" readonly="readonly">
					</c:when>
					<c:otherwise>
						<select class="form-control" id="classId" name="classId">
							<c:forEach var="tem" items="${smClasses}">
								<option value="${tem.id }">
									<c:out value="${tem.grade}"/>级
									<c:out value="${tem.college }" />
									<c:out value="${tem.smClass }" />
								</option>
							</c:forEach>
						</select>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">课程信息：</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="" name="" value="${timeTable.message}" readonly="readonly">
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
<script src="/studentManagement/resources/js/manager/timeTable/saveOrUpdate.js"></script>
