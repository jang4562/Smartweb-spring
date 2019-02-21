package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.vo.BoardVo;

public interface BoardDao {

	void setBoard(@Param("board")BoardVo board);
	
	List<BoardVo> getBoards();

	public int getCountUserLists(@Param("cri") Criteria cri); //페이징 처리시 필요

	public List<BoardVo> getUserLists(@Param("cri") Criteria cri);   //페이징처리시 필요
	
}
