<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
	$(document).ready(function(){
		$("#qnaForm").submit(function(){
			if($("#title").val()==""){
				alert("제목을 입력해주세요");
				return false;
			}else if($("#content").val()==""){
				alert("상세정보를 입력해 주세요");
				return false;
			}
		});
	});
</script>

<h2>Q & A 등록</h2>
<form id="qnaForm" action="qna_register.ymv" method="post">
<table border="1">
	<tr>
		<td colspan="1">제목</td><td colspan="1"><input type="text" name="title" id="title"></td>
		<td>작성자:${sessionScope.mvo.name}</td>
	</tr>
	<tr>
		<td>상세정보</td><td><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
	</tr>
</table>
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="submit" value="글 등록" > 
</form>