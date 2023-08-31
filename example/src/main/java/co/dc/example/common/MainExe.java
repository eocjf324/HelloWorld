package co.dc.example.common;

import co.dc.example.notice.service.ReplyService;
import co.dc.example.notice.service.ReplyVO;
import co.dc.example.notice.serviceImpl.ReplyServiceImpl;

public class MainExe {
	public static void main(String[] args) {

		ReplyService service = new ReplyServiceImpl();

		ReplyVO reply = new ReplyVO();
		reply.setNoticeId(6);
		reply.setReply("매퍼테스트수정수정");
		reply.setReplyer("user1");
		reply.setReplyId(1);

		//service.eidtReply(reply);
		
		//reply = service.getReply(6);
		//service.delReply(22)
		// service.addReply(reply);
		System.out.println(service.eidtReply(reply));
		System.out.println("---------");
		service.replylist(6).forEach((vo) -> {
			System.out.println(vo);
		});
	}
}
