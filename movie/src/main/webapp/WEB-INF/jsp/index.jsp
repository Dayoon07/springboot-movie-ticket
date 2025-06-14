<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>index.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<h1 class="text-2xl font-semibold mb-10">형식상 있는 index.jsp</h1>
	
	<a href="${ cl }/signup" class="text-black border-black border hover:bg-black hover:text-white duration-300 m-4 font-bold py-2 px-4 rounded">
		관리자 계정 입력
	</a>
	
	<a href="${ cl }/reservation-code" class="text-black border-black border hover:bg-black hover:text-white duration-300 m-4 font-bold py-2 px-4 rounded">
		영화 예매 코드 확인
	</a>
	
	<a href="${ cl }/analyze" class="text-black border-black border hover:bg-black hover:text-white duration-300 m-4 font-bold py-2 px-4 rounded">
		영화 예매 프로그램 DB 데이터 시각화
	</a>
	
	<script src="https://cdn.tailwindcss.com/3.4.16"></script>
</body>
</html>