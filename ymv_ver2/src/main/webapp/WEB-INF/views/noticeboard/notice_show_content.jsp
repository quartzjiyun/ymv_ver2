<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${initParam.root}resources/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#deleteBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="notice_board_delete.ymv?boardNo="+${requestScope.rvo.boardNo};
			}else{
				return;
			}
		})
	})
</script>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table" border="1">
		
			<tr>
				<td>NO : ${requestScope.rvo.boardNo }</td>
				<td colspan="2">${requestScope.rvo.title}</td>
			</tr>
			<tr>
				<td>작성자 : ${requestScope.rvo.writer }</td>
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
					href="${initParam.root}notice_board.ymv"> <img class="action"
						src="${initParam.root}img/list_btn.jpg" onclick="sendList()"></a>
						<c:choose>
						<c:when test="${sessionScope.mvo.memberType=='admin' }">
					<a
					href="${initParam.root}notice_board_update_view.ymv?boardNo=${requestScope.rvo.boardNo }">
						<img class="action" onclick="openForm('update')"
						src="${initParam.root}img/modify_btn.jpg">
				</a> <img id="deleteBtn" src="${initParam.root}img/delete_btn.jpg">
				</c:when>
				</c:choose>
				</td>
		</table>
	</div>
</div>