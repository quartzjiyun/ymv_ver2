<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="content" border="1">
	<tr>
		<td>NO : ${requestScope.rvo.boardNo }</td>
		<td colspan="2">${requestScope.rvo.title}</td>
	</tr>
	<tr>
		<td>기업명 : ${requestScope.rvo.writer }</td>
		<td>시간: ${requestScope.rvo.timePosted}</td>
		<td>조회수 : ${requestScope.rvo.hit }</td>
	</tr>
	<%--       <tr>
         <td>분야: ${requestScope.rvo.field} </td>
         <td>나이 : ${requestScope.rvo.age}</td>
         <td>지역 : ${requestScope.rvo.location}</td>
      </tr>    --%>
	<%--       <tr>
         <td>시작시간: ${requestScope.rvo.startDate} </td>
         <td>&nbsp&nbsp&nbsp&nbsp~</td>
         <td>종료시간: ${requestScope.rvo.endDate}</td>
      </tr>    --%>

	<tr>
		<td colspan="15"><pre>${requestScope.rvo.content}</pre></td>
	</tr>
	<tr>
		<td valign="middle" align="center" colspan="3"><a
			href="${initParam.root}review_board.ymv"> <img class="action"
				src="${initParam.root}img/list_btn.jpg" onclick="sendList()"></a>
			<c:choose>
				<c:when test="${sessionScope.result.id==requestScope.bvo.id}">
					<a
						href="${initParam.root}voluntary_board_update_view.ymv?boardNo=${requestScope.rvo.boardNo }">
						<img class="action" onclick="openForm('update')"
						src="${initParam.root}img/modify_btn.jpg">
					</a>
					<img class="action" onclick="openForm('delete')"
						src="${initParam.root}img/delete_btn.jpg">
				</c:when>
			</c:choose></td>
	</tr>
	<c:forEach items="${requestScope.commentList}" var="comment">
		<tr>
			<td>${comment.commentNo}</td>
			<td>${comment.writer}</td>
			<td>${comment.timePosted}</td>
		</tr>
		<tr>
			<td colspan="2">${comment.content}</td>
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
