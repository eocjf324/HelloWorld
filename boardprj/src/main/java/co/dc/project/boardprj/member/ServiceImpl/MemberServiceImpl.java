package co.dc.project.boardprj.member.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dc.project.boardprj.common.DataSource;
import co.dc.project.boardprj.member.Service.MemberService;
import co.dc.project.boardprj.member.Service.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public MemberVO searchId(MemberVO vo) {
		
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_TEL= ?";
		
		try {// DB 처리
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1 , vo.getMemberTel());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberAge(rs.getInt("member_age"));
				vo.setMemberGender(rs.getString("member_gender"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAddress(rs.getString("member_address"));
			}

		} catch (SQLException e) {

		} finally {
			close();
		}

		return vo;
	}

	@Override
	public MemberVO searchPassword(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	//로그인 아이디 확인
	@Override
	public MemberVO checkId(MemberVO vo) {
		
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? and member_password =? ";
		try {// DB 처리
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1 , vo.getMemberId());
			psmt.setString(2 , vo.getMemberPassword());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberAge(rs.getInt("member_age"));
				vo.setMemberGender(rs.getString("member_gender"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAddress(rs.getString("member_address"));
			}
		
		} catch (SQLException e) {

		} finally {
			close();
		}
		return vo;
	}

	@Override
	public MemberVO checkPassword(MemberVO vo) {
		
		return null;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
