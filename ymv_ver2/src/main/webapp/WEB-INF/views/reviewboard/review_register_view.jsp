<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>봉사 등록</h2>
<form action="review_register.ymv">
<table border="1" >
   <tr>
      <td>제목</td><td><input type="text" name="title"></td>
   </tr>
   <tr>
   		<td>
   작성자 
   		</td>
   		<td>
   		<input type="text" name="writer" value="임영학<%-- ${requestScope.rvo.writer } --%>" readonly="readonly">
   		</td>
   </tr>
   
   
   <%-- <tr>
      <td>분야</td>
      <td>
         <select id="field"><!-- 분야(노인, 아동, 장애, 동물, 환경) DB에서 받아오기 -->
            <option value="">-분야-</option>
            <c:forEach items="${requestScope.fieldlist }" var="field">
               <option value="${field.field }">${field.field }</option>
            </c:forEach>
         </select>
      </td>
   </tr>
 <tr>
      <td>지역</td>
      <td>
         <select id="location" name="location"> <!-- 지역(*도 별로) DB에서 받아오기 -->
            <option value="">-지역-</option>
            <c:forEach items="${requestScope.locationlist }" var="location">
               <option value="${location.location }">${location.location }</option>
            </c:forEach>
         </select>
      </td>
   </tr>
   <tr>
      <td>나이</td><td><input type="text" name="age" id="age"></td>
      <!-- 숫자로 입력 안하면 submit 못하게 -->
      <!-- 나이를 select or input text로 둘중에 뭐할지 정하기 -->
   </tr> --%>
   <!-- <tr>
      <td>시작시간</td>
      <td>
         <select id="startTime" name="startTime">한시간 단위로 하기
            <option value="">-시작시간-</option>
            <option value="06:00">06:00</option>
            <option value="07:00">07:00</option>
            <option value="08:00">08:00</option>
            <option value="09:00">09:00</option>
            <option value="10:00">10:00</option>
            <option value="11:00">11:00</option>
            <option value="12:00">12:00</option>
            <option value="13:00">13:00</option>
            <option value="14:00">14:00</option>
            <option value="15:00">15:00</option>
            <option value="16:00">16:00</option>
            <option value="17:00">17:00</option>
            <option value="18:00">18:00</option>
            <option value="19:00">19:00</option>
            <option value="20:00">20:00</option>
            <option value="21:00">21:00</option>
            <option value="22:00">22:00</option>
            <option value="23:00">23:00</option>
            <option value="24:00">24:00</option>
         </select>
      </td>
   </tr>
   <tr>
      <td>끝시간</td>
      <td>
         <select id="endTime" name="endTime">한시간 단위로 하기
            <option value="">-끝시간-</option>
            <option value="06:00">06:00</option>
            <option value="07:00">07:00</option>
            <option value="08:00">08:00</option>
            <option value="09:00">09:00</option>
            <option value="10:00">10:00</option>
            <option value="11:00">11:00</option>
            <option value="12:00">12:00</option>
            <option value="13:00">13:00</option>
            <option value="14:00">14:00</option>
            <option value="15:00">15:00</option>
            <option value="16:00">16:00</option>
            <option value="17:00">17:00</option>
            <option value="18:00">18:00</option>
            <option value="19:00">19:00</option>
            <option value="20:00">20:00</option>
            <option value="21:00">21:00</option>
            <option value="22:00">22:00</option>
            <option value="23:00">23:00</option>
            <option value="24:00">24:00</option>
         </select>
      </td>
   </tr> -->
   <tr>
      <td>상세정보</td><td><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
   </tr>
</table>
<br>
 <input type="submit" value="글 등록" > 
</form>