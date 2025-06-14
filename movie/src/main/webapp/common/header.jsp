<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="cl" value="${ pageContext.request.contextPath }" />

	<div class="md:flex justify-between items-center p-4 ">
		<div class="flex items-center space-x-6">
			<div class="flex items-center space-x-3">
				<h2	class="text-6xl font-semibold text-red-500 font-mono cursor-pointer">
					<a href="${ cl }/">CGV</a>
				</h2>
			</div>
			<p class="font-semibold text-2xl mt-1">영화 예매 프로그램</p>
		</div>
	</div>