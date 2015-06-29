<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-6 col-sm-offset-3">
<form action="sponsor_register.ymv" enctype="multipart/form-data" method="post">
	<table class="table table-striped table-hover">
				<tr>
					<th class="info"><h4 class="text-center">제목</h4></th>
					<td><input type="text" name="title" id="title"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">파일업로드</h4></th>
					<td><input type="file" name="fileName"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">상세정보</h4></th>
					<td><textarea rows="10" cols="50" id="content" name="content">${requestScope.spvo.content }</textarea></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">목표금액</h4></th>
					<td><input type="text" name="targetPrice"></td>
				</tr>
			</table>
<input type="submit" class ="btn btn-primary" value="등록">
</form>
</div>