<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script type="text/javascript">
    function checkDelete(){
       if(!confirm("글을 삭제하시겠습니까?")){
          return false;
       }else{
          location.href="voluntary_delete.ymv?recruitNo=${requestScope.rvo.recruitNo}";
       }
    }
</script>
   <table class="content">
      <tr>
         <td >NO : ${requestScope.rvo.recruitNo } </td>
         <td colspan="2" >${requestScope.rvo.title} </td>
      </tr>
      <tr>
         <td>기업명 :  <%-- ${sessionScope.result.name } --%></td>
         <td> 시간:<%-- ${requestScope.rvo.time} --%></td>
         <td>조회수 :<%--  ${requestScope.rvo.hits } --%></td>
      </tr>
      <tr>
         <td>분야: ${requestScope.rvo.field} </td>
         <td>나이제한 : ${requestScope.rvo.age}</td>
         <td>지역 : ${requestScope.rvo.location}</td>
      </tr>   
      <tr>
         <td>시작시간: ${requestScope.rvo.startDate} </td>
         <td>&nbsp&nbsp&nbsp&nbsp~</td>
         <td>종료시간: ${requestScope.rvo.endDate}</td>
      </tr>   

      <tr>
         <td colspan="15">
         <pre>${requestScope.rvo.content}</pre>
         </td>
      </tr>
      <tr>
      <td valign="middle" align="center" colspan="3">
      <a href = "${initParam.root}voluntary_board.ymv"> <img class="action" src="${initParam.root}img/list_btn.jpg" onclick="sendList()" ></a>
      <c:choose>
      <c:when test="${sessionScope.result.id==requestScope.bvo.id}">
         
<a href = "${initParam.root}voluntary_board_update_view.ymv?recruitNo=${requestScope.rvo.recruitNo }"> 
 <img class="action"  onclick="openForm('update')"  src="${initParam.root}img/modify_btn.jpg" ></a>
     
       
            <img class="action"  onclick="checkDelete()"    src="${initParam.root}img/delete_btn.jpg" > 
      </c:when>
      </c:choose>
      </td>
            </tr>
         </table>