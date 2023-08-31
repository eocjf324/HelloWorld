<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<div>
			<table border="1">
				<tr>
					<th width="100">작성자</th>
					<td align="center">${n.noticeWriter}</td>
					<th width="100">작성일자</th>
					<td align="center">${n.noticeDate}</td>
					<th width="100">조회수</th>
					<td align="center">${n.noticeHit}</td>
				</tr>
				<tr>
					<th width="100">제목</th>
					<td colspan="5">${n.noticeTitle}</td>
				</tr>
				<tr>
					<th width="100">내용</th>
					<td colspan="3"><textArea rows="20" cols="80"
							id="noticeSubject" name="noticeSubject">${n.noticeSubject}</textArea></td>
				</tr>
				<tr>
					<th width="100">첨부파일</th>
					<td>${n.noticeAttech}</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${name eq n.noticeWriter}">
				<button type="button" onclick="noticeUpdate('E')">수정</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="noticeUpdate('D')">삭제</button>
			</c:if>
			<button type="button" onclick="location.href='noticelist.do'"></button>
		</div>
		<div>
			<form id="frm" method="post">
				<input type="hidden" id="noticeId" name="noticeId"
					value="${n.noticeId}">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function noticeUpdate(str){
			if(str == 'E'){
				document.getElementById("frm").action = "noticeditform.do";
			}
			else{
				document.getElementById("frm").action = "noticedelete";
			}
			document.getElementById("frm").submit();
		}
	</script>
</body>
</html>