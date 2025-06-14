<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>reservation-code.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div style="display: grid; grid-template-columns: 425px 425px 425px 425px;">
		<c:forEach var="sarmt" items="${ selectAllReservationMovieTicket }" varStatus="varSarmt">
			<div style="margin-bottom: 30px;">
				${ varSarmt.index + 1 } <br />
				<span onclick="navigator.clipboard.writeText(this.innerText).then(() => console.log(this.innerText))" 
					style="font-size: xx-large; font-weight: bold; cursor: pointer;" 
				>
					${ sarmt.reservationCode }
				</span>
			</div>
		</c:forEach>
	</div>
</body>
</html>