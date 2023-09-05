/**
 * 
 */

 class Go{
	 
	  bookList(callback){
		 $.ajax({
			url: "./AjaxbookList.do",
			success: function(data) {
				callback(data);
			}
		})
	 }
	 insertBook(param = {code, title, author, press, price}, callback){
		 $.ajax({
			url: "./AjaxinsertBook.do",
			data:param,
			success: function(data) {
				callback(data);
			}
		})
	 }
	 deleteBook(bkCode, callback){
		  $.ajax({
			url: "./AjaxDeleteBook.do?bkCode="+bkCode,
			success: function(data) {
				callback(data);
			}
		})
	 }
 }