<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${initParam.root}resources/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateCancel").click(function(){
			if(confirm("취소하시겠습니까?")==true){
				location.href="notice_board.ymv";
			}else{
				return;
			}
		});
	});
</script>

<div class="col-sm-6 col-sm-offset-3">
		<form class="form-horizontal" method="post" action="notice_board_update.ymv">
		<table class="table table-hover">
			<tr>
				<td><b> 글번호 : <input type=text name=boardNo
						value=${requestScope.rvo.boardNo } readonly="readonly"></b></td>
				<td><b>작성자 : <input type=text name=writer
						value=${requestScope.rvo.writer } readonly="readonly"></b></td>
			</tr>
			<tr>
				<td colspan="2">제목 : <input type=text name=title
					value=${requestScope.rvo.title }></input>
				</td>
			</tr>
			<tr>
				<td colspan="2">등록시간 : ${requestScope.rvo.timePosted } 조회수 :
					${requestScope.rvo.hit }</td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="15" cols="75" name="content">${requestScope.rvo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input
					class="btn btn-default btn-xs" type="submit" value="수정하기"></input>
					<input class="btn btn-default btn-xs" type="button"
					id="updateCancel" value="취소하기"></input></td>
			</tr>
		</table>
	</form>
	</div>












