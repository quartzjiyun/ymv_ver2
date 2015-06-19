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
			$("#profileView").html("<form action='member_profileUpload.ymv' enctype='multipart/form-data' method='post'><input type='file' class = 'btn btn-default btn-xs' name='fileName' accept='.gif, .jpg, .png'><input type='submit' class = 'btn btn-default btn-xs' value='프로필사진등록' style='position: relative;margin-left: 5%;'>");
		});
	});
</script>

<c:choose>
<c:when test="${sessionScope.mvo==null}">
<form id = "loginForm" class="form-horizontal" style="position: relative;left: 5%; " action="login.ymv">
  <fieldset>
    <div class="form-group">
      <label for="inputId" class="col-lg-2 control-label">ID</label><br><br>
      <div class="col-lg-10">
        <input type="text" class="form-control" name = "id" id="id" placeholder="ID입력">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Password</label><br><br>
      <div class="col-lg-10">
        <input type="password" class="form-control" name = "password" id="password" placeholder="Password입력">
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button type="reset" class="btn btn-default btn-xs">Cancel</button>
        <button type="submit" class="btn btn-primary btn-xs">Submit</button>
      </div>
    </div>
  </fieldset>
</form>
</c:when>
<c:otherwise>	
			<br><br>
			<c:choose>
			<c:when test="${sessionScope.mvo.filePath!=null }">
				<img src="${initParam.root }${sessionScope.mvo.filePath}" id="profile" style="width:80%; height:50%;">
			</c:when>
			<c:otherwise>
			 <img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png"
            class="center-block img-circle img-responsive" id="profile"><br><br>
			</c:otherwise>
		</c:choose>
		<div id="profileView"></div>
		<div class="panel panel-default" style="position: relative;margin-left: 5%;">
  <div class="panel-body">
 
<div class="col-xs-12 text-center">
<h5 class="glyphicon glyphicon-ok"> ${sessionScope.mvo.name}님</h5><br>
                </div>
  
  
  <div class="btn-group-vertical btn-block">
		<c:choose>
		<c:when test="${sessionScope.mvo.memberType=='company' }">
		<a href="#" class="btn btn-default btn-xs glyphicon glyphicon-briefcase" > 기업회원</a><br>
		</c:when>
		<c:when test="${sessionScope.mvo.memberType=='normal' }">
		<a href="#" class="btn btn-default btn-xs glyphicon glyphicon-heart " > 일반회원</a><br>
		</c:when>
		<c:when test="${sessionScope.mvo.memberType=='admin' }">
		<a href="#" class="btn btn-default btn-xs glyphicon glyphicon-lock" > 관리자</a><br>
		</c:when>
		</c:choose>
		<a href="${initParam.root }member_update_form.ymv" class="btn btn-default btn-xs glyphicon glyphicon-edit " > 정보수정</a><br>
		<a href="${initParam.root }logout.ymv" class="btn btn-default btn-xs glyphicon glyphicon-log-out"> 로그아웃</a>
		<br><a href="#modal" data-toggle="modal"><img src="${initParam.root}img/scheduler.jpg" class="img-responsive"></a>
  </div>
  </div>
</div>
	</c:otherwise>

</c:choose>
<c:choose>
<c:when test="${sessionScope.mvo==null }">
<c:choose>
<c:when test="${requestScope.loginSession=='X'}">
					<script type="text/javascript">
						alert("아이디와 비밀번호가 일치하지 않습니다!");
					</script>
					</c:when></c:choose>
<a href="${initParam.root}member_register_form.ymv" class="btn btn-primary btn-xs" style="position: relative;margin-left: 75%;">회원가입</a><br>
</c:when>
</c:choose>

 <br>
 
 <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
        <p>테이블 넣을곳</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/roundicons.png" class="img-responsive" alt="">
                    </a> -->













<%-- 
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
		패스워드 <input type="password" name="password"><br>
		<br>
		<input type="submit" value="로그인" >
		<br><br></form>
	<a href="${initParam.root}member_register_form.ymv">회원가입</a><br>
	</c:when>
	<c:when test="${sessionScope.mvo==null}">
		<form  class="loginform cf" method="post" action="login.ymv" id="loginForm" >
	ID
		<br><br>
	 <input type="text" name="id" placeholder="Username">
	<br><br>
	PASSWORD
	<br><br>
		 <input type="password" name="password" placeholder="Password">
	
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
			<a href="${initParam.root}member_update_form.ymv">회원정보수정</a><br>
	<a href="${initParam.root}logout.ymv">로그아웃</a>
	<div id="profileView"></div>
	</c:otherwise>
</c:choose>

</form>



 --%>





