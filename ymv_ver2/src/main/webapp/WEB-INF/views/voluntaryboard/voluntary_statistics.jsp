<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center>
	<div class="container">
		<h2>전체 선호도 순위</h2>
		<div class="row">
			<div class = "col-md-3">
			</div>
			<div class="col-md-6 col-sm-6">
				<table class="table table-striped table-hover">
					<tr>
						<th>순위</th>
						<th>분야</th>
						<th>신청수</th>
						<!-- 	<th>나이</th> -->
					</tr>
					<c:forEach items="${requestScope.list}" var="i">
						<tr>
							<th>${i.RANKING }</th>
							<td>${i.FIELD }</td>
							<td>${i.COUNT }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</center>


























<%-- <br><br>
		<table border="1" cellpadding="5">
			<tr>
				<th>순위</th>
				<th>분야</th>
				<th>신청수</th>
				<th>나이</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="i">
				<tr>
					<td>${i.RANKING }</td>
					<td>${i.FIELD }</td>
					<td>${i.APPLICATE_COUNT }</td>
					<td>${i.AGE }</td>
					<!-- {RANKING=1, FIELD=아동, AGE=20, APPLICATE_COUNT=18} -->
				</tr>
			</c:forEach>
		</table> --%>