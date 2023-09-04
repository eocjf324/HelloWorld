/**
 * todo.js
 */

 class Todo{
	 
	 todoList(callback) {
		
		$.ajax({
			url: "../AjaxTodoList.do",
			success: function(data) {
				callback(data);
			}
		})
	}
	insertList(param={title,dueDate} , callback){
		$.ajax({
			url:"../AjaxInsertList.do",
			data: param,
			success:function(data){
				callback(data);
			}
		})
	}
	updateList(param = {listNum, complete},callback){
		$.ajax({
			url:"../AjaxUpdateList.do",
			data: param,
			success:function(data){
				callback(data);
			}
		})
	}
	deleteList(listNum, callback){
		$.ajax({
			url:"../AjaxDeleteList.do",
			data: listNum,
			success:function(data){
				callback(data);
			}
		})
	}
	displayDateTime(dateStr) {
		var mils = Date.parse('Aug 29,2023, 9:16:27 AM');//'Aug 29,2023, 9:16:27 AM'
		var today = new Date(mils);

		var yyyy = today.getFullYear(); //2023 
		var mm = "0" + (today.getMonth() + 1); // 1월 : 01 
		var dd = "0" + today.getDay();
		var hh = "0" + today.getHours();
		var mi = "0" + today.getMinutes();
		var ss = "0" + today.getSeconds();

		return yyyy + "-" + mm.slice(-2) + "-" + dd.slice(-2) + " " + hh.slice(-2) + ":" + mi.slice(-2) + ":" + ss.slice(-2);
	}
 }