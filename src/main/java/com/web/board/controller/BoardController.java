package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.web.board.domain.Board;
import com.web.board.service.BoardService;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/board")
	public ModelAndView boardList(){
		List<Board> list = service.findAll();
		ModelAndView nextView = new ModelAndView("board/list");
		nextView.addObject("boardList", list);
		return nextView;
	}
	
	@GetMapping("/board/create")
	public ModelAndView createBoard() {
		ModelAndView nextView = new ModelAndView("board/create");
		return nextView;
	}
	
	@PostMapping("/board/create")
	public ModelAndView createBoard(Board board) {
		service.createBoard(board);
		ModelAndView nextView = new ModelAndView(new RedirectView("/board"));
		List<Board> list = service.findAll();
		nextView.addObject("boardList", list);
		return nextView;
	}
	
	@GetMapping("/board/{b_id}")
	public ModelAndView boardOneRead(@PathVariable("b_id") int b_id) {
		Board res = service.getOne(b_id);
		ModelAndView nextView = new ModelAndView("board/read");
		nextView.addObject("board", res);
		return nextView;
	}
	
	@GetMapping("/board/update/{b_id}")
	public ModelAndView updateBoard(@PathVariable("b_id") int b_id) {
		System.out.println("updateBoard get");
		Board res = service.getOne(b_id);
		ModelAndView nextView = new ModelAndView("board/update");
		nextView.addObject("board", res);
		return nextView;
	}
	
	@PostMapping("/board/update/{b_id}")
	public ModelAndView updateBoard(@PathVariable("b_id") int b_id, Board board) {
		System.out.println("updateBoard post");
		service.updateBoard(b_id, board);
		ModelAndView nextView = new ModelAndView(new RedirectView("/board/"+b_id));
		Board res = service.getOne(b_id);
		nextView.addObject("board", res);
		return nextView;
	}
//	@DeleteMapping
	@GetMapping("/board/delete/{b_id}")
	public ModelAndView deleteBoard(@PathVariable("b_id") int b_id) {
		service.deleteOne(b_id);
		ModelAndView nextView = new ModelAndView(new RedirectView("/board"));
		List<Board> list = service.findAll();
		nextView.addObject("boardList", list);
		return nextView;
	}
	
}
