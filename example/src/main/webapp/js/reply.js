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
		$.getJSON("AjaxReplyList.do?noticeId=" + noticeId, function(data) {
			callback(data);
		})
	}
	
	//댓글등록. 파라미터: 게시글번호, 댓글내용, 댓글작성자, 
	replyAdd(param={noticeId, reply, replayer},callback){
		$.post("AjaxReplyAdd.do",param,function(data){//post(url,param)
			callback(data);	
		})
	}



}