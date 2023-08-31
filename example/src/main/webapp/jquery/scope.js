/**
 * 
 */
// var = 전역변수 ( 모든 페이지에서 사용가능)

let age = 10;

{
	let age = 20;
	console.log(age);
}
console.log(age);

var age2 = 30;
var localFnc = function() {
	// 로컬변수 지정
	age2 = 33;
	console.log(age2);
	age2 = 40;
}
localFnc;
console.log(age2);

const obj = {
	name: "Hong", // 값이 담겨지면 속성
	age: 20,
	info : function(){ // 함수가 담겨지면 메소드
		return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
	}
}

console.log(obj.name);
console.log(obj.info());

class Person {
	constructor(name, age){
		this.name = name;
		this.age = age;
	}
	
	showinfo(){
		return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
	}
}
const p1 = new Person("Hong", 25);
console.log(p1.showinfo());

Person.prototype.showName = function(){ // 프로토타입에다가 새로운걸ㄹ 넣음
	return this.name;
}

console.log(p1.showName);