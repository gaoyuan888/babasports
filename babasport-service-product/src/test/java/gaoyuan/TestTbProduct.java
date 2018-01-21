package gaoyuan;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gaoyuan.core.bean.product.Product;
import gaoyuan.core.bean.product.ProductQuery;
import gaoyuan.core.dao.product.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class TestTbProduct {
	@Autowired 
	private ProductDao productDao;
	@Test
	public void testInsert(){
//		Product product = productDao.selectByPrimaryKey(441L);
		
		ProductQuery query=new ProductQuery();
//		Criteria andBrandIdEqualTo = query.createCriteria().andBrandIdEqualTo(4L).andNameLike("%好莱坞%");
		query.setPageNo(2);
		query.setPageSize(10);
		query.setOrderByClause("id desc");
		query.setFields("id,brand_id");
		List<Product> selectByExample = productDao.selectByExample(query);
		int countByExample = productDao.countByExample(query);
		for (Product product : selectByExample) {
			System.out.println(product);
		}
	}
}	
