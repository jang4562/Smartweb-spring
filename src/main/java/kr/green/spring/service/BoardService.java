package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.BoardVo;

public interface BoardService {

	void register(BoardVo board);
	
	List<BoardVo> getBoards();
}
