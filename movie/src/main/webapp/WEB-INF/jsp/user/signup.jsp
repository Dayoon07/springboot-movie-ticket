<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>signup.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
	<h1>관리자 계정 입력</h1>
	
	<form action="${ cl }/signupF" method="post" autocomplete="off">	
		<div>
			<label for="name">이름</label><br />
			<input type="text" name="name" id="name" style="width: 100px;" required>
		</div>
		
		<div>
			<label for="email">이메일</label><br />
			<input type="text" name="email" id="email" style="width: 100px;" required>
		</div>
		
		<div>
			<label for="password">비밀번호</label><br />
			<input type="text" name="password" id="password" style="width: 100px;" required>
		</div>
		
		<div>
			<label for="p1">전화번호</label> <br />
			<input type="text" name="p1" id="p1" style="width: 70px;" maxlength="3" required> - 
			<input type="text" name="p2" id="p2" style="width: 70px;" maxlength="4" required> - 
			<input type="text" name="p3" id="p3" style="width: 70px;" maxlength="4" required>
		</div><br />
		
		<button type="submit">회원가입</button>
	</form>
</body>
</html>