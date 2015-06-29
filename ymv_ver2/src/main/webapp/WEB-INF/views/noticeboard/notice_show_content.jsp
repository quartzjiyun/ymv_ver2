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
	<div class="col-sm-8 col-sm-offset-2">
		<table class="table table-hover">
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
						<img src="${initParam.root }${requestScope.pvo.filePath}"><br>
					</c:if>
				<br><pre>${requestScope.rvo.content}</pre></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="3"><a
					href="${initParam.root}notice_board.ymv" class="btn btn-default btn-xs">목록</a>
						<c:choose>
						<c:when test="${sessionScope.mvo.memberType=='admin' }">
					<a
					href="${initParam.root}notice_board_update_view.ymv?boardNo=${requestScope.rvo.boardNo }" class="btn btn-default btn-xs">수정</a> <a
					href="#"><input type="button" class="btn btn-default btn-xs" id ="deleteBtn" value="삭제" ></a>
				</c:when>
				</c:choose>
				</td>
		</table>
	</div>
</div>