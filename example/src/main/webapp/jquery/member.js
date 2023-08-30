/**
 * 
 */
console.log("member.js");

document.addEventListener("DOMContentLoaded", function() {
	// members.json 데이터 활용해서 초기데이터????
	fetch('../ajaxmemberlist.do') //  'members.json' 파일을 네트워크를 통해 가져옵니다. 이 부분은 프로미스를 반환합니다.
		.then(result => result.json()) // 첫 번째 프로미스가 성공적으로 완료되면, JSON 데이터를 추출하기 위해 .json() 메서드를 사용하여 다음 프로미스를 반환합니다.
		.then(json => {
			console.log(json);
			for (let i = 0; i < json.length; i++) { // json은 배열을 가지고 있기 때문에 for문을 이용해 객체를 생성함
				document.getElementById('list').appendChild(makeTr(json[i])); // makeTr에다가 json의배열값들을 넣어줌
			}
		})
		.catch(err => console.log(err))

	//버튼 클릭 이벤트
	document.getElementById('addBtn').addEventListener('click', addBtnFnc);
	document.getElementById('editBtn').addEventListener('click', editBtnFnc);

	function addBtnFnc() { // 버튼들의 아이디를 가져와서 클릭하면 함수를 실행

		let no = document.querySelector('#no').value;
		let name = document.querySelector('#name').value;
		let phone = document.querySelector('#phone').value;
		let age = document.querySelector('#age').value; // 변수에다가 exe1.html에 있는 아이디값을 넣어준다!

		if (!no || !name || !phone || !age) { // 값이 존재하지 않으면 경고창 띄우기
			alert("값을 입력해주세요.")
			return;
		}

		const memb = { no, name, phone, age }; // memb의 배열에다가 아이디값을 받은 변수이름을 넣어준다
		//json -> obj : JSON.parse()
		//obj -> json : JSON.stringify()
		//ajax call.
		fetch("../ajaxmemberadd.do", {
			method: 'post',
			headers: {
				//'Content-Type': 'application/x-www-form-urlencoded'}, key&value 방식
				'Content-Type': 'application/json'
			},
			//body: 'no=' + no+ '&name='+name+'&phone='+phone+'&age='+age
			body: JSON.stringify(memb)
		})
			.then(resolve => resolve.json()) //object를 json으로 바꿔준다고?
			.then(result => {
				console.log(result);
				if (result.returnCode == 'Success') {
					document.getElementById('list').appendChild(makeTr(result.result));
				} else if (result.returnCode == 'Fail') {
					alert(result.result);
				}
			})
			.catch(console.log)

		//document.getElementById('list').appendChild(makeTr(memb)); // MakeTr안에 memb의 값을 넣은걸 list의 자식으로 넣고 출력한다
		// initialize.

		const nodelist = document.querySelectorAll('table input'); // 테이블 인풋들의 값을 nodelist에 넣는다
		console.log(nodelist);

		nodelist.forEach(function(item) {
			item.value = "";

		})
	}
	function editBtnFnc() {
		let no = document.querySelector('#no').value;
		let name = document.querySelector('#name').value;
		let phone = document.querySelector('#phone').value;
		let age = document.querySelector('#age').value; 
	
		const target = document.getElementById('mem_' +no);
		//target.children[1].textContent = name;
		//target.children[2].textContent = phone;
		//target.children[3].textContent = age;

		fetch("../ajaxmemberedit.do", {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'no=' + no+ '&name='+name+'&phone='+phone+'&age='+age
		})
			.then(resolve => resolve.json())
			.then(result => {
				//console.log(result);
				if (result.returnCode == 'Success') {
					target.children[1].textContent = name;
					target.children[2].textContent = phone;
					target.children[3].textContent = age;
				} else if (result.returnCode == 'Fail') {
					alert(result.result);
				}
			})
			.catch();

	}

	function makeTr(member = {}) { //member 속성 이름 나이 등 있다
		let tr = document.createElement('tr'); // tr요소를 생성합니다

		tr.setAttribute('id', 'mem_' + member.mbrId);
		tr.setAttribute('data-no', member.mbrId);

		tr.addEventListener('click', function() {
			document.querySelector('#no').value = tr.children[0].innerHTML;
			document.querySelector('#name').value = tr.children[1].innerHTML;
			document.querySelector('#phone').value = tr.children[2].innerHTML;
			document.querySelector('#age').value = tr.children[3].innerHTML;
		});

		for (let field in member) { // 멤버안에 있는 변수만큼 tr을 생성합니다
			let td = document.createElement('td'); // td요소를 생성
			td.innerText = member[field]; // td에다가 멤버가 가지고 있는 필드를 생성
			tr.appendChild(td); // tr에다가 td를 자식으로 붙임
		}
		// 삭제버튼 만들어보자!
		let btn = document.createElement('button'); // 버튼을 생성합니다
		btn.addEventListener('click', deleteHandler);
		//this. 이벤트리스너 안에있는것들
		//console.log(this.parentElement.parentElement.value()); 이건 머야
		//console.log(this.parentElement.parentElement.remove()); 삭제 
		//console.log(tr.children[0].innerHTML); //테이블 첫번재 tr 값 가져옴 (번호) 
		//console.log(tr.children[1].innerHTML); // 2번째값 가져옴(이름)


		btn.innerText = '삭제'; // 버튼은 삭제기능을 하고싶어함
		let td = document.createElement('td');
		td.appendChild(btn); // td 자식으로 btn 넣어준다
		tr.appendChild(td);
		return tr; // tr반환 ( 자식들도 함께 )
	}
	function deleteHandler(e) {
		e.stopPropagation(); //event 전파되는것을 차단
		console.log(this.parentElement.parentElement.dataset.no);
		let delNo = this.parentElement.parentElement.dataset.no;
		fetch("../ajaxmemberdel.do", {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'no=' + delNo
		})
			.then(resolve => resolve.json())
			.then(result => {
				//console.log(result);
				if (result.returnCode == 'Success') {
					this.parentElement.parentElement.remove();
				} else if (result.returnCode == 'Fail') {
					alert(result.result);
				}
			})
			.catch();
	}
	//
})