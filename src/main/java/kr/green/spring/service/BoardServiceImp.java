package kr.green.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public void register(BoardVo board) {
		boardDao.setBoard(board);
		
	}
	@Override
	public List<BoardVo> getBoards() {
		return boardDao.getBoards();
	}
  @Override
  public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
    int totalCount = boardDao.getCountUserLists(cri);
    
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCriteria(cri);
    pageMaker.setDisplayPageNum(displayPageNum);
    pageMaker.setTotalCount(totalCount);
    
    return pageMaker;
  }
  @Override
  public List<BoardVo> getUsers(Criteria cri) {
    return boardDao.getUserLists(cri);
  }
}
