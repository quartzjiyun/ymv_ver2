<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="col-md-12">
		<h2>봉사 등록</h2>
		<form action="notice_register.ymv">
			<table border="1">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"
						value="관리자<%-- ${requestScope.rvo.writer } --%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>상세정보</td>
					<td><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" value="글 등록">
		</form>
	</div>
</div>