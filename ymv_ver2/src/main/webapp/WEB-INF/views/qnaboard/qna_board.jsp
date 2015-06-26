<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-10 col-sm-offset-1">
	<h3>
		<p class="text-center">Q & A</p>
	</h3>
	<table class="table table-striped table-hover">
		<%-- <colgroup>
			<col style="width: 5%;" />
			<col style="width: 35%;" />
			<col style="width: 10%;" />
			<col style="width: 25%;" />
			<col style="width: 5%;" />
		</colgroup> --%>
		<thead>
			<tr>
				<th class="qnaNo">NO</th>
				<th class="title">제목</th>
				<th class="writer">작성자</th>
				<th class="timePosted">작성일</th>
				<th class="hit">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lvo" items="${requestScope.lvo.list}">
				<tr>
					<td>${lvo.qnaNo }</td>
					<%-- lvo에 relevel이 0이 아니면 답변글이므로 relevel만큼 공백으로 제목을 밀어준다  --%>
					<td class="titleView">
						<%--admin일때만 답변하는 버튼이 나오게 하기!!@아직안함! --%> <c:if
							test="${lvo.relevel!=0}">
							<c:forEach begin="0" end="${lvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
							<img src="${initParam.root }/img/reply.jpg">
						</c:if> <a href="${initParam.root}qna_showContent.ymv?qnaNo=${lvo.qnaNo}">
							${lvo.title }</a>
					<td>${lvo.writer }</td>
					<td>${lvo.timePosted }</td>
					<td>${lvo.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
			<div class="col-sm-12">
    <div class="pull-right"> 
	<a href="${initParam.root }qna_register_view.ymv"	class="btn btn-default btn-xs">글쓰기 </a> <br></br></div></div>
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="qna_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>


<%-- 
	<c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
		<a
			href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}"><img
			src="${initParam.root }/img/left_arrow_btn.gif"></a>
	</c:if>
	&nbsp;&nbsp;
	PagingBean 을 이용해서 현재 페이지에 해당되는 페이지그룹의
         시작페이지~~마지막페이지까지 화면에 보여준다. 
         이 때 현재 페이지를 제외한 나머지 페이지는 링크를 걸어
         해당 페이지에 대한 게시물 리스트 조회가 가능하도록 한다. 
   
	<c:forEach var="i"
		begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
		end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
		<c:choose>
			<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
				<a href="qna_board.ymv?pageNo=${i}">${i}</a>
			</c:when>
			<c:otherwise>
   ${i}
   </c:otherwise>
		</c:choose>
	</c:forEach>
	&nbsp;&nbsp;
	다음 페이지 그룹이 있으면 화살표 이미지를 보여준다.
         이미지 링크는 현재 페이지 그룹의 마지막 번호 + 1 => 
         다음 그룹의 시작 페이지로 링크한다. 
         right_arrow_btn.gif
   
	<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
		<a
			href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">
			<img src="${initParam.root }/img/right_arrow_btn.gif">
		</a>
	</c:if> --%>