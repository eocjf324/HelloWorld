package co.dc.project.boardprj.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dc.project.boardprj.board.service.BoardService;
import co.dc.project.boardprj.board.service.BoardVO;
import co.dc.project.boardprj.common.DataSource;

public class BoardServiceImpl implements BoardService {

	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {

		String sql = "SELECT * FROM BOARD ORDER BY BOARD_ID";
		List<BoardVO> boards = new ArrayList<BoardVO>();
		BoardVO vo;
		connection = dao.getConnection();
		try {
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardWriter(rs.getString("board_writer"));
				vo.setBoardTitle(rs.getString("board_title"));
				vo.setBoardSubject(rs.getString("board_subject"));
				vo.setBoardDate(rs.getDate("board_date").toLocalDate());
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
		String sql = "SELECT * FROM BOARD WHERE BOARD_ID  = ? ";

		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardWriter(rs.getString("board_writer"));
				vo.setBoardTitle(rs.getString("board_title"));
				vo.setBoardSubject(rs.getString("board_subject"));
				vo.setBoardDate(rs.getDate("board_date").toLocalDate());
				vo.setBoardHit(rs.getInt("board_Hit"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int boardInsert(BoardVO vo) {

		String sql = "INSERT INTO BOARD (BOARD_ID, BOARD_WRITER,BOARD_TITLE, BOARD_SUBJECT)VALUES(?,?,?,?)";
		int n = 0;
	
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardId());
			psmt.setString(2, vo.getBoardWriter());
			psmt.setString(3, vo.getBoardTitle());
			psmt.setString(4, vo.getBoardSubject());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	public int getBoardNum() {

		String sql = "SELECT MAX(BOARD_ID) FROM BOARD ";
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 1;
	}

	@Override
	public int boardUpdate(BoardVO vo) {

		String sql = "UPDATE BOARD SET BOARD_SUBJECT = ? WHERE BOARD_ID  = ? AND BOARD_WRITER = ? ";
		int n = 0;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, vo.getBoardSubject());
			psmt.setInt(2, vo.getBoardId());
			psmt.setString(3, vo.getBoardWriter());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {

		String sql = "DELETE BOARD WHERE BOARD_ID  = ? AND BOARD_WRITER = ?";
		int n = 0;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardId());
			psmt.setString(2, vo.getBoardWriter());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	@Override
	public int boardClear(String id) {

		String sql = "DELETE BOARD WHERE BOARD_WRITER = ?";
		int n = 0;
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, id);

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public void boardHit(BoardVO vo) {
		String sql = "UPDATE BOARD SET BOARD_HIT = BOARD_HIT + 1 WHERE BOARD_ID = ?";
		try {
			connection = dao.getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardId());
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

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
