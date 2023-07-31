package co.dc.project.boardprj.member.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.dc.project.boardprj.common.DataSource;
import co.dc.project.boardprj.member.Service.MemberService;
import co.dc.project.boardprj.member.Service.MemberVO;

public class MemberServiceImpl implements MemberService {

	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement psmt;
	private ResultSet rs;


	public boolean memberCheck(String id, String pw) {

		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? and member_password =? ";
		
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {

		} finally {
			close();
		}
		return false;
	}
	
	
	@Override
	public int memberInsert(MemberVO vo) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?)";
		int n = 0;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setInt(4, vo.getMemberAge());
			psmt.setString(5, vo.getMemberGender());
			psmt.setString(6, vo.getMemberTel());
			psmt.setString(7, vo.getMemberAddress());
			
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int n =0;
//		String sql = "update member set ";
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int n=0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			
		}finally{
			close();
		}
		return n;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1 , vo.getMemberId());
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
	

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
