package co.dc.example.ajax.service;

import java.util.List;

public interface MembersService {
	public boolean addMember(MembersVO vo);
	public boolean editMember(MembersVO vo);
	public boolean deleteMember(int mbrId);
	public List<MembersVO> listMember();
}
