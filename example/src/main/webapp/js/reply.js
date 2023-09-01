/**
 * reply.js
 */
class Reply {
	notUse() {
		//fetch 방식 
		fetch('AjaxReplyList.do?noticeId=6')
			.then(resolve => resolve.json())
			.then(json => {
				console.log(json);
			})
			.catch(console.log);
	}

	//댓글목록
	replyList(noticeId, callback) {
		// j query 방식 
		//$.getJSON("AjaxReplyList.do?noticeId=" + noticeId, function(data) {
		//	callback(data);
		//})
		//위에랑 같아요 
		$.ajax({
			url: "AjaxReplyList.do?noticeId=" + noticeId,
			success: function(data) {
				callback(data);
			}
		})
	}


	//댓글등록. 파라미터: 게시글번호, 댓글내용, 댓글작성자, 
	/*replyAdd(param = { noticeId, reply, replayer }, callback, errorcall) {
		//$.post("AjaxReplyAdd.do", param, function(data) {//post(url,param)
		//	callback(data);
		//})
		$.ajax({
			url: "AjaxReplyAdd.do",
			data: param,
			success: function(data) {
				callback(data);
			},
			error:function(err) {
				errorcall(err);
			}
		})
	}*/
	replyAdd(param = {noticeId, reply, replyer}, callback) {
		$.ajax({
			url: "AjaxReplyAddDataTable.do",
			data: param,
			success: function(data) {
				callback(data);
			}	
		})
	}

	//단건조회. param= replyId;
	replySearch(replyId, callback) {
		//$.post("AjaxReplySearch.do?rno=" + replyId, function(data) {//post(url,param)
		//	callback(data);
		//})
		$.ajax({
			url: "AjaxReplySearch.do?rno=" + replyId,
			success: function(data) {
				callback(data);
			}
		})
	}
	replyUpdate(param = { reply, replayer }, callback) {
		$.ajax({
			url: "AjaxReplyUpdate.do",
			data: param,
			success: function(data) {
				callback(data);
			}
		})

	}

	//문자열 -> 날짜포맷으로 변경.
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