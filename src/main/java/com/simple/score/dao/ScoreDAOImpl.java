package com.simple.score.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO {

	//데이터베이스
	ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Override
	public void regist(ScoreVO vo) {
		
		//Database 처리, 지금은 가라로 구현
		list.add(vo); //insert
		System.out.println(list.toString());
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		//Database 조회
		
		
		return list;
	}

	@Override
	public void delete(int num) {
		list.remove(num);
	}

}
