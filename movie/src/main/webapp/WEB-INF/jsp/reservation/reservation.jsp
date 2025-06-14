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
	<c:forEach var="sarmt" items="${ selectAllReservationMovieTicket }">
		<div style="display: flex; cursor: pointer;" onmouseover="this.style.backgroundColor='lightgray'" onmouseout="this.style.backgroundColor='white'">
			<div style="margin-right: 10px;">
				<img alt="..." src="${ sarmt.reservationMoviePosterUrl }" style="width: 200px;">
			</div>
			<div>
				<h2>
					영화 제목 : ${ sarmt.movieTitle } (${ sarmt.cinemaName }) <br />
					상영시간 : ${ sarmt.startShowTime }
				</h2>
				<h3>관람 연령 : ${ sarmt.ratingAge }</h3>
				<p>
					예약 좌석 : ${ sarmt.reservedSeats } <br />
					총 관람료 : <fmt:formatNumber value="${ sarmt.totalAmount }" type="number" />원 <br />
				</p>
			</div>
		</div>
	</c:forEach>
</body>
</html>