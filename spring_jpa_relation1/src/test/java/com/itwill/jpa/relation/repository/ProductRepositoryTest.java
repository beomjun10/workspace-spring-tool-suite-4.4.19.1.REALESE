package com.itwill.jpa.relation.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;
import com.itwill.jpa.relation.entity.Provider;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	void productWithCategorySaveAndRead() {
		Category category=Category.builder().code("C1").name("컴퓨터").build();
		Product product1=Product.builder().name("EXCEL").price(3000).stock(30).build();
		Product product2=Product.builder().name("WORD").price(6000).stock(23).build();
		Product product3=Product.builder().name("POWERPOINT").price(2000).stock(56).build();
		/*
		 * 연관관계설정 Product-->Category
		 */
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);
		/*
		엔티티를 저장하고 변경 사항을 데이터베이스에 즉시 동기화합니다.
		- saveAndFlush
		 */
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		
		
		
		
		
	
	}
	
	
	
	@Test
	@Disabled
	void productWithProviderSaveAndRead() {
		Provider provider=Provider.builder()
						 .name("삼성출판사")
						.build();
		
		Product product=Product.builder()
						.name("삼성책")
						.price(10000)
						.stock(100)
					    .build();
		/***** 연관설정 Product-->Provider *****/
		product.setProvider(provider);
		productRepository.save(product);
		System.out.println("--------------read-------------");
		System.out.println(">>> Product:"+productRepository.findById(1L).get());
		System.out.println(">>> Product-->Provider:"+productRepository.findById(1L).get().getProvider());
	}
	
	@Test
	@Disabled
	void productWithProductDetailSaveAndRead() {
		
		ProductDetail productDetail=ProductDetail.builder()
				.description("어려워요!!!")
				.build();
		
		Product product=Product.builder()
						.name("스프링스큐리티")
						.price(60000)
						.stock(300)
						.build();
		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product-->ProductDetail
		 */
	    product.setProductDetail(productDetail);
	    productDetail.setProduct(product);
		productRepository.save(product);
	}
	
	
	
	
	
	
}