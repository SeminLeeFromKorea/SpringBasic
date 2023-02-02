package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	//1. 화면
	@RequestMapping("/ex01") //입력경로
	public String ex01 () {
		return "response/ex01"; //출력경로
	}

	//result01요청 - model 객체
	@RequestMapping("/result01")
	public String result01(Model model) {

		model.addAttribute("data", "홍길동"); // 키, 값
		model.addAttribute("serverTime", new Date());

		return "response/result01";
	}

	//result02요청 - model & view 객체
	@RequestMapping("/result02")
	public ModelAndView result02() {

		// 뷰의 정보, data 정보를 함께 저장할 수 있는 객체
		ModelAndView mv = new ModelAndView();

		mv.addObject("data", "홍길동");
		mv.addObject("name", "이순신");
		mv.setViewName("response/result02");

		return mv;

	}

	//@ModelAttribute
	@RequestMapping("/result03")
	public String result03 (@ModelAttribute("num") String aaa) {

		return "response/result03";
	}


	@RequestMapping("/result04")
	public String result04 (@ModelAttribute("article") ReqVO vo) {

		System.out.println(vo.toString());

		return "response/result04";
	}


	/////////////////////////////////////////////////////////////////////////
	// redirect 이동과 redirectAttribute 비교
	// redirect는 스프링에서 다시 컨트롤러를 태우는 요청
	// redirectAttribute는 redirect 시에 1회성 데이터를 저장할 수 있습니다.

	//화면요청
	@RequestMapping("/redirect_login")
	public String loginView() {

		return "response/redirect_login";
	}

	//로그인 요청
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes ra) {
		//로그인 성공 ▷ home 화면으로
		if(id.equals(pw)) {
			
			ra.addFlashAttribute("msg", "어서와"); // 일회성 데이터
			return "redirect:/"; //다시 home 컨트롤러를 태워 보냄 - 리다이렉트는 model을 사용할 수 없음

			//로그인 실패
		} else {

			ra.addFlashAttribute("msg", "틀렸는데요?"); // 일회성 데이터
			return "redirect:/response/redirect_login"; // redirect:/절대경로
		}

	}


}
