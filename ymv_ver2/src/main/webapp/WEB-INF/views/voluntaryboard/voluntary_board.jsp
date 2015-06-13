<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <table class="list">
      <caption>목록</caption>
      <thead>
      <tr>
         <th class="recruitNo">NO</th>
         <th class="title">제목</th>
         <th class="field">분야</th>
         <th class="location">지역</th>
         <th class="startDate">시작일</th>
         <th class="endDate">완료일</th>
         </tr>      
         <c:forEach var="bvo" items="${requestScope.lvo.list}">      
         <tr>
             <td>${bvo.recruitNo }</td>                  
            <%-- bvo에 relevel이 0이 아니면 답변글이므로 relevel만큼 공백으로 제목을 밀어준다  --%>
            <%-- <td class="titleView">
               <c:if test="${bvo.relevel!=0}">
               <c:forEach begin="0" end="${bvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
               <img src="${initParam.root }/img/reply.jpg">
               </c:if>
               <a href="${initParam.root}/board/showContent.do?no=${bvo.no }">${bvo.title}</a>
            </td>            
            <td>${bvo.writer }</td>
            <td>${bvo.writeDate }</td>
            <td>${bvo.viewCount }</td> --%>
            <td><a href="${initParam.root}voluntary_showContentRecruitVol.ymv?recruitNo=${bvo.recruitNo}">
            ${bvo.title }</a></td>
            <td>${bvo.field }</td>
            <td>${bvo.location }</td>
            <td>${bvo.startDate }</td>
            <td>${bvo.endDate }</td>
         </tr>         
         </c:forEach>
   </table><br>
   <a href="${initParam.root }voluntary_register_view.ymv">기업일 경우 글쓰기 버튼이 생김</a>
   <br></br>   
   <!-- 페이징 처리 -->      
   <br></br>   
   <!-- 페이징 처리 -->   
   <%-- 이전 페이지 그룹이 있으면 이미지 보여준다.
         이미지 링크는 현 페이지 그룹 시작페이지 번호 -1 =>
         이전 페이지 그룹의 마지막 페이지 번호로 한다. 
    --%>
    <c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
    <a href=
    "list.do?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}"><img src="${initParam.root }/img/left_arrow_btn.gif"></a>
    </c:if>
    &nbsp;&nbsp;
   <%-- PagingBean 을 이용해서 현재 페이지에 해당되는 페이지그룹의
         시작페이지~~마지막페이지까지 화면에 보여준다. 
         이 때 현재 페이지를 제외한 나머지 페이지는 링크를 걸어
         해당 페이지에 대한 게시물 리스트 조회가 가능하도록 한다. 
    --%>   
   <c:forEach var="i" 
   begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
    end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
    <c:choose>
    <c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
    <a href="list.do?pageNo=${i}">${i}</a>
    </c:when>
    <c:otherwise>
   ${i}
   </c:otherwise>
   </c:choose>
   </c:forEach>    
   &nbsp;&nbsp;
   <%-- 다음 페이지 그룹이 있으면 화살표 이미지를 보여준다.
         이미지 링크는 현재 페이지 그룹의 마지막 번호 + 1 => 
         다음 그룹의 시작 페이지로 링크한다. 
         right_arrow_btn.gif
    --%>
    <c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
    <a href=
    "list.do?pageNo=${requestScope.lvo.pagingBean.
    endPageOfPageGroup+1}">
    <img src="${initParam.root }/img/right_arrow_btn.gif">
    </a>
    </c:if>       











