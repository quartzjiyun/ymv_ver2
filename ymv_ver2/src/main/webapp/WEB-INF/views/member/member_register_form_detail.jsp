<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%-- Spring Expression Language (SpEL) 선언부 --%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
   <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
    rel="stylesheet" type="text/css">
   <script type="text/javascript">
   $(document).ready(function(){
   $("#id").keyup(function(){
		var id=$("#id").val().trim();
		$.ajax({
			type:"POST",
			url:"${initParam.root}member_register_idcheck.ymv",
			dataType:"json",  
			data:"identityNo=${requestScope.memberVO.identityNo }&memberType=${requestScope.memberVO.memberType }&id="+$("#id").val(),
			success:function(flag){		
				$("#idCheck").show();
				if($("#id").val()==""){
					   $("#idCheck").hide();
				}
				if(!flag){
					//$("#idCheck").show();
					$("#idCheck").html(" 아이디 중복!").css("font","red");
				}else{			
					if(id.length<4 || id.length>10){
						$("#idCheck").html(" 4자이상 10자 미만으로 입력해주세요!");
					}else{
						$("#idCheck").html(" 사용가능!");
					}
				}					
			}//callback			
		});//ajax
	}); //keyup
   });
   </script>
   <h3>회원가입</h3>
   <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form:form method = "post" action="${initParam.root}member_register_validation.ymv?identityNo=${requestScope.memberVO.identityNo }&memberType=${requestScope.memberVO.memberType }"
             commandName="memberVO"	class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">아이디</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="id" path="id" id="id"/>
          		   <span id = "idCheck"></span>
 <font color="red"><form:errors path="id"></form:errors></font>
                </div>
              </div>
  <!-- 패스워드 -->
            <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">비밀번호</label>
                </div>
                <div class="col-sm-5">
                  <form:password class="form-control" placeholder="password" path="password" id="password"/>
         <font color="red"><form:errors path="password"></form:errors></font>
                </div>
              </div>
    <!-- 이름 -->
      <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">이름</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="name" path="name" id="name"/>
					<font color="red"><form:errors path="name"></form:errors></font>
                </div>
              </div>
	<!-- 주소 -->
      <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">주소</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="name" path="address" id="address"/>
			 <font color="red"><form:errors path="address"></form:errors></font>
                </div>
              </div>
  <!-- 이메일 -->
 	     <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">이메일</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="mailAddress" path="mailAddress" id="mailAddress"/>
	 <font color="red"><form:errors path="mailAddress"></form:errors></font>
                </div>
              </div>
 	 <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">회원가입</button>
                </div>
              </div>
</form:form>
          </div>
        </div>
      </div>
    </div>
  </body>
  
   
   
   
   
   
   
  <%-- 
회원가입 <br><br>
<form:form method = "post" action="${initParam.root}member_register_validation.ymv?identityNo=${requestScope.memberVO.identityNo }&memberType=${requestScope.memberVO.memberType }" commandName="memberVO">
 아이디 :   <form:input path="id" id="id"/><span id = "idCheck"></span>
 <font color="red"><form:errors path="id"></form:errors></font>
 	<br>	
 패스워드 : <form:password path="password" id="password"/>	
 			 <font color="red"><form:errors path="password"></form:errors></font>
 <br>    
 이름 : <form:input path="name" id="name"/>
 <font color="red"><form:errors path="name"></form:errors></font>
 	<br>	
  주소 : <form:input path="address" id="address"/>
 <font color="red"><form:errors path="address"></form:errors></font>
 	<br>		
 이메일 : <form:input path="mailAddress" id="mailAddress"/>
 <font color="red"><form:errors path="mailAddress"></form:errors></font>
 	<br>	
 <input type="submit" value="회원가입">
 </form:form> --%>