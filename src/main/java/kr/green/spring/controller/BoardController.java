package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/bbs") 
public class BoardController {
	@RequestMapping(value="/list")
	public String list() {
		return "bbs/list";
	}

}
