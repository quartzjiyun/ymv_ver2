<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table" >
			<caption>목록</caption>
			<thead>
				<tr>
					<th class="boardNo">NO</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="timePosted">등록시간</th>
					<th class="hit">조회수</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="bvo" items="${requestScope.lvo.list}">
					<tr>
						<td>${bvo.boardNo }</td>
						<td><a href="${initParam.root}notice_showContent.ymv?boardNo=${bvo.boardNo}">	${bvo.title }</a></td>
						<td>${bvo.writer }</td>
						<td>${bvo.timePosted }</td>
						<td>${bvo.hit }</td>
					</tr>
				</c:forEach>
				</tbody>
		</table>
		<br>
		<c:if test="${sessionScope.mvo.memberType=='admin' }">
		 <a href="${initParam.root}notice_register_view.ymv">글쓰기</a>
		</c:if>
		<br></br>
		<c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
			<a
				href="notice_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}"><img
				src="${initParam.root }/img/left_arrow_btn.gif"></a>
		</c:if>
		<c:forEach var="i"
			begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
			end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
					<a href="notice_board.ymv?pageNo=${i}">${i}</a>
				</c:when>
				<c:otherwise>
   ${i}
   </c:otherwise>
			</c:choose>
		</c:forEach>
		&nbsp;&nbsp;
		<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
			<a
				href="notice_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    endPageOfPageGroup+1}">
				<img src="${initParam.root }/img/right_arrow_btn.gif">
			</a>
		</c:if>
	</div>
</div>










