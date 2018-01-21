package gaoyuan.core.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import gaoyuan.core.bean.product.ProductQuery;
import gaoyuan.core.bean.product.ProductQuery.Criteria;
import gaoyuan.core.dao.product.ProductDao;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	public Pagination selectPaginationByQuery(Integer pageNo,String name,Long brandId,Boolean isShow){
		
		ProductQuery productQuery=new ProductQuery();
		productQuery.setPageNo(Pagination.cpn(pageNo));
		productQuery.setPageSize(10);
		Criteria criteria = productQuery.createCriteria();
		StringBuilder params=new StringBuilder();
		if(null!= name){
			criteria.andNameLike("%"+name+"%");
			params.append("name=").append(name);
		}
		if(null!= brandId){
			criteria.andBrandIdEqualTo(brandId);
			params.append("&brandId=").append(brandId);
		}
		if(null!= isShow){
			criteria.andIsShowEqualTo(isShow);
			params.append("&isShow=").append(isShow);
		}else{
			criteria.andIsShowEqualTo(false);
			params.append("&name=").append(false);
		}
		Pagination pagination=new Pagination(
				productQuery.getPageNo(),
				productQuery.getPageSize(),
				productDao.countByExample(productQuery),
				productDao.selectByExample(productQuery)
		);
		
		String url="/product/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
		
	}
	
}
