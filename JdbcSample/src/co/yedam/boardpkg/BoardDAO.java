package co.yedam.boardpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements BoardService {
	
	Connection conn = null; // DB 연결 세션.
	PreparedStatement psmt;
	ResultSet rs;
	
	void getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이버가 없습니다.");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disConn() {
		try {
			if(conn != null)
				conn.close();
			if(psmt != null)
				psmt.close();
			if(rs != null)
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	//DB
	@Override
	public boolean login(String id, String pw) {
		
		String sql = "select * from users where user_id = ? and user_pw = ?";
		getConn();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2,  pw);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addBoard(Board board) {
		
		String sql = "insert into boards (board_no, title, content,writer, write_date)";
		sql += "values(?,?,?,?,?)";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBrdNo());
			psmt.setString(2,  board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getWriter());
			psmt.setString(5, board.getWriteDate());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환.
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disConn();
		}
		
		
		return false;
	}
	@Override
	public int getNextBoardNo() {
		String sql = "Select nvl(max(board_no),0) from boards";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disConn();
		}
		return 1;
	}

	@Override
	public boolean editBoard(Board board) {
		String sql = "update boards set content = ? where board_no = ?";
		getConn();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getContent());
			psmt.setInt(2, board.getBrdNo());
			int r = psmt.executeUpdate();
			if( r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		
		return false;
	}

	@Override
	public boolean delBoard(int brdNo) {
		String sql = "delete boards where board_no = ?";
		getConn();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNo);
			int r = psmt.executeUpdate();
			if( r== 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		return false;
	}

	@Override
	public List<Board> boardList() {
		String sql = "select * from boards";
		getConn();
		List<Board> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean modInfo(User user) {
		
		String sql = "update users set user_name = ?, user_pw = ? where user_id =?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserName());
			psmt.setString(2, user.getUserPw());
			psmt.setString(3, user.getUserId());
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		return false;
	}
	@Override
	public void exit() {
		
	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

}
