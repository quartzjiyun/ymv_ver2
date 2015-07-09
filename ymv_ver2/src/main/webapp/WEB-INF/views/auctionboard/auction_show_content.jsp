03
.<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				location.href = "auction_board_delete.ymv?boardNo=" + ${requestScope.avo.boardNo};
			} else {
				return;
			}//if
		})//click
		
	})
</script>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<tr>
				<td>NO : ${requestScope.avo.boardNo }</td>
				<td colspan="2">${requestScope.avo.title}</td>
			</tr>
			<tr>
				<td>물품명 : ${requestScope.avo.writer }</td>
				<td>경매시간: ${requestScope.avo.timePosted}</td>
				<td>조회수 : ${requestScope.avo.hit }</td>
			</tr>
			<tr>
				<td colspan="15">
				
					<c:if test="${requestScope.pvo!=null }">
						<img src="${initParam.root }${requestScope.pvo.filePath}">
					</c:if>
				
				<pre>${requestScope.avo.content}</pre></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="3"><a
					href="${initParam.root}auction_board.ymv"> <img class="action"
						src="${initParam.root}img/list_btn.jpg" onclick="sendList()"></a>
						<c:choose>
						<c:when test="${sessionScope.mvo.memberNo==requestScope.avo.memberNo }">
						<a	href="${initParam.root}auction_board_update_view.ymv?boardNo=${requestScope.avo.boardNo }">
						<img class="action" onclick="openForm('update')"
						src="${initParam.root}img/modify_btn.jpg">
				</a> <img id="deleteBtn" src="${initParam.root}img/delete_btn.jpg">
				
				</c:when>
				<c:when test="${sessionScope.mvo.memberType=='admin' }">
						<a	href="${initParam.root}auction_board_update_view.ymv?boardNo=${requestScope.avo.boardNo }">
						<img class="action" onclick="openForm('update')"
						src="${initParam.root}img/modify_btn.jpg">
				</a> <img id="deleteBtn" src="${initParam.root}img/delete_btn.jpg">
				
				</c:when>
				</c:choose>
				</td>
			</tr>
			<c:forEach items="${requestScope.commentList}" var="comment">
				<tr>
					<td>${comment.commentNo}</td>
					<td>${comment.writer}</td>
					<td>${comment.timePosted}</td>
				</tr>
				<tr>
					<td colspan="2">
					${comment.content}</td>
					<td>
					<c:choose>
					<c:when test="${sessionScope.mvo.memberType=='admin' }">
					<a
						href="delete_auction_comment.ymv?commentNo=${comment.commentNo}&boardNo=${comment.boardNo}">댓글삭제</a>
					</c:when>
					<c:when test="${comment.writer==sessionScope.mvo.id }">
					<a
						href="delete_auction_comment.ymv?commentNo=${comment.commentNo}&boardNo=${comment.boardNo}">댓글삭제</a>
										
					</c:when>
					<c:otherwise>
					</c:otherwise>
						</c:choose>
					
						
						</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">
					<form name="commentForm" action="register_auction_comment.ymv"
						method="post">
						작성자:<input type="text" name="writer" value = "${sessionScope.mvo.id }" readonly="readonly"> 내용<input type="text"
							name="content"> <input type="hidden" name="boardNo"
							value="${requestScope.avo.boardNo}"> <input type="submit"
							value="댓글달기">
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
