package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model) {
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		
		model.addAttribute("year", vo.getYear());
		model.addAttribute("month", vo.getMonth());
		model.addAttribute("day", vo.getDay());
		
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		
		return "quiz/quiz02";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam("id") String id,
					   @RequestParam("pw") String pw,
					   @RequestParam("name") String name,
					   @RequestParam("email") String email,
					   Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping(value = "/join2", method = RequestMethod.POST)
	public String join2(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes ra,
						Model model) {
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check) || pw.equals("")) {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";			
		} else {
			model.addAttribute("id", id);
			return "/quiz/quiz03_ok";
		}
		
		
	}
	
}
