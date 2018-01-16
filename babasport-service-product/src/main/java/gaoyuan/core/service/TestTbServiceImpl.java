package gaoyuan.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gaoyuan.core.bean.Ceshi;
import gaoyuan.core.dao.Daotest;

@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService{
	@Autowired
	private Daotest daotest;
	
	public void insertTestTb(Ceshi ceshi){
		daotest.addTestTb(ceshi);
//		throw new RuntimeException();
	}
}
