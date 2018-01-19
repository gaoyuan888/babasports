package gaoyuan.core.service.product;

import cn.itcast.common.page.Pagination;

public interface BrandService {
	public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo);
}
