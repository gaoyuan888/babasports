package gaoyuan.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gaoyuan.core.bean.Ceshi;
import gaoyuan.core.service.TestTbService;

@Controller
public class CenterController {
	
	@Autowired 
	private TestTbService testTbService;
	//入口
	/**
	 * ModelAndView : 跳转视图+数据    不用
	 * void          :异步时ajax
	 * String       :跳转视图 +Model
	 */
	@RequestMapping(value="/test/index.do")
	public String index(Model model){
		Ceshi cs=new Ceshi();
		cs.setName("范冰冰10");
		testTbService.insertTestTb(cs);
		return "index";
	}
	
}
