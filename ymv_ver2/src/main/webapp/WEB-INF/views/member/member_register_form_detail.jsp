<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%-- Spring Expression Language (SpEL) 선언부 --%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
 </form:form>