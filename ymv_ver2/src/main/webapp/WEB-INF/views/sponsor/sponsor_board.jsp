<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
	$("#sponsorForm").submit(function() {
		if ($("#currentPrice").val() == "") {
			alert("금액을 선택해 주세요");
			return false;
		}
	});
});
	
</script>
<h3>
		<p class="text-center">후원게시판</p>
	</h3>
<c:forEach items="${requestScope.lvo.list}" var="sponsor" varStatus="i">
<div class="col-md-4" >
	<div class="col-md-1">
		</div>
	<form id="sponsorForm" action="sponsor_update_currentPrice.ymv">
	<div class="col-md-11" style="border-style: solid;border-color: activecaption;height: 500px;">
		<div style="height: 80%">
			<c:forEach items="${requestScope.pvo}" varStatus="checkCount" var="picture">
			<c:if test="${checkCount.count==i.count}">
				<img src="${initParam.root }${picture.filePath}" style="width: 100%;">
			</c:if>
			</c:forEach>
			<h3>${sponsor.title}<br></h3>
			${sponsor.content}<br>
		</div>
		<div>
		 목표금액 ${sponsor.targetPrice}$ / 현재금액 ${sponsor.currentPrice}$
		</div>
		<div class="progress progress-striped active" >
			<div class="progress-bar " role="progressbar" aria-valuenow="${sponsor.currentPrice}" aria-valuemin="0" 
			aria-valuemax="${sponsor.targetPrice}" style="width: ${sponsor.percentage}%;text-align:left"> 
			${sponsor.percentage}%	
			</div>
		</div>
		<div>
		<select id="currentPrice" name="currentPrice">
							<option value="">-금액-</option>
							<option value="25">25$</option>
							<option value="50">50$</option>
							<option value="75">75$</option>
							<option value="100">100$</option>
							<option value="125">125$</option>
							<option value="150">150$</option>
							<option value="175">175$</option>
							<option value="200">200$</option>							
		</select>
		<input type="submit" id="sponsorBtn" value="후원하기">
		</div>
	</div>
	<input type="hidden" name="boardNo" value="${sponsor.boardNo}">
	</form>
</div>
</c:forEach>
<div class="col-md-12">
<div class = "text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="sponsor_board.ymv?pageNo=${requestScope.lvo.pagingBean.
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
						<li><a href="sponsor_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="sponsor_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="sponsor_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		</div>
	</div>
