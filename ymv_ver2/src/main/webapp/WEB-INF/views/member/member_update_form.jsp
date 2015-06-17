<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$("#updateForm").submit(function(){
			if($(":input[name=password]").val()==""){
				alert("비밀번호를 입력하세요!");
				return false;
			}
			if($(":input[name=name]").val()==""){
				alert("이름을 입력하세요!");
				return false;
			}else if($(":input[name=address]").val()==""){
				alert("주소를 입력하세요!");
				return false;
			}else if($(":input[name=mailAddress]").val()==""){
				alert("이메일주소를 입력하세요!");
				return false;
			}
		});
	});
</script>
<h3>회원정보수정</h3>
<body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="member_update.ymv" id="updateForm">
              <div class="form-group">
                <div class="col-sm-2">
   <label for="inputEmail3" class="control-label">아이디</label>
                  </div>
                <div class="col-sm-5">
                 <input type="hidden" name="memberNo" value="${sessionScope.mvo.memberNo}">
                    <input type="text" class="form-control"  name="id"
                    id="inputEmail3" value="${sessionScope.mvo.id}" readonly>
                            </div>
              </div>
           <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">비밀번호</label>
                </div>
                <div class="col-sm-5">
                  <input type="password" class="form-control"  id="inputPassword3" name="password" placeholder="Password">
                </div>
              </div>
     <div class="form-group">
                <div class="col-sm-2">
   <label for="inputName3" class="control-label">이름</label>
                  </div>
                <div class="col-sm-5">
                    <input type="text" class="form-control"  
                    id="inputName3" name="name" value="${sessionScope.mvo.name}">
                            </div>
              </div>
      <div class="form-group">
                <div class="col-sm-2">
   <label for="inputAddress3" class="control-label">주소</label>
                  </div>
                <div class="col-sm-5">
                    <input type="text" class="form-control"  
                    id="inputAddress3" name="address" value="${sessionScope.mvo.address}">
                            </div>
              </div>
      <div class="form-group">
                <div class="col-sm-2">
   <label for="inputmailAddress3" class="control-label">이메일 주소</label>
                  </div>
                <div class="col-sm-5">
                    <input type="text" class="form-control"  
                    id="inputmailAddress3" name="mailAddress" value="${sessionScope.mvo.mailAddress}">
                            </div>
              </div>      
      <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">수정하기</button>
         </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>              