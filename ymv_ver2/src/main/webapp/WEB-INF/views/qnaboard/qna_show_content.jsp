<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script type="text/javascript">
    function checkDelete(){
       if(!confirm("글을 삭제하시겠습니까?")){
          return false;
       }else{
          location.href="qna_delete.ymv?qnaNo=${requestScope.qvo.qnaNo}";
       }
    }

</script>
   <table class="content">
      <tr>
         <td width="150">NO : ${requestScope.qvo.qnaNo } </td>
         <td width="180">작성일:${requestScope.qvo.timePosted}</td>
         <td>조회수 : ${requestScope.qvo.hit }</td>
      </tr>
      <tr>
               <td colspan="2" >${requestScope.qvo.title} </td>
                <td>작성자 : ${sessionScope.mvo.name }</td>
      </tr>

      <tr>

         <td colspan="15">
         <pre>${requestScope.qvo.content}</pre>
         </td>
      </tr>
      <tr>
      <td valign="middle" align="center" colspan="3">
      <a href = "${initParam.root}qna_board.ymv"> <img class="action" src="${initParam.root}img/list_btn.jpg" ></a>
      <a href="qna_reply_view.ymv?qnaNo=${requestScope.qvo.qnaNo}">
		<img src="${initParam.root}/img/answer_btn.jpg" ></a>
      <c:choose>
      <c:when test="${sessionScope.mvo.memberNo==requestScope.qvo.memberNo}">
         
<a href = "${initParam.root}qna_board_update_view.ymv?qnaNo=${requestScope.qvo.qnaNo}"> 
 <img class="action"  onclick="openForm('update')"  src="${initParam.root}img/modify_btn.jpg" ></a>
 <img class="action"  onclick="checkDelete()"    src="${initParam.root}img/delete_btn.jpg" > 
      </c:when>
      </c:choose>
      </td>
            </tr>
         </table>