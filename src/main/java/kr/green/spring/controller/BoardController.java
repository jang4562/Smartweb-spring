package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVo;



@Controller
@RequestMapping(value="/bbs") 
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list")
	public String list(Model model,HttpServletRequest request, Criteria cri) {
	  
	  PageMaker pageMaker = boardService.getPageMaker(cri,5); //블록의 갯수 5개로 처리
    ArrayList list = (ArrayList)boardService.getUsers(cri);
    model.addAttribute("cri", cri);
    model.addAttribute("list", list);
    model.addAttribute("pageMaker", pageMaker);
    
		
		return "bbs/list";
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGet(BoardVo board) {
		return "bbs/register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(BoardVo board) {
		System.out.println(board);
		boardService.register(board);
		return "redirect:/bbs/list";
	}
}
