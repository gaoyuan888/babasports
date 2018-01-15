package gaoyuan;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gaoyuan.core.bean.Ceshi;
import gaoyuan.core.dao.Daotest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class TestTbTest {
	@Autowired 
	private Daotest daotest;
	@Test
	public void testInsert(){
		Ceshi cs=new Ceshi();
		cs.setBirthday(new Date());
		cs.setName("bb");
		daotest.addTestTb(cs);
	}
}	
