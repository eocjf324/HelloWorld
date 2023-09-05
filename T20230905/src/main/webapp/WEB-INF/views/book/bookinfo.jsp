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

/* 	#right{
		float: right;
	} */
</style>
</head>

<body>

	<div id="container">
		<div>
			<label>도서코드<input type="text" id="bk_code"></label><br>
			<label>도서명<input type="text" id="bk_title"></label><br>
			<label>저자<input type="text" id="bk_author"></label><br>
			<label>출판사<input type="text" id="bk_press"></label><br>
			<label>금액<input type="number" id="bk_price"></label><br>
		</div>
		<div id="right">
			<button id="addbtn">저장</button>
			<button id="delbtn">선택삭제</button>
		</div>
	</div>

	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>출판사</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list">
			<tr>

			</tr>
		</tbody>

	</table>
	<script>
		var go = new Go();
		
		go.bookList(function(data) {
			console.log(data);
			

			for (let i = 0; i < data.length; i++) {
				const tr = document.createElement('tr');
				const td = document.createElement('td');
			
				//체크박스 생성
				const chk = document.createElement('input');
				chk.setAttribute('type', 'checkbox');
				console.log(data[i].bkCode);
				td.appendChild(chk);
				//여기가 문제인데 td를 계속 생성
				
				td.append(data[i].bkCode);
				td.append(data[i].bkTitle);
				td.append(data[i].bkAuthor);
				td.append(data[i].bkPress);
				td.append(data[i].bkPrice); 
				
				//버튼생성
				const button= document.createElement('button');
				button.setAttribute('id','del');
				td.appendChild(button);
				tr.appendChild(td);
				
				$('#list').append(tr);
			}
			
		})
		$('#addBtn').on('click', function () {
			var code = $("#bk_code").val();
			var title = $("#bk_title").val();
			var author = $("#bk_author").val();
			var press = $("#bk_press").val();
			var price = $("#bk_price").val();
			
			param = {code, title, author, press, price}

			go.insertBook(param, function (data) {
				console.log(data);
				
			
			})
		})

		
	</script>
</body>
</html>