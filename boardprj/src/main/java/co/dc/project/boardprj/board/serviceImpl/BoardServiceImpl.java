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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
