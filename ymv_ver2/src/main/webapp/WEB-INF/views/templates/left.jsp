<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	$(document).ready(function(){
		$("#loginForm").submit(function(){
			if($(":input[name=id]").val()==""){
				alert("아이디를 입력하세요!");
				return false;
			}
			if($(":input[name=password]").val()==""){
				alert("패스워드를 입력하세요!");
				return false;
			}
		});
		$("#profile").click(function(){
			$("#profileView").html("<form action='member_profileUpload.ymv' enctype='multipart/form-data' method='post'><br><input type='file' name='fileName' accept='.gif, .jpg, .png'><br><input type='submit' value='프로필사진등록'>");
		});
	});
</script>
<c:choose>
<c:when test="${requestScope.loginSession=='X'}">
					<script type="text/javascript">
						alert("아이디와 비밀번호가 일치하지 않습니다!");
					</script>
		<form  class="loginform cf"  method="post" action="login.ymv" id="loginForm" >
		아이디 <input type="text" name="id"><br> 
		패스워드 <input type="text" name="password"><br>
		<br>
		<input type="submit" value="로그인" >
		<br><br></form>
	<a href="${initParam.root}member_register_form.do">회원가입</a><br>
	</c:when>
	<c:when test="${sessionScope.mvo==null}">
		<form  class="loginform cf" method="post" action="login.ymv" id="loginForm" >
	ID
		<br><br>
	 <input type="text" name="id" placeholder="Username">
	<br><br>
	PASSWORD
	<br><br>
		 <input type="text" name="password" placeholder="Password">
	
		<input type="submit" value="로그인" >

		</form>
				<br><br>
	<a href="${initParam.root}member_register_form.ymv">회원가입</a><br>
	</c:when>	
	<c:otherwise>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<c:choose>
			<c:when test="${sessionScope.mvo.filePath!=null }">
				<img src="${initParam.root }${sessionScope.mvo.filePath}" id="profile" style="width:80%; height:50%;">
			</c:when>
			<c:otherwise>
				<img src="${initParam.root }/img/man.jpg" id="profile"><br><br>
			</c:otherwise>
		</c:choose>
		
		<br>${sessionScope.mvo.name}님<br>
	<a href="${initParam.root}logout.ymv">로그아웃</a>
	<div id="profileView"></div>
	</c:otherwise>
</c:choose>

</form>









