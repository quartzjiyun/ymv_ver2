<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-10 col-sm-offset-1">
	<h3>
		<p class="text-center">봉사 검색 결과</p>
	</h3>
	<table class="table table-striped table-hover">
			<%-- <colgroup>
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
			</colgroup> --%>
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
							href="${initParam.root}voluntary_showContentRecruitVol.ymv?recruitNo=${bvo.recruitNo}">
								${bvo.title }</a></td>
						<td>${bvo.field }</td>
						<td>${bvo.location }</td>
						<td>${bvo.startDate }</td>
						<td>${bvo.endDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="search_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="search_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="search_board.ymv?pageNo=${i}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="search_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="search_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>




<%-- 



<c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
	<a
		href="search_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }"><img
		src="${initParam.root }/img/left_arrow_btn.gif"></a>
</c:if>
&nbsp;&nbsp;
<c:forEach var="i"
	begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
	end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
	<c:choose>
		<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
			<a href="search_board.ymv?pageNo=${i}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">${i}</a>
		</c:when>
		<c:otherwise>
   ${i}
   </c:otherwise>
	</c:choose>
</c:forEach>
&nbsp;&nbsp;
<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
	<a	href="search_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}&field=${scvo.field }&location=${scvo.location }&startDate=${scvo.startDate }&endDate=${scvo.endDate }">
		<img src="${initParam.root }/img/right_arrow_btn.gif">
	</a>
</c:if>
	</div>
 --%>



