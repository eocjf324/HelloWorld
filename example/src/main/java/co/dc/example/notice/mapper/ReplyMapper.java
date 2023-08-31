package co.dc.example.notice.mapper;

import java.util.List;

import co.dc.example.notice.service.ReplyVO;

public interface ReplyMapper {
	public int addReply(ReplyVO vo);
	public int eidtReply(ReplyVO vo);
	public int delReply(int replyId);
	public ReplyVO getReply(int replyId);
	public List<ReplyVO> replylist(int noticeId);
	
	
}
