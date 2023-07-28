package co.dc.noticeprj.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dc.noticeprj.board.service.BoardService;
import co.dc.noticeprj.board.service.BoardVO;
import co.dc.noticeprj.common.DataSource;

public class BoardServiceImpl implements BoardService {

	private DataSource dao = DataSource.getInstance(); // DB 연결

	private Connection connection;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {
		String sql = "SELECT * FROM BOARD";
		List<BoardVO> boards = new ArrayList<BoardVO>();
		BoardVO vo;
		connection = dao.getConnection();
		try {
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardWriter(rs.getString("board_writer"));
				vo.setBoardTitle(rs.getString("board_title"));
				vo.setBoardDate(rs.getDate("board_date"));
				vo.setBoardHit(rs.getInt("board_hit"));
				boards.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boards;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		
		return null;
	}

	@Override
	public int boardInsert(BoardVO vo) {

		return 0;
	}

	@Override
	public int boardUpdate(BoardVO vo) { //내용만 변경할 수 있다.
		String sql = "UPDATE BOARD SET BOARD_SUBJECT = ? WHERE BOARD_ID = ?";
		int n=0;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, vo.getBoardSubject());
			psmt.setInt(2, vo.getBoardId());
			n = psmt.executeUpdate();
			
		}catch(SQLException e ) {
			
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		
		return 0;
	}
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
