<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<h1>게시글 등록</h1>
			</div>
			<div>
				<ul>
					<li>제목</li>
					<input type="text" id="title" name="title">
				</ul>
				<ul>
					<li>내용</li>
					<input type="text" id="subject" name="subject">
				</ul>
			</div>
		</form>
	</div>
</body>
</html>