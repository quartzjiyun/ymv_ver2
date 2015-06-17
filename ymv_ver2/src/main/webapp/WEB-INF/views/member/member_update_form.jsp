<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateForm").submit(function(){
			if($(":input[name=password]").val()==""){
				alert("비밀번호를 입력하세요!");
				return false;
			}
			if($(":input[name=name]").val()==""){
				alert("패스워드를 입력하세요!");
				return false;
			}
			if($(":input[name=address]").val()==""){
				alert("패스워드를 입력하세요!");
				return false;
			}
			if($(":input[name=mailAddress]").val()==""){
				alert("패스워드를 입력하세요!");
				return false;
			}
		});
	});
</script>
<h3>회원정보수정</h3>
<form action="member_update.ymv" id="updateForm">
<input type="hidden" name="memberNo" value="${sessionScope.mvo.memberNo}">
아이디: <input type="text" name="id" value="${sessionScope.mvo.id}" readonly><br>
비밀번호 :<input type="password" name="password"><br>
이름 :<input type="text" name="name" value="${sessionScope.mvo.name}" ><br>
주소 : <input type="text" name="address" value="${sessionScope.mvo.address}"><br>
이메일 : <input type="text" name="mailAddress" value="${sessionScope.mvo.mailAddress}"><br>
<br><br> 
<input type="submit" value="수정">
</form>
<!--  value="${sessionScope.mvo.password}" -->