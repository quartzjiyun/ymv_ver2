<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${initParam.root}resources/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateCancel").click(function(){
			if(confirm("취소하시겠습니까?")==true){
				location.href="review_board.ymv";
			}else{
				return;
			}
		});
	});
</script>


<form method=post action="review_board_update.ymv">


			<table class="content">
				<tr>
					<td>
						<b>
							글번호 <input type=text name=boardNo value=${requestScope.rvo.boardNo } readonly="readonly"></input>
							| 작성자 <input type=text name=writer value=${requestScope.rvo.writer } readonly="readonly"></input>
						</b>
					</td>
				</tr>
					
				<tr>	
					<td>
						제목 <input type=text name=title value=${requestScope.rvo.title }></input>
					</td>
				</tr>
				<tr>
					<td>
				
						<font size="3">등록시간 : ${requestScope.rvo.timePosted } 조회수 : ${requestScope.rvo.hit }
											
						</font>
					</td>
				</tr>
				<tr>
					<td>						
	<textarea rows="15" cols="75" name="content">${requestScope.rvo.content }</textarea>
					</td>
				</tr>
				<tr>
					<td valign="middle">						
					<input type="submit" value="수정하기"></input>	
					<input type="button" id="updateCancel" value="취소하기"></input>
					</td>				
				</tr>
			</table>
	
</form>	














