<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery.min.js"></script>
<script src="./js/go.js"></script>
<style>

ul li {
	list-style: none;
}

li label {
	float: left;
	width: 100px;
}

table {
	clear: both;
}
</style>
</head>

<body>
	<div>
		<ul>
			<li><label>도서코드</label><input type="text" id="bk_code"></li>
			<li><label>도서명</label><input type="text" id="bk_title"></li>
			<li><label>저자</label><input type="text" id="bk_author"></li>
			<li><label>출판사</label><input type="text" id="bk_press"></li>
			<li><label>금액</label><input type="number" id="bk_price"></li>
		</ul>

		<div id="right">
			<button id="addBtn">저장</button>
			<button id="delBtn">선택삭제</button>
		</div>
	
	</div>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th><input class="" type="checkbox" id="check"></th>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list">

		</tbody>

	</table>
	<script>
		
		let go = new Go();
		//목록
		go.bookList(function(data) {
			console.log(data);
			
			for (let i = 0; i < data.length; i++) {
				const tr = document.createElement('tr');
				const td = document.createElement('td');
				tr.setAttribute('id', data[i].bkCode);
				//체크박스 생성
				const chk = document.createElement('input');
				chk.setAttribute('type', 'checkbox');
				
				td.appendChild(chk);
				tr.appendChild(td);
				//td 계속만들어주야지 data ㄱㄱ
				const fields = ['bkCode','bkTitle','bkAuthor','bkPress','bkPrice']
				fields.forEach(field =>{
					const td = document.createElement('td');
					td.innerText = data[i][field];
					tr.appendChild(td);
				})
			
				//버튼생성
				const button= document.createElement('button');
				button.innerText = "삭제";
				const btntd = document.createElement('td');
				btntd.appendChild(button);
				tr.appendChild(btntd);
				
				$('#list').append(tr);
			}
			
		})
		//등록 
		$('#addBtn').on('click',function () {
			var code = $("#bk_code").val();
			var title = $("#bk_title").val();
			var author = $("#bk_author").val();
			var press = $("#bk_press").val();
			var price = $("#bk_price").val();
			
			param = {code, title, author, press, price};

			go.insertBook(param, function (data) {
				console.log(data);
				const tr = document.createElement('tr');
				const td = document.createElement('td');
				tr.setAttribute('id', data.result.bkCode);
				
				const chk = document.createElement('input');
				chk.setAttribute('type', 'checkbox');
				
				td.appendChild(chk);
				tr.appendChild(td);
				
				const fields = ['bkCode','bkTitle','bkAuthor','bkPress','bkPrice']
				fields.forEach(field =>{
					const td = document.createElement('td');
					td.innerText = data.result[field];
					tr.appendChild(td);
				})
				const button= document.createElement('button');
				button.innerText = "삭제";
				const btntd = document.createElement('td');
				btntd.appendChild(button);
				tr.appendChild(btntd);
				
				$('#list').append(tr);
				$('input').val('');
			})
		})
		
		//삭제
		 $('tbody').on('click','button',function () {
			
			let bkCode = $(this).parent().parent().attr('id');
			let delTr = $(this).parent().parent();
			console.log(bkCode); 
			go.deleteBook(bkCode, function (data) {
				console.log(data);
				delTr.hide();
			})
		}) 
		
		//선택삭제  체크된 bkcode 개수만큼 삭제를 진행? for 문 돌려서 check면 삭제
		 $('#delBtn').on('click',function () {
			
			document.querySelectorAll('#list tr input:checked').forEach(input => {
					let bkcode = input.parentElement.parentElement.id;
					go.deleteBook(bkcode,function(data){
						 console.log(data);
					})
					input.parentElement.parentElement.remove();
	        })
		}) 
		
		//전체선택  체크하면 전체체크 /체크풀면 전체해제 
		 $('#check').on('click',function () {
		
			if ($(this).hasClass('checked')) {
				$('#check').toggleClass('checked');
				$('tr input').prop('checked', false);
			
			} else {
				$('#check').toggleClass('checked');
				$('tr input').prop('checked', true);
			}
		
		}) 

		
	</script>
</body>
</html>