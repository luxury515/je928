package bowtech.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bowtech.model.Board;
import bowtech.model.BoardReply;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public List<Board> list(Board board) {
		return session.selectList("board.boardList", board);
	}	

	public int getTotal(Board board) {
		int total = 0;
		try {
			total = session.selectOne("board.boardTotal", board);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}

	public void boardHit(int brd_no) {
		session.update("board.boardHit", brd_no);
	}

	public Board boardSelect(int brd_no) {
		return session.selectOne("board.boardSelect", brd_no);
	}

	public int insertNo() {
		return session.selectOne("board.insertNo");
	}

	public int boardInsert(Board board) {
		int result = 0;
		try {
			result = session.insert("board.boardInsert", board);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public void updateRe_step(Board board) {
		session.update("board.updateRe_step", board);
	}

	public int boardUpdate(Board board) {
		int result = 0;
		try {
			result = session.update("board.boardUpdate", board);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public Board deletePwdChk(int number) {
		Board board = new Board();
		try {
			String passwd = session.selectOne("board.deletePwdChk", number);
			board.setM_passwd(passwd);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return board;
	}

	public int boardDelete(int number) {
		int result = 0;
		try {
			result = session.update("board.boardDelete", number);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public List<BoardReply> selectReply(int brd_no) {
		return session.selectList("reply.selectReply", brd_no);
	}
	
	public int replyNo() {
		return session.selectOne("reply.replyNo");
	}

	public int insertReply(BoardReply boardReply) {
		int result = 0;
		try {
			result = session.insert("reply.insertReply", boardReply);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int replyCount(int brd_no) {
		int total = 0;
		try {
			total = session.selectOne("reply.replyCount", brd_no);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}
	
	public int updateReply(BoardReply boardReply) {
		int result = 0;
		try {
			result = session.update("reply.updateReply", boardReply);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int deleteReply(int crNo) {
		int result = 0;
		try {
			result = session.update("reply.deleteReply", crNo);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	/*public BoardReply replyOne(int cr_no) {
		return session.selectOne("reply.replyOne", cr_no);
	}*/

	public int refTotal(int brd_no) {
		int total = 0;
		try {
			total = session.selectOne("board.refTotal", brd_no);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}

}
