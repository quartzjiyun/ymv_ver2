<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

	$(function() {
		$("#datepicker1, #datepicker2").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					prevText : '이전 달',
					nextText : '다음 달',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					showMonthAfterYear : true,
					yearSuffix : '년'
				});
	});
</script>

<div class="col-sm-3"></div>
<div class="col-sm-6">
	<h2>통합 검색</h2>
	<form action="search_board.ymv">
		<table class="table table-striped table-hover">
			<tr>
				<th class="info"><h4 class="text-center">제목</h4></th>
				<td><input class="form-control" type="text" name="title"
					id="title" placeholder="Title을 정해주세요."></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">분야</h4></th>
				<td><select class="selectpicker" data-style="btn-primary"
					id="field" name="field">
						<option value="">-분야-</option>
						<c:forEach items="${requestScope.fieldlist }" var="f">
							<option value="${f.field }">${f.field }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">지역</h4></th>
				<td><select class="selectpicker" data-style="btn-primary"
					id="location" name="location">
						<!-- 지역(*도 별로) DB에서 받아오기 -->
						<option value="">-지역-</option>
						<c:forEach items="${requestScope.locationlist }" var="l">
							<option value="${l.location }">${l.location }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">시작시간</h4></th>
				<td><input id="datepicker1" name="startDate"
					class="form-control" type="text" placeholder="시작시간을 설정해주세요">
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">끝시간</h4></th>
				<td><input id="datepicker2" name="endDate" class="form-control"
					type="text" placeholder="종료시간을 설정해주세요"></td>
			</tr>
		</table>
		<br> <input type="submit" class="btn btn-primary" value="검색">
	</form>
	<hr>
</div>