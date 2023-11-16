package com.itwill.jpa.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.dto.ProductUpdateDto;
import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> selectList() {
		return productRepository.findAll();
	}

	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product selectProduct(Long no) {
		Product selectedProduct = productRepository.findById(no).get();
		return selectedProduct;
	}

	@Override
	public Product updateProduct(Product updateProduct) throws Exception{
		Optional<Product> findProductOptional = 
				productRepository.findById(updateProduct.getProductId());
		Product updatedProduct=null;
		if(findProductOptional.isPresent()) {
			Product product=findProductOptional.get();
			product.setName(updateProduct.getName());
			updatedProduct= productRepository.save(product);
		}else {
			throw new Exception("존재하지않는제품입니다.");
		}
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long no) throws Exception {
		Optional<Product> selectedProductOptional = productRepository.findById(no);
		if(selectedProductOptional.isEmpty()) {
			throw new Exception("존재하지않는제품입니다.");
		}
		productRepository.delete(selectedProductOptional.get());
	}

}





