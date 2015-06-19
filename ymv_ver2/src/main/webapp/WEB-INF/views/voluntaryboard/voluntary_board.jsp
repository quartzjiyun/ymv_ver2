<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<caption>목록</caption>
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 10%;" />
				<col style="width: 10%;" />
				<col style="width: 25%;" />
				<col style="width: 25%;" />
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
				<c:forEach var="bvo" items="${requestScope.lvo.list}">
					<tr>
						<td>${bvo.recruitNo }</td>
						<td><a
							href="${initParam.root}voluntary_showContentRecruitVol.ymv?memberNo=${sessionScope.mvo.memberNo }&recruitNo=${bvo.recruitNo}">
								${bvo.title }</a></td>
						<td>${bvo.field }</td>
						<td>${bvo.location }</td>
						<td>${bvo.startDate }</td>
						<td>${bvo.endDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<br><c:if test="${sessionScope.mvo.memberType=='company' }">
		<a href="${initParam.root }voluntary_register_view.ymv">글쓰기	</a>
</c:if>
<c:if test="${sessionScope.mvo.memberType=='admin' }">
		<a href="${initParam.root }voluntary_register_view.ymv">글쓰기	</a>
</c:if>
<br></br>
<c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
	<a
		href="voluntary_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}"><img
		src="${initParam.root }/img/left_arrow_btn.gif"></a>
</c:if>
&nbsp;&nbsp;
<c:forEach var="i"
	begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
	end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
	<c:choose>
		<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
			<a href="voluntary_board.ymv?pageNo=${i}">${i}</a>
		</c:when>
		<c:otherwise>
   ${i}
   </c:otherwise>
	</c:choose>
</c:forEach>
&nbsp;&nbsp;
<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
	<a	href="voluntary_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">
		<img src="${initParam.root }/img/right_arrow_btn.gif">
	</a>
</c:if>
	</div>
</div>











