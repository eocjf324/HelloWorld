// 돔콘텐트로디드 이벤트가 발생하면 loadFunc 실행 
// 베이직html을 다 읽으면 여기를 읽으라는 뜻

$(loadFunc); // loadFunc를 실행한다는뜻 (간편해요)

function loadFunc() {
	var p = document.createElement('p'); // dom이라는 요소 (객체를 생성했음)
	
	var txt = document.createTextNode("Sample"); // text node.
	
	p.appendChild(txt); // txt는 p의 자식으로 붙임
	
	document.querySelector('body').appendChild(p); // 바디라는 요소를 찾아가서 만든 p요소를 자식으로 붙임

	var pTag = $('<p />') // 가로안에 있는 얘가 선택자 (jquery 객체) p 요소를 생성
	
	pTag.text("jquery sample"); // p태그 하위로 붙임
	
	$('.bdy').append(pTag); // 바디요소를 찾아와 pTag를 자식으로 붙인다
	// $(#bdy).append(pTag); = 바디 아이디로 하는법 클래스는 .으로 하면 됨
	console.log(p);
	console.log(pTag);
	
	var li = document.createElement('li');
	li.innerText = 'Apple'; // li = Apple을 가짐

	document.querySelector('body ul#list1').appendChild(li);
	// querySelectorAll을 하면 다 가져옴

	$('body ul#list1').append($('<li />').text('Banana'));
	// 제이쿼리 선택자로 바디안 ul의 아이디를 가져와 li를 자식요소로 지정하고 바나나라는 값을 텍스트에 넣어줌

}