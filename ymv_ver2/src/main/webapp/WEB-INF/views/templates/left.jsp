<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
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
	});
</script>
<%-- <a href="${initParam.root}member_find.do">회원검색</a> --%>
<%-- 로그아웃 상태이면 로그인 링크 제공
        로그인 상태이면 로그아웃 링크 제공 
        로그인과 로그아웃을 구현해본다. 
 --%>
 <br>	
<c:choose>
<c:when test="${requestScope.info=='X'}">
					<script type="text/javascript">
						alert("아이디와 비밀번호가 일치하지 않습니다!");
					</script>
<!-- 		<br><br><br><br>	<br><br><br><br> -->
		<form  class="loginform cf"  method="post" action="login.ymv" id="loginForm" >
		아이디 <input type="text" name="id"><br> 
		패스워드 <input type="text" name="password"><br>
		<br>
		<input type="submit" value="로그인" >
		<br><br></form>
	<a href="${initParam.root}member_register_form.do">회원가입</a><br>
	</c:when>
	<c:when test="${sessionScope.mvo==null}">
<%-- 	<a href="${initParam.root}member_login_form.do">로그인</a><br> --%>
<!-- 	<br><br><br><br>	<br><br><br><br> -->
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
	<a href="${initParam.root}member_register_form.do">회원가입</a><br>
	</c:when>	
	<c:otherwise>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<br><br><br><br>	<br><br><br><br>
			<img src="${initParam.root }/img/man.jpg"><br><br>
		<br>${sessionScope.mvo.name}님<br>
	<a href="${initParam.root}logout.ymv">로그아웃</a>
	</c:otherwise>
</c:choose>
<a href="${initParam.root}member_fileupload_form.do">파일업로드</a><br>










