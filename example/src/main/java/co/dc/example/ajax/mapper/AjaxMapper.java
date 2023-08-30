package co.dc.example.ajax.mapper;

import java.util.List;

import co.dc.example.ajax.service.MembersVO;

public interface AjaxMapper {
	public int addMember(MembersVO vo);
	public int editMember(MembersVO vo);
	public int deleteMember(int memberId);
	public List<MembersVO> listMember();
}
