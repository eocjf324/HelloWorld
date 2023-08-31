package co.dc.example.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dc.example.common.DataSources;
import co.dc.example.notice.mapper.ReplyMapper;
import co.dc.example.notice.service.ReplyService;
import co.dc.example.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
	@Override
	public boolean addReply(ReplyVO vo) {
		
		return map.addReply(vo) == 1;
	}

	@Override
	public boolean eidtReply(ReplyVO vo) {
		
		return map.eidtReply(vo) ==1;
	}

	@Override
	public boolean delReply(int replyId) {
	
		return map.delReply(replyId) ==1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		
		return map.getReply(replyId);
	}

	@Override
	public List<ReplyVO> replylist(int noticeId) {
	
		return map.replylist(noticeId);
	}

}
