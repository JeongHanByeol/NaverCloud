<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jstl.jsp" %>
<!DOCTYPE html>
<form:form modelAttribute="userInfoVo">
	아이디 : <form:input path="userId"/><form:errors path="userId" /><br />
	비번 : <form:input path="userPw"/><form:errors path="userPw" /><br />
	이름 : <form:input path="userName"/><form:errors path="userName" /><br />
	높이 : <form:input path="userHeight"/><br />
	무게 : <form:input path="userWeight"/><br />
	<form:button>전송</form:button>
</form:form>