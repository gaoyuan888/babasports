package gaoyuan.core.service.product;

import cn.itcast.common.page.Pagination;

public interface ProductService {
	public Pagination selectPaginationByQuery(Integer pageNo,String name,Long brandId,Boolean isShow);
}
