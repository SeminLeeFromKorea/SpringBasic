package com.simple.score.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;

//@Component //@Repository //@Service //@Controller - 다 같은 놈들
@Service("service") // 빈의 이름 명시 - Qualifier의 이름과 동일한 애를 찾아서 강제로 연결해줌
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	@Qualifier("yyy")
	private ScoreDAO scoreDAO;
	
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
//		ArrayList<ScoreVO> list = scoreDAO.getList();
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		scoreDAO.delete(num);
		
	}
	
}
