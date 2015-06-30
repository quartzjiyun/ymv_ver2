<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
   $(document).ready(function(){
      $("#recruitForm").submit(function(){
         if($("#title").val()==""){
            alert("제목을 입력해주세요");
            return false;
         }else if($("#field").val()==""){
            alert("분야를 선택해 주세요");
            return false;
         }else if($("#location").val()==""){
            alert("지역을 선택해 주세요");
            return false;
         }else if($("#age").val()==""){
            alert("봉사 가능 나이를 입력해 주세요");
            return false;
         }else if($("#startTime").val()==""){
            alert("시작시간을 입력해 주세요");
            return false;
         }else if($("#endTime").val()==""){
            alert("끝시간을 입력해 주세요");
            return false;
         }else if($("#content").val()==""){
            alert("상세정보를 입력해 주세요");
            return false;
         }
      });
   });
</script>
<div class="col-md-12">
	<div class="col-md-12">
		<form id="recruitForm" action="voluntary_board_update.ymv"
			method="post">
			<input type="hidden" name="command" value="${requestScope.command }">
			<table class="content">
				<tbody>
					<tr>
						<td><b>글번호: <input type=text name=recruitNo
								value=${requestScope.rvo.recruitNo } readonly></input> | 타이틀:<input
								type=text name=title value=${requestScope.rvo.title }></input></b></td>
					</tr>
					<tr>
						<td><font size="2">분야 : <select id="field"
								name="field">
									<!-- 분야(노인, 아동, 장애, 동물, 환경) DB에서 받아오기 -->
									<option value="${requestScope.rvo.field }">${requestScope.rvo.field }</option>
									<c:forEach items="${requestScope.fieldlist }" var="field">
										<option value="${field.field }">${field.field }</option>
									</c:forEach>
							</select> | 지역 : <select id="location" name="location">
									<!-- 지역(*도 별로) DB에서 받아오기 -->
									<option value="${requestScope.rvo.location }">${requestScope.rvo.location }</option>
									<c:forEach items="${requestScope.locationlist }" var="location">
										<option value="${location.location }">${location.location }</option>
									</c:forEach>
							</select> | 나이 제한 : <input type=text name=age
								value=${requestScope.rvo.age }></input>
						</font></td>
					</tr>
					<tr>
						<td><font size="2">시작시간: <select id="startDate"
								name="startDate">
									<!-- 한시간 단위로 하기 -->
									<option value="${requestScope.rvo.startDate }">${requestScope.rvo.startDate }</option>
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
									<option value="00:00">00:00</option>
							</select> | 끝시간: <select id="endDate" name="endDate">
									<!-- 한시간 단위로 하기 -->
									<option value="${requestScope.rvo.endDate }">${requestScope.rvo.endDate }</option>
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
									<option value="00:00">00:00</option>
							</select>
						</font></td>
					</tr>
					<tr>
						<td><textarea rows="15" cols="75" name="content">${requestScope.rvo.content }</textarea>
						</td>
					</tr>
					<tr>
						<td valign="middle"><input type="submit" value="수정하기"></input>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>