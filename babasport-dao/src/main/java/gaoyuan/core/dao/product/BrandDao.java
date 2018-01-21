package gaoyuan.core.dao.product;

import java.util.List;

import gaoyuan.core.bean.product.Brand;
import gaoyuan.core.bean.product.BrandQuery;

public interface BrandDao {
	//查询结果集
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	//查询总条数
	public Integer selectCount(BrandQuery brandQuery);
	//通过ID查询品牌
	public Brand selectBrandById(long id);
	
	//修改
	public void updateBrandById(Brand brand);
	//删除
	public void deletes(Long[] ids);
}
