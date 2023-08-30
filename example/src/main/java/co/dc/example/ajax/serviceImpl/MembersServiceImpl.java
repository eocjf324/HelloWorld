package co.dc.example.ajax.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dc.example.ajax.mapper.AjaxMapper;
import co.dc.example.ajax.service.MembersService;
import co.dc.example.ajax.service.MembersVO;
import co.dc.example.common.DataSources;

public class MembersServiceImpl implements MembersService {
	
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	private AjaxMapper map = sqlSession.getMapper(AjaxMapper.class);
	@Override
	public boolean addMember(MembersVO vo) {
		
		return map.addMember(vo) == 1;
	}

	@Override
	public boolean editMember(MembersVO vo) {
	
		return map.editMember(vo) == 1;
	}

	@Override
	public boolean deleteMember(int memberId) {
		
		return map.deleteMember(memberId) == 1;
	}

	@Override
	public List<MembersVO> listMember() {
		
		return map.listMember();
	}
	
}
