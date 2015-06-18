<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Spring Expression Language (SpEL) 선언부 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var type ="";
	var companyBtn="<input type='text' id='identityNo'><input type='button' name='checkBtn' value='사업자번호 등록'>";
	var normalBtn ="<input type='text' id='identityNo'><input type='button' name='checkBtn' value='주민등록번호 등록'>";
	
	$("#company").click(function() {
		type="company";
		$("#inputType").html(companyBtn);		
		$("#memberPicture").html("<img src='${initParam.root }/img/company2.jpg' id='company'><img src='${initParam.root }/img/normal1.jpg' id='normal'>");
	});//company click
	$("#normal").click(function() {
		type="normal";
		$("#inputType").html(normalBtn);
		$("#memberPicture").html("<img src='${initParam.root }/img/company1.jpg' id='company'><img src='${initParam.root }/img/normal2.jpg' id='normal'>");
	}); // normal click
	$("#inputType").on("click",":button[name=checkBtn]",function(){ 
		if($("#identityNo").val()==""){
			alert("값을 입력해주세요");
			return ;
		}
		if(isNaN($("#identityNo").val())){
			alert("숫자입력해주세요");
			return ;
		}else{
		if(confirm("중복처리되었다고 칩시다")==false){
			$("#inputType").html("");
			return;
		}
		if(type=='company'){
			location.href = "${initParam.root}member_register.ymv?identityNo="+$("#identityNo").val()+"&memberType="+type;
			
		}
		location.href = "${initParam.root}member_register.ymv?identityNo="+$("#identityNo").val()+"&memberType="+type;
		}
		});
	
});//documentready
	$(document).on("click","#company", function(){
	$("#memberPicture").html("<img src='${initParam.root }/img/company2.jpg' id='company'><img src='${initParam.root }/img/normal1.jpg' id='normal'>");
	$("#inputType").html("<input type='text' id='identityNo'><input type='button' name='checkBtn' value='사업자번호 등록'>");
});
	$(document).on("click","#normal", function(){
		$("#memberPicture").html("<img src='${initParam.root }/img/company1.jpg' id='company'><img src='${initParam.root }/img/normal2.jpg' id='normal'>");
		$("#inputType").html("<input type='text' id='identityNo'><input type='button' name='checkBtn' value='주민등록번호 등록'>");
	});
</script>
<div class="section" style="position: relative; left: 20px;">
	<div class="container">
		<div class="row" id="memberPicture">
			<img src="${initParam.root }/img/company1.jpg" id="company"> <img
				src="${initParam.root }/img/normal1.jpg" id="normal">
		</div>
	</div>
</div>
<!-- 
    <input type = "button" id="company" value="기업회원">
    <input type = "button" id="normal" value="일반회원"> -->
<br>
<span id="inputType"></span>
<br>



