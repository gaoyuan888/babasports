package gaoyuan.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import gaoyuan.core.bean.product.Brand;
import gaoyuan.core.service.product.BrandService;

/**
 * 品牌管理
 * 列表
 * 删除
 * 修改
 * 添加
 * 删除（单）
 * @author Administrator
 */
@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	//查询
	@RequestMapping(value="/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,Model model){
		Pagination pagination = brandService.selectPaginationByQuery(name, isDisplay, pageNo);
		 model.addAttribute("pagination",pagination);
		 model.addAttribute("name",name);
		 if(null!=isDisplay){
			 model.addAttribute("isDisplay",isDisplay);
		 }else{
			 model.addAttribute("isDisplay",1);
		 }
		return "brand/list";
	}
	//去修改页面
	@RequestMapping(value="/brand/toEdit.do")
	public String toEdit(Long id,Model model){
		Brand brand = brandService.selectBrandById(id);
		model.addAttribute("brand",brand);
		return "brand/edit";
	}
	//去修改页面
	@RequestMapping(value="/brand/edit.do")
	public String edit(Brand brand){
	    brandService.updateBrandById(brand);
		return "redirect:/brand/list.do";
	}
	@RequestMapping(value="/brand/deletes.do")
	public String deletes(Long[] ids){
		brandService.deletes(ids);
		return "forward:/brand/list.do";
	}
}
