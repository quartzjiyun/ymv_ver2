<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-10 col-sm-offset-1">
	<h3>
		<p class="text-center">봉사 전체 목록</p>
	</h3>
	<table class="table table-striped table-hover">
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
				<th scope="col">NO</th>
				<th scope="col">제목</th>
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
	<br>
	<c:if test="${sessionScope.mvo.memberType=='company' }">
					<div class="col-sm-12">
    <div class="pull-right"> 
			<a href="${initParam.root }voluntary_register_view.ymv"
				class="btn btn-default btn-xs">글쓰기 </a>
		</div></div>
	</c:if>
	<c:if test="${sessionScope.mvo.memberType=='admin' }">
					<div class="col-sm-12">
    <div class="pull-right"> 
			<a href="${initParam.root }voluntary_register_view.ymv"
				class="btn btn-default btn-xs">글쓰기 </a>
		</div></div>
	</c:if>
	<br></br>
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="voluntary_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="#">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="voluntary_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="voluntary_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="#">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>










