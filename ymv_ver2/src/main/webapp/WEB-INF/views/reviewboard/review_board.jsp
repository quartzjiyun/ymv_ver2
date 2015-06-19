<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>봉사 후기</h3>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<%--table 시작할때 colgroup으로 사이즈 조절  하단에서는 scope로 col 찍으면됨--%>
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 40%;" />
				<col style="width: 17%;" />
				<col style="width: 17%;" />
				<col style="width: 17%;" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">등록시간</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bvo" items="${requestScope.lvo.list}">
					<tr>
						<td>${bvo.boardNo}</td>
						<td><a
							href="${initParam.root}review_showContent.ymv?boardNo=${bvo.boardNo}">${bvo.title }</a></td>
						<td>${bvo.writer }</td>
						<td>${bvo.timePosted }</td>
						<td>${bvo.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:choose>
		<c:when test="${sessionScope.mvo==null}">
		
		 </c:when>
		 <c:otherwise>
			 <a href="${initParam.root}review_register_view.ymv">글쓰기</a>
			 </c:otherwise>
			 </c:choose>
		 <c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
    <a href=
    "review_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}"><img src="${initParam.root }/img/left_arrow_btn.gif"></a>
    </c:if>
    &nbsp;&nbsp;
   <c:forEach var="i" 
   begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
    end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
    <c:choose>
    <c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
    <a href="review_board.ymv?pageNo=${i}">${i}</a>
    </c:when>
    <c:otherwise>
   ${i}
   </c:otherwise>
   </c:choose>
   </c:forEach>    
   &nbsp;&nbsp;
    <c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
    <a href=
    "review_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    endPageOfPageGroup+1}">
    <img src="${initParam.root }/img/right_arrow_btn.gif">
    </a>
    </c:if>       
	</div>
</div>











