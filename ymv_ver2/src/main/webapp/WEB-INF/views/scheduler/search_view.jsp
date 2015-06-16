<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script>
<script>
$(function() {
  $( "#datepicker1, #datepicker2" ).datepicker({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dayNames: ['일','월','화','수','목','금','토'],
    dayNamesShort: ['일','월','화','수','목','금','토'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
  });
});
</script>

<form action="scheduler_board.ymv">
<table border="1">
	<tr>
		<td>제목</td><td><input type="text" name="title" id="title"></td>
	</tr>
	<tr>
		<td>분야</td>
		<td>
			<select id="field" name="field"><!-- 분야(노인, 아동, 장애, 동물, 환경) DB에서 받아오기 -->
				<option value="">-분야-</option>
				<c:forEach items="${requestScope.fieldlist }" var="f">
					<option value="${f.field }" >${f.field }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>지역</td>
		<td>
			<select id="location" name="location"> <!-- 지역(*도 별로) DB에서 받아오기 -->
				<option value="">-지역-</option>
				<c:forEach items="${requestScope.locationlist }" var="l">
					<option value="${l.location }">${l.location }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>시작시간</td><td><input type="text" id="datepicker1" name="startDate" placeholder="시작날짜">
	</tr>
	<tr>
		<td>끝시간</td><td><input type="text" id="datepicker2" name="endDate" placeholder="종료날짜">
		</td>
	</tr>
</table>
<br>
 <input type="submit" value="검색" > 
</form>