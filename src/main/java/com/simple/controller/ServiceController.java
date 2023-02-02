package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {

	//1st
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - service를 bean으로 생성한다. 의존객체 자동주입
	
	//3rd - @Service로 빈으로 생성하고, 의존객체 자동주입 ★
	@Autowired
	@Qualifier("service") // Qualifier를 통해, 이름을 통한 강제 연결이 가능함, 보통 멤버변수명을 따라감
	private ScoreService service;
	
	// 화면출력
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public String regist(ScoreVO vo) {
		
		service.regist(vo);
		
		return "service/scoreResult";
	}
	
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//data 조회
		ArrayList<ScoreVO> list = service.getList();
		
		model.addAttribute("list", list);
		
		return "service/scoreList";
	}
	
	// 삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		
		service.delete(num);
		return "redirect:/service/scoreList";
	}
	
}
