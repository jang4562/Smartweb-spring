package kr.green.spring.service;

import java.util.ArrayList;
import java.util.List;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.vo.BoardVo;

public interface BoardService {

	void register(BoardVo board);
	
	List<BoardVo> getBoards();

	public PageMaker getPageMaker(Criteria cri, int i);

	public List<BoardVo> getUsers(Criteria cri);
}
