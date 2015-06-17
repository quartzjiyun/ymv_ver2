<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원정보수정완료</h3>
${requestScope.mvo.name} 정보수정완료<br><br>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<%--table 시작할때 colgroup으로 사이즈 조절  하단에서는 scope로 col 찍으면됨--%>
			<colgroup>
				<col style="width: 30%;" />
				<col style="width: 70%;" />
			</colgroup>
	<tr>
		<td>아이디</td><td> ${requestScope.mvo.id}</td>
	</tr>
		<tr>
		<td>비밀번호</td><td> ${requestScope.mvo.password}</td>
	</tr>	
	<tr>
		<td>이름</td><td> ${requestScope.mvo.name}</td>
	</tr>
	<tr>
		<td>주소</td><td>${requestScope.mvo.address}</td>
	</tr>
	<tr>
		<td>이메일주소</td><td>${requestScope.mvo.mailAddress}</td>
	</tr>
</table>
</div></div>
<hr>
<a href="testTiles.ymv">홈으로</a>