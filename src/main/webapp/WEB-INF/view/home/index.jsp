<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags"%>
<v:layout>
	<input type="hidden" id="userType" value="${user.type}">
	<h1 class="page-header">通知</h1>
	<c:if test="${user.type eq 0 }">
		<div class="btn-add">
		<button type="button" id="add" class="btn btn-primary ">添加</button>
	</div>
	</c:if>
	<table id="notice" class=""></table>
</v:layout>
<script src="/studentManagement/resources/js/home/index.js"></script>
