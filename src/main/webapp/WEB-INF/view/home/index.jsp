<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="v" tagdir="/WEB-INF/tags" %>
<v:layout>
	<input type="hidden" id="userType" value="${user.type}">
	<h1 class="page-header">通知</h1>
	<table id="notice" class=""></table>
</v:layout>
<script src="/studentManagement/resources/js/home/index.js"></script>
