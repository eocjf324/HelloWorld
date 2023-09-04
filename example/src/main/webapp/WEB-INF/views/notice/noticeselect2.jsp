<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="./css/sb-admin-2.min.css" rel="stylesheet">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<style>
.cheader .replyerId {
	display: inline-block;
	width: 200px;
}

.cheader .replyer {
	float: right;
	display: inline-block;
}
</style>
<script src="./js/jquery.min.js"></script>

<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
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
					<td colspan="3"><textArea rows="4" cols="80"
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
			<!--  <button type="button" onclick="location.href='noticelist.do'"></button>-->
		</div>
		<div>
			<form id="frm" method="post">
				<input type="hidden" id="noticeId" name="noticeId"
					value="${n.noticeId}">
			</form>
		</div>
	</div>
	<!-- 댓글부분. -->

	<div>
		<label>댓글내용<input type="text" id="content"></label> <label>작성자<input
			type="text" id="writter"></label>
		<button id="addbtn">등록</button>
	</div>

	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</tfoot>
	</table>
	<!-- end -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
				</div>
				<div class="modal-body">
					<div class='form-group'>
						<label>Reply</label> <input class='form-control' name='reply'
							value='New Reply!!!!'>
					</div>
					<div class='form-group'>
						<label>Replyer</label> <input class='form-control' name='replyer'
							value='replyer'>
					</div>
					<div class='form-group'>
						<label>Reply Date</label> <input class='form-control'
							name='replyDate' value='replyDate'>
					</div>
				</div>
				<div class="modal-footer">
					<button id='modalModBtn' type="button" class="btn btn-warning"
						data-dismiss="modal">Modify</button>
					<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
					<button id='modalRegisterBtn' type="button" class="btn btn-default">Register</button>
					<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script src="./js/reply.js"></script>
	<script>
		var noticeId = '<c:out value="${n.noticeId}" />';
		console.log('notice: ', noticeId);

		const table = new DataTable('#example', {
			ajax : './AjaxDatatable.do?noticeId=' + noticeId,
			columns : [ {
				data : 'replyId'}, {
				data : 'reply'}, {
				data : 'replyer'}, {
				data : 'replyDate'} ]
		});
		//댓글등록
		$('#addbtn').on('click', function(){
			let content = $('#content').val();
			let writter = $('#writter').val();
			const reply = new Reply();
			const param = {
					noticeId,
					reply: content,
					replyer: writter
			}
			reply.replyAdd(param, function(data){
				addNewRow(data.data);
			})
		})
		
		function addNewRow(row) {
			 table.row
		        .add({
		        	replyId: row.replyId,
		        	reply: row.reply,
		        	replyer: row.replyer,
		        	replyDate: row.replyDate
		        	
				})
		        .draw(false);
		 
		    //counter++;
   
		}
		 
		
	</script>

	<script type="text/javascript">
		function noticeUpdate(str) {
			if (str == 'E') {
				document.getElementById("frm").action = "noticeditform.do";
			} else {
				document.getElementById("frm").action = "noticedelete";
			}
			document.getElementById("frm").submit();
		}
	</script>

</body>
</html>