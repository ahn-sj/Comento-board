package com.cmento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cmento.domain.BoardVO;
import com.cmento.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/")
@Log4j
public class BoardController {
	@Autowired
	private BoardService service;
	
	// -------------------------------------------------------------	
	// list and listAll read start 
	@GetMapping("/listAll")
	public void list(Model model) {
//		log.info("------------------------");
		log.info("/listAll ---> called listAll.jsp");
//		log.info("------------------------");
		
		model.addAttribute("list", service.listAll());
	}
	
	@GetMapping("/read")
	public void read(@RequestParam("bno")Integer bno, Model model) {
		log.info("/read ---> called read.jsp");
		model.addAttribute(service.read(bno));
	} 	// list and listAll read end
	// -------------------------------------------------------------
	
	// -------------------------------------------------------------
	// regist start
	@GetMapping("/regist")
	public void registGET() {
		log.info("/GET:regist ---> called read.jsp");
	}
	
	@PostMapping("/regist")
	public String registPOST(BoardVO board, RedirectAttributes rttr) {
//		log.info("------------------------");
		log.info("/POST:regist ---> regist BoardVO ---> called listAll.jsp");
//		log.info("------------------------");
		
		service.regist(board);
		
		return "redirect:/listAll";
	} // regist end
	// -------------------------------------------------------------
	
	
	// -------------------------------------------------------------
	// modify start
	@GetMapping("/modify")
	public void modifyGET() {
		log.info("/GET:modify ---> called modify.jsp");
	}
	
	@PostMapping("/modify")
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) {
//		log.info("------------------------");
		log.info("/modify ---> called modify.jsp");
//		log.info("------------------------");
		
		service.modify(board);
		
		return "redirect:/listAll";
	} 	// modify end
	// -------------------------------------------------------------
	
	// -------------------------------------------------------------
	// remove start
	@PostMapping("/remove")
	public String removePOST(@RequestParam("bno")Integer bno, RedirectAttributes rttr) {
//		log.info("------------------------");
		log.info("/remove ---> called remove.jsp");
//		log.info("------------------------");
		
		service.remove(bno);
		
		return "redirect:/listAll";
	} // remove end
	// -------------------------------------------------------------
}
