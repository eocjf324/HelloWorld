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
			<h1>게시판</h1>
		</div>
		<form action= "" id="frm" method="post">
			<select id="key" name="key">
				<option value="title">제목</option>
				<option value="subject">내용</option>
				<option value="writer">작성자</option>
			</select> <input type="text" id="val" name="val"> <input type="button"
				onclick="searchList()" value="검색">
		</form>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="50">번호</th>
						<th width="70">작성자</th>
						<th width="100">제목</th>
						<th width="100">작성일자</th>
						<th>첨부파일</th>
						<th width="60">조회수</th>
					</tr>
				</thead>


				<tbody align="center">
					<c:if test="${not empty notices }">
						<c:forEach items="${notices }" var="n">
							<tr onmouseover="this.style.background= '#0000FF'"
								onmouseout="this.style.background= '#FFFFFF'"
								onclick="selectNotice(${n.noticeId})">
								<td>${n.noticeId }</td>
								<td>${n.noticeWriter }</td>
								<td>${n.noticeTitle }</td>
								<td>${n.noticeDate }</td>
								<td>${n.noticeAttechDir }</td>
								<td>${n.noticeHit }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty notices}">
						<tr>
							<td colspan="6" align="center">데이터가 존재하지 않습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${not empty id }">
				<button type="button" onclick="location.href='noticeform.do'">글쓰기</button>
			</c:if>
		</div>
		<div>
			<form id="noticefrm" action = "noticeselect.do" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div>

	</div>

	<script type="text/javascript">
		function selectNotice(n){
			document.getElementById("noticeId").value = n;
			document.getElementById("noticefrm").submit();
		}
	</script>
</body>
</html>