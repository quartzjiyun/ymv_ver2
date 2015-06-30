<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <script type="text/javascript">
   $(document).ready(function(){
      $("#qnaForm").submit(function(){
         if($("#title").val()==""){
            alert("제목을 입력해주세요");
            return false;
         }else if($("#field").val()==""){
            alert("내용을 선택해 주세요");
            return false;
         }else if($("#location").val()==""){
            alert("지역을 선택해 주세요");
            return false;
         }else{
         if(!confirm("글을 수정하시겠습니까?")){
                 return false;
          }
         }
      });
      $("#updateCancel").click(function(){
			if(confirm("취소하시겠습니까?")==true){
				location.href="qna_board.ymv";
			}else{
				return;
			}
		});
      
      
   });

</script>
<div class="col-md-8 col-md-offset-2">
<form id="qnaForm" action="qna_board_update.ymv" method="post" class="form-horizontal">
         <table class="table table-hover">
            <tr>
               <td>
               <b>글번호: <input type=text name=qnaNo value=${requestScope.qvo.qnaNo } readonly></input>
               | 타이틀:<input type=text name=title value=${requestScope.qvo.title }></input></b>
               </td></tr><tr>
                <td>
            <tr>
               <td>                  
   <textarea rows="15" cols="75" name="content">${requestScope.qvo.content }</textarea>
               </td>
            </tr>
            <tr>
            <td valign="middle" align="right">                  
               <input type="submit" value="수정하기" class="btn btn-default btn-xs"></input>   
               <input type="button" id="updateCancel" value="취소하기" class="btn btn-default btn-xs"></input>
               </td>                       
            </tr>
         </table>
   
</form>   
</div>