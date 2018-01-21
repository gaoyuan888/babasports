package gaoyuan.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import gaoyuan.core.bean.product.Brand;
import gaoyuan.core.bean.product.BrandQuery;

public interface BrandService {
	// 查询分页对象
	public Pagination selectPaginationByQuery(String name, Integer isDisplay, Integer pageNo);
	//查询结果集
	public List<Brand> selectBrandListByQuery(Integer  isDisplay);

	// 通过ID查询品牌
	public Brand selectBrandById(Long id);

	void updateBrandById(Brand brand);
	// 删除
	public void deletes(Long[] ids);
}
