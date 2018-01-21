package gaoyuan.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * 商品管理
 * 列表
 * 添加
 * 上架
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import gaoyuan.core.bean.product.Brand;
import gaoyuan.core.service.product.BrandService;
import gaoyuan.core.service.product.ProductService;
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private BrandService brandService;
	
	@RequestMapping(value="/product/list.do")
	public String list(Integer pageNo,String name, Long brandId, Boolean isShow,Model model){
		//品牌结果集
		List<Brand> brands = brandService.selectBrandListByQuery(1);
		model.addAttribute("brands", brands);
		Pagination pagination = productService.selectPaginationByQuery(pageNo, name, brandId, isShow);
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
		model.addAttribute("brandId", brandId);
		if(isShow!=null){
			model.addAttribute("isShow", isShow);
		}else{
			model.addAttribute("isShow", isShow);
		}
		return "/product/list";
	}
}
