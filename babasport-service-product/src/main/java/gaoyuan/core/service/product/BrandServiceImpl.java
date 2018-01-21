package gaoyuan.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import gaoyuan.core.bean.product.Brand;
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
		brandQuery.setPageSize(2);
		//条件
		StringBuilder params=new StringBuilder();
		if(null!=name){
			brandQuery.setName(name);
			params.append("name=").append(name);
		}
		if(null!=isDisplay){
			brandQuery.setIsDisplay(isDisplay);
			params.append("&isDisplay=").append(isDisplay);
		}else{
			brandQuery.setIsDisplay(5);
			params.append("&isDisplay=").append(1);
		}
		Pagination pagination=new Pagination(
				brandQuery.getPageNo(),
				brandQuery.getPageSize(),
				brandDao.selectCount(brandQuery)
				);
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		String url="/brand/list.do";
		
		pagination.pageView(url, params.toString());
		
		return pagination;
	}

	@Override
	public Brand selectBrandById(Long id) {
		return brandDao.selectBrandById(id);
	} 
	@Override
	public void updateBrandById(Brand brand) {
		 brandDao.updateBrandById(brand);
	} 
	
	//删除
	public void deletes(Long[] ids){
		brandDao.deletes(ids);
	}

	@Override
	public List<Brand> selectBrandListByQuery(Integer isDisplay) {
		BrandQuery query=new BrandQuery();
		query.setIsDisplay(isDisplay);
		return brandDao.selectBrandListByQuery(query);
	}
}
