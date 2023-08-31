package co.dc.example.notice.service;

import java.util.List;

public interface ReplyService {
	public boolean addReply(ReplyVO vo);
	public boolean eidtReply(ReplyVO vo);
	public boolean delReply(int replyId);
	public ReplyVO getReply(int replyId);
	public List<ReplyVO> replylist(int i);
}
