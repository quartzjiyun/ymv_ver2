<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="col-md-12">
	<c:forEach var="date" items="${requestScope.dateList }">
	${date.DATE_LIST}
		<table class="table">
			<caption><hr></caption>
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col" >NO</th>
					<th scope="col" >제목</th>
					<th scope="col">분야</th>
					<th scope="col">지역</th>
					<th scope="col">시작일</th>
					<th scope="col">완료일</th>
				</tr>
			</thead>
			<tbody>	
				<c:forEach var="bvo" items="${requestScope.list}">
				<c:if test="${date.DATE_LIST==bvo.checkDate}">
					<tr>
						<td>${bvo.recruitNo }</td>
						<td><a href="${initParam.root}voluntary_showContentRecruitVol.ymv?recruitNo=${bvo.recruitNo}">${bvo.title }</a></td>
						<td>${bvo.field }</td>
						<td>${bvo.location }</td>
						<td>${bvo.startDate }</td>
						<td>${bvo.endDate }</td>
					</tr>
					</c:if>
				</c:forEach>		
			</tbody>
		</table>
		</c:forEach>
	</div>
</div>











