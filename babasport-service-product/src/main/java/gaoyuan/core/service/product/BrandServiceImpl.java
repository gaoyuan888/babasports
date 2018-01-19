package gaoyuan.core.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import gaoyuan.core.bean.product.BrandQuery;
import gaoyuan.core.dao.product.BrandDao;

/**
 * 品牌管理
 * @author Administrator
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService{

	@Autowired 
	private BrandDao brandDao;
	
	//查询分页对象
	public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo){
		
		BrandQuery brandQuery=new BrandQuery();
		//当前页
		brandQuery.setPageNo(Pagination.cpn(pageNo));
		//每页数
		brandQuery.setPageSize(3);
		//条件
		if(null!=name){
			brandQuery.setName(name);
		}
		if(null!=isDisplay){
			brandQuery.setIsDisplay(isDisplay);
		}else{
			brandQuery.setIsDisplay(1);
		}
		Pagination pagination=new Pagination(
				brandQuery.getPageNo(),
				brandQuery.getPageSize(),
				brandDao.selectCount(brandQuery)
				);
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		return pagination;
	} 
}
