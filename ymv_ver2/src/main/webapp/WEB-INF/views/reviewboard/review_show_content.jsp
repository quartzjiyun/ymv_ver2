<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				location.href = "review_board_delete.ymv?boardNo=" + ${requestScope.rvo.boardNo};
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
				<td>NO : ${requestScope.rvo.boardNo }</td>
				<td colspan="2">${requestScope.rvo.title}</td>
			</tr>
			<tr>
				<td>기업명 : ${requestScope.rvo.writer }</td>
				<td>시간: ${requestScope.rvo.timePosted}</td>
				<td>조회수 : ${requestScope.rvo.hit }</td>
			</tr>
			<tr>
				<td colspan="15">
				
					<c:if test="${requestScope.pvo!=null }">
						<img src="${initParam.root }${requestScope.pvo.filePath}">
					</c:if>
				
				<pre>${requestScope.rvo.content}</pre></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="3"><a
					href="${initParam.root}review_board.ymv"> <img class="action"
						src="${initParam.root}img/list_btn.jpg" onclick="sendList()"></a>
						<c:choose>
						<c:when test="${sessionScope.mvo.memberNo==requestScope.rvo.memberNo }">
						<a	href="${initParam.root}review_board_update_view.ymv?boardNo=${requestScope.rvo.boardNo }">
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
					<td><a
						href="delete_review_comment.ymv?commentNo=${comment.commentNo}&boardNo=${comment.boardNo}">댓글삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">
					<form name="commentForm" action="register_review_comment.ymv"
						method="post">
						작성자<input type="text" name="writer"> 내용<input type="text"
							name="content"> <input type="hidden" name="boardNo"
							value="${requestScope.rvo.boardNo}"> <input type="submit"
							value="댓글달기">
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
